
# Gamini Quotes KMP Library
Gamini Quotes Library is a multiplatform library, enabling developers to easily
integrate Gemini into their KMP apps and get Quotes to improve UX OF their Android and desktop applications.

## 🛠️ Prerequisites 🛠️
#### IDE
You can either use [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Android Studio](https://developer.android.com/studio/).


> For Gemini AI.
#### Gemini Api Key
You can get your key here [Google AI Studio](https://makersuite.google.com/app/prompts/new_freeform) and pass it to the pass screen function.


## Supported Platforms(Currently...)
1. ### Android
2. ### Desktop


## Installation

Add the following dependency to your project's `build.gradle` file:

```gradle
dependencies {
    implementation("")
}
```  

## Usage

### Initialization

Initialize the Gemini chat Screen in your application:

```kotlin
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
```



## Built with
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) - The Kotlin Multiplatform technology is designed to simplify the development of cross-platform projects.
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) -  a modern UI framework for Kotlin that makes building performant and beautiful user interfaces easy and enjoyable.
- [Ktor Client](https://ktor.io/docs/getting-started-ktor-client.html) -  a multiplatform asynchronous HTTP client, which allows you to make requests and handle responses.
- [Gemini AI](https://deepmind.google/technologies/gemini) - a multi-modal large language model(LLM) developed by Google DeepMind.
- [Koin](https://insert-koin.io/) - The pragmatic Kotlin & Kotlin Multiplatform Dependency Injection framework.
- [Kotlinx-serilization](https://github.com/Kotlin/kotlinx.serialization) - Kotlin multiplatform / multi-format serialization.
- [VannikTech](https://github.com/vanniktech/gradle-maven-publish-plugin) - Gradle plugin that creates a publish task to automatically upload all
  of your Java, Kotlin or Android libraries to any Maven instance.
- [NMCP](https://github.com/GradleUp/nmcp) - A plugin that uses the new Central Portal publisher API to publish to Maven Central.
- [Dokka](https://github.com/Kotlin/dokka) - Dokka is an API documentation engine for Kotlin.




## License
```xml
Copyright (c) 2024 Aricha Samson

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
```  

  
