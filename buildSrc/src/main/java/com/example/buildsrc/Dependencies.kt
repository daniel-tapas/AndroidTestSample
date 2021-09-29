object Libs {
    const val threeTen = "com.jakewharton.threetenabp:threetenabp:1.3.0"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val gson = "com.google.code.gson:gson:2.8.6"

    object Coroutines {
        private const val version = "1.4.3"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val playService = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val browser = "androidx.browser:browser:1.3.0"
        const val material = "com.google.android.material:material:1.2.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val viewPager2 = "androidx.viewpager2:viewpager2:1.0.0"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0"
        const val transition = "androidx.transition:transition:1.4.0"
        const val palette = "androidx.palette:palette:1.0.0"

        const val coreKtx = "androidx.core:core-ktx:1.3.2"

        object Navigation {
            private const val version = "2.3.5"

            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Activity {
            private const val version = "1.2.3"
            const val activityKtx = "androidx.activity:activity-ktx:$version"
        }

        object Fragment {
            private const val version = "1.3.4"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.3.1"

            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"

            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"

            const val process = "androidx.lifecycle:lifecycle-process:$version"
            const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
        }

        object Room {
            private const val version = "2.2.6"

            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val testing = "androidx.room:room-testing:$version"
        }

        object Work {
            private const val version = "2.5.0"

            const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
        }

        object Paging {
            private const val version = "2.1.2"

            const val runtime = "androidx.paging:paging-runtime-ktx:$version"
        }

        object Compose {
            const val version = "1.0.0-beta01"

            const val ui = "androidx.compose.ui:ui:$version"
            // Tooling support (Previews, etc.)
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            // Material Design
            const val material = "androidx.compose.material:material:$version"
            // Material design icons
            const val icon = "androidx.compose.material:material-icons-core:$version"
            const val iconExt = "androidx.compose.material:material-icons-extended:$version"
            // Integration with activities
            const val activity = "androidx.activity:activity-compose:1.3.0-alpha03"
            // Integration with ViewModels
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha02"
            // Integration with observables
            const val liveData = "androidx.compose.runtime:runtime-livedata:$version"

            // UI Tests
            const val test = "androidx.compose.ui:ui-test-junit4:$version"
        }

        object Test {
            private const val version = "1.2.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }

    }

    object Dagger {
        private const val version = "2.30.1"

        const val dagger = "com.google.dagger:dagger:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object AssistedInject {
        private const val version = "0.6.0"
        const val annotationDagger2 = "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
        const val processorDagger2 = "com.squareup.inject:assisted-inject-processor-dagger2:$version"
    }

    object Glide {
        private const val version = "4.12.0"

        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"

        const val transformation = "jp.wasabeef:glide-transformations:4.3.0"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.9.1"

        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val robolectric = "org.robolectric:robolectric:4.3"
        const val mockK = "io.mockk:mockk:1.10.0"
    }
}