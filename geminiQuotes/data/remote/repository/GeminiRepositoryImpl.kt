package data.remote.repository

import data.remote.GeminiService
import domain.model.ChatStatusModel
import domain.repository.GeminiRepository
import io.ktor.utils.io.errors.IOException

class GeminiRepositoryImpl : GeminiRepository {

    private val geminiService = GeminiService()

    override suspend fun generate(
        prompt: String,
        images: List<ByteArray>
    ): ChatStatusModel {
        return try {
            val response = when {
                images.isEmpty() -> geminiService.generateContent(prompt)
                else -> geminiService.generateContentWithMedia(prompt, images)
            }

            val status = response.error?.let {
                ChatStatusModel.Error(it.message)
            } ?: response.getText()?.let {
                ChatStatusModel.Success(it)
            } ?: ChatStatusModel.Error("A connection error occurred, please retry.")

            status

        } catch (e: IOException) {
            ChatStatusModel.Error("Unable to connect to the server. Please check your internet connection and try again.")
        } catch (e: Exception) {
            println("Gemini Error ${e.message}")
            ChatStatusModel.Error("An error has occurred, please retry.")
        }
    }

    override fun getApiKey(): String {
        return geminiService.getApiKey()
    }

    override fun setApiKey(key: String) {
        geminiService.setApiKey(key)
    }


}