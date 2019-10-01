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


Convert Java to Kotlin

    Code > Convert Java file to kotlin

Add Constraint & Margins using XML

     android:layout_width="match_parent"  // Match the width of the parent
     android:layout_height="wrap_content"  // Match the height of the content & grow as needed
     app:layout_constraintStart_toStartOf="parent"  // constraintS - left constraint
     app:layout_constraintTop_toTopOf="parent"  // constraintTo - top constraint
     android:layout_marginStart="16dp" // marg - left margin
     android:layout_marginTop="16dp"   // marg - top margin


Fragments

   https://developer.android.com/guide/components/fragments

   A Fragment represents a behavior or a portion of user interface in a FragmentActivity.
            - Fragments are a portion of a activity.
            - Encourages a dynamic UI
            - Modular, - re-usable
            - Has to be hosted in an activity
            - Has its own lifecycle

            - Swap Fragments using a fragment manager
                - The act of swapping fragments are transactions, - Add, - Remove, - Replace

            - Back stack
                - Add fragments to back stack every transaction.
                - Allows reverse animation when the user decides to hit back
                        ("pop the back stack to reverse the transaction and navigate backwards")


            - Use Case, News Application
                 - One Fragment on the left to show new articles
                 - One Fragment on the right to Display an article

            - Use Case, Notes Application
                 - Two Fragments which exist & are inter-changeable within the same activity (navigation)
                 - Bottom menu navigation, Will allow One Fragment to be viewed
                    - Notes Fragment, shows on notes selection
                    - Tasks Fragment, shows on tasks selection

Fragment LifeCycle

        https://developer.android.com/guide/components/fragments
        // reference the Creating a Fragment section

Fragment, How to communicate between Fragment and Activity?

        https://developer.android.com/guide/components/fragments
        // reference Creating event callbacks to the activity section

        Implement an interface, which can be used as a listener within the activity,
            - when a fragment is attached to an activity we can cast activity to be the specific listener
            - we can then implement hooks within the fragment which can call the listener.


             -Kotlin

                public class FragmentA : ListFragment() {
                    ...
                    // Container Activity must implement this interface
                    interface OnArticleSelectedListener {
                        fun onArticleSelected(articleUri: Uri)
                    }
                    ...
                }

              - Java

                public static class FragmentA extends ListFragment {
                    ...
                    // Container Activity must implement this interface
                    public interface OnArticleSelectedListener {
                        public void onArticleSelected(Uri articleUri);
                    }
                    ...
                }


