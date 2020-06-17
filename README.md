#### BokuNoHeroAcademiaKMP
Kotlin multiplatform is a powerful tool, but pretty challenging to use if you're at the beginning of this path. What is this repository? With This repository I wanted to create a simple app that fetch a server, store the result in the local db and then fetch the local db to obtain a list of object and show them in a list.
The approach to kmp used in this project is the same used by [KaMPKit](https://github.com/touchlab/KaMPKit).

### How to run the app
##### Server
- Install [Deno](https://deno.land/#installation).
- Move in `server/`.
- Run 'deno run --allow-net index.ts'.

##### Android
- Get your local ip.
- Paste it into the `BokuNoHeroAcademiaMultiplatform/BokuNoHeroAcademiaMultiplatform/shared/src/commonMain/kotlin/com/corrado4eyes/bokunoheroacademiamultiplatform/ktor/BokuNoHeroAcademiaApiImpl.kt` line 36.
- Run and enjoy.

##### iOS (Still developing)
- Move into The android app.
- Run `./gradlew build`
- Run `./gradlew shared:podspec` in order to generate the podspec.
- Close every instance of xcode that is using the project.
- Run `./setupIos.sh` which is a custom bash file to delete `Pods/`, `.xcworspace` and the run `pod install`.
- Run `open BokuNoHeroAcademiaMultiplatform.xcworkspace`.
- Build the project.
- Run and enjoy.

### Useful links
Link I used to learn Kmp way:
###### Git repo
[KaMPKit](https://github.com/touchlab/KaMPKit),
 [Kaluga](https://github.com/splendo/kaluga),
 [Kotlin-Multiplatform-Libraries](https://github.com/AAkira/Kotlin-Multiplatform-Libraries)
###### KotlinLang courses
https://play.kotlinlang.org/hands-on/Targeting%20iOS%20and%20Android%20with%20Kotlin%20Multiplatform/01_Introduction,
 https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html,
 https://play.kotlinlang.org/hands-on/Kotlin%20Native%20Concurrency/00_Introduction
###### Other sources
https://dev.to/kuuurt/maximizing-code-sharing-between-android-and-ios-with-kotlin-multiplatform-54h8

### Stupid errors

**Library not loaded: @rpath/shared.framework/shared … Reason: Image not found.**
In case the IOS app fails at compile time with "Library not loaded: @rpath/shared.framework/shared .... Reason: Image not found.", in `Build Phases > Embedded Frameworks` the shared.framework in `projectRoot/shared/build/bin/ios/debugFramework/shared.framework`.

