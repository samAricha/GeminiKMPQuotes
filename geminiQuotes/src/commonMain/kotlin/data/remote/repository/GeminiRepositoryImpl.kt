package data.remote.repository

import data.remote.GeminiService
import domain.model.QuoteRequestStatusModel
import domain.repository.GeminiRepository
import io.ktor.utils.io.errors.IOException

class GeminiRepositoryImpl : GeminiRepository {

    private val geminiService = GeminiService()

    override suspend fun generateQuote(
        prompt: String,
    ): QuoteRequestStatusModel {
        return try {
            val response = geminiService.generateContent(prompt)
//            println("prompt response =====> $response")

            val status = response.error?.let {
                QuoteRequestStatusModel.Error(it.message)
            } ?: response.getText()?.let {
                QuoteRequestStatusModel.Success(it)
            } ?: QuoteRequestStatusModel.Error("A connection error occurred, please retry.")

            status

        } catch (e: IOException) {
            QuoteRequestStatusModel.Error("Unable to connect to the server. Please check your internet connection and try again.")
        } catch (e: Exception) {
//            println("Gemini Error ${e.message}")
            QuoteRequestStatusModel.Error("An error has occurred, please retry.")
        }
    }

    override fun getApiKey(): String {
        return geminiService.getApiKey()
    }

    override fun setApiKey(key: String) {
        geminiService.setApiKey(key)
    }


}