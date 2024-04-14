package domain.model
sealed class QuoteRequestStatusModel {
    data object Idle : QuoteRequestStatusModel()
    class Success(val data: String) : QuoteRequestStatusModel()
    class Error(val message: String) : QuoteRequestStatusModel()
    data object Loading : QuoteRequestStatusModel()
    data object UnknownError : QuoteRequestStatusModel()
}