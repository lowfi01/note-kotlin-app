# note-kotlin-app


Include - Androidx (jetpack)  // current version of android studio includes this automatically
    - Androidx is a better package management system

    https://developer.android.com/jetpack/androidx

Icon pack - Material.io  // https://material.io/

    - Download icons using svg
           // assignment, notes

    https://material.io/resources/icons/?style=baseline

    - Add Vectors(svg) to Drawable
        // res>drawable>right click>vector asset> local file>rename>next>finish


Setup AndroidManifest with entry point of application
    <intent-filter>
                    <action android:name="android.intent.action.MAIN"/>
                    <action android:name="android.intent.action.VIEW"/>

                    <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>


Selecting Color Pallets

    https://colorhunt.co/

Class Comparison between Kotlin & Java

    All files must be a class.  - Java
    Kotlin defines constructor beside the class Name - Kotlin
    Kotlin can have default types declared in the constructor - Kotlin

            class JavaClass {
                public JavaClass() {

                }
            }

            class KotlinClass(val s: String = "default value") {

            }

lateinit

    Defers the assignment of a variable & implements nullable safety.

        private var title: String?
        private lateinit title: String


Getter & Setters in kotlin

    Kotlin automatically generates Setters and getter.


data class ClassName

    Adding data keyword to class will automatically generate generators in the background

                equals(), hashCode(), toString()






