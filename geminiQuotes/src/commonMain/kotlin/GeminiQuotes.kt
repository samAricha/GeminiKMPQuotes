
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.repository.GeminiRepository
import kotlinx.coroutines.launch
import data.remote.repository.GeminiRepositoryImpl
import domain.model.QuoteRequestStatusModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GeminiQuotes(
    geminiKey:String=""
) : ViewModel() {

    private val geminiRepository: GeminiRepository = GeminiRepositoryImpl()


    init {
            geminiRepository.setApiKey(key = geminiKey)
    }


    suspend fun generateQuote(message: String): Pair<String?, Boolean> {
        return withContext(Dispatchers.IO) {
            when (val response = geminiRepository.generateQuote(message)) {
                is QuoteRequestStatusModel.Success -> Pair(response.data, true)
                is QuoteRequestStatusModel.Error -> Pair(response.message, false)
                else -> Pair(null, false)
            }
        }
    }



}