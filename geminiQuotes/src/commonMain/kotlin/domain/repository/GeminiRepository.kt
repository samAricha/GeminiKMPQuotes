package domain.repository

import domain.model.QuoteRequestStatusModel

interface GeminiRepository {
    suspend fun generateQuote(
        prompt: String,
    ): QuoteRequestStatusModel

    fun getApiKey(): String

    fun setApiKey(key: String)
}
