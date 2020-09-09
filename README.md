### Useful links

https://play.kotlinlang.org/hands-on/Targeting%20iOS%20and%20Android%20with%20Kotlin%20Multiplatform/01_Introduction
https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html
https://github.com/AAkira/Kotlin-Multiplatform-Libraries
https://dev.to/kuuurt/maximizing-code-sharing-between-android-and-ios-with-kotlin-multiplatform-54h8
https://play.kotlinlang.org/hands-on/Kotlin%20Native%20Concurrency/00_Introduction

### Errors
In case the IOS app fails at compile time with "Library not loaded: @rpath/shared.framework/shared .... Reason: Image not found.", in `Build Phases > Embedded Frameworks` the shared.framework in `projectRoot/shared/build/bin/ios/debugFramework/shared.framework`.
