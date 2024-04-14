import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import geminikmpquotes.sample.composeapp.generated.resources.Res
import geminikmpquotes.sample.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.coroutineScope
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.teka.gemini_ai_cmp_chat_library.BuildKonfig


@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                showContent = !showContent
            }) {
                Text("Click me!")
            }

            val geminiQuotes = remember { GeminiQuotes(geminiKey = BuildKonfig.GEMINI_API_KEY) }
            var quoteData by remember { mutableStateOf<String?>(null) }

            LaunchedEffect(Unit) {
                coroutineScope {
                    val (responseData, isSuccess) = geminiQuotes.generateQuote("hi there")
                    println("Frontend response:  $responseData")
                    if (isSuccess) {
                        // Handle success, using responseData
                        quoteData = responseData ?: "No quote available" // Handling null data
                    } else {
                        // Handle error, using responseData
                        quoteData = responseData ?: "Unknown error" // Handling null error message
                    }
                }
            }


            AnimatedVisibility(showContent) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: ${quoteData ?: "Loading..."}")
                }
            }
        }
    }
}