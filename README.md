# note-kotlin-app

Types 

    - Unit  
        Defines a type of void - Which is returns nothing, or is nothing...
    - <T> 
        Default decaliration of Generanic type, accepts any type, including Unit


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


Companion objects instead of static

        In the Java programming language, the keyword static indicates that the particular member belongs to a type itself, rather than to an instance of that type.
        https://www.baeldung.com/java-static

        public static NotesListFragment newInstance() {
            NotesListFragment fragment = new NotesListFragment();
            return fragment;
        }

        companion object {

            fun newInstance(): NotesListFragment {
                return NotesListFragment()
            }
        }



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


Recycler View

    https://developer.android.com/guide/topics/ui/layout/recyclerview

    Method to display a large set of scrolling data.
        - Considered to be a more advanced method of in comparison to list view
        - Performance improvements
        - Horizontal view scrolling implemented by default
        - LayoutManager, allow for multiple columns
            - linearLayoutManager - list
            - GridLayoutManager - Multiple column list
        - Enforces ViewHolder pattern
            - View holders are assigned a single item with a view
                "defines presentation within the view holder, dependent on x information given"
                - responsible for which views need to be bonded
                    - which views to use
                    - which views to re-use
                    - which views should be created
                    - bonded views do not need to be re-created (DRY)
                - what position view is within the list of views (consider array elements)

        STEPS.
          - define xml file  for view
          - define view holder
                -interacting with an said object
                - how do we display that view that is defined with the object to the xml?
          - Handling callbacks and user interactions

        - Adapters
            Defines how we want to populate our lists

Add Abstraction to Adapters  // BaseRecyclerAdapter

    Original Note Adapter
            class NoteAdapter(
                private val noteList: MutableList<Note> = mutableListOf()
            ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
                    ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

                override fun getItemCount(): Int = noteList.size

                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    (holder as ViewHolder).onBind(noteList[position])
                }

                class ViewHolder (val view: View) : RecyclerView.ViewHolder(view) {

                    fun onBind(note: Note) {
                        view.apply {
                            descriptionView.text = note.description
                        }
                    }
                }

            }

    Abstracted Note Adapter

            class NoteAdapter(
                noteList: MutableList<Note> = mutableListOf()
            ) : BaseRecyclerAdapter<Note>(noteList) {

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
                    ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

                class ViewHolder (view: View) : BaseViewHolder<Note>(view) {
                    override fun onBind(data: Note) {
                        view.apply {
                            descriptionView.text = data.description
                        }
                    }

                }

            }

Programatically Add Custom Views


        Task Recycler View TaskAdapter.kt

            class TaskAdapter(
               taskList: MutableList<Task> = mutableListOf()  // default list for member variable of taskList automatically generated
            ): BaseRecyclerAdapter<Task>(taskList) {

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                    return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent,false))
                }

                class ViewHolder(view: View) : BaseViewHolder<Task>(view) {
                    override fun onBind(data: Task) {
                        view.titleView.text = data.title  // assign value to textView

                        // setup custom view & assign values
                        data.todos.forEach {todo ->
                            // inflate each todo and programatically attached it to a parent (todoContainer > view_todo)
                            val todoView = LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todoContainer, false)

                            // todoView holds our inflated view @view_todo
                            todoView.apply{
                                // now assign the values we want to the checkbox & textView found within @view_todo
                                descriptionView.text = todo.description

                            }
                        }
                    }
                }
            }


        Insert this view item_note.xml

            ?xml version="1.0" encoding="utf-8"?>
            <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
                    android:layout_width="match_parent"
                    android:layout_height="@dimen/simple_item_view_height"
                    xmlns:app="http://schemas.android.com/apk/res-auto">

                <TextView
                        android:id="@+id/descriptionView"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_marginStart="@dimen/item_margin_default"
                        android:layout_marginTop="@dimen/item_margin_default"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toTopOf="parent"
                        />

            </androidx.constraintlayout.widget.ConstraintLayout>


        Conceptually we will be adding children to this LinearLayout using the code above

            <LinearLayout
                    android:id="@+id/todoContainer"
                    android:orientation="vertical"
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toTopOf="parent"
                    app:layout_constraintTop_toBottomOf="@id/titleView"
                    app:layout_constraintEnd_toEndOf="parent"
                    >

                     // Insert - TextView id:descriptionView (found view_todo.xml)

            </LinearLayout>

View inflation attachToRoot true / false

           https://stackoverflow.com/questions/12567578/what-does-the-layoutinflater-attachtoroot-parameter-mean
           true:
                - will return the parent view
                - Add view as child of ViewGroup, which allows for touch events
                - Auto added to parent (sometimes might not want this!)
           false:
                - will return the inflated view
                - Does not add View as child so it will not receive events
                - Touch events can be added later with parent.addView()
                
                
Boolean Logic Crash Course!

            Add: descriptionView.setPaintFlags(descriptionView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            
            Remove: descriptionView.setPaintFlags(descriptionView.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
            
            Why does this work?
            
                    First, let's think of paint flags as a series of bits. A bit is either a 1 (true) or a 0 (false) and it can be flipped to enable a "state" or "flag".
                    
                    So let's assume that the default "state" for paint flags of a text view is the follow sequence of bits "10101000" (this is purely random and for educational purposes).
                    
                    Similar to how we use arithmetic operations in base 10 numbers (ie 5 + 2 = 7 with plus being an arithmetic operator), we can use boolean operations in base 2.
                    
                    1) One operation is the bitwise OR ( | ). It compares 2 bits and if EITHER ONE OR BOTH are true, then the result is true.
                    
                    For example (1001 | 1010) = 1011 because there was at least one "true" value in the 1st, 2nd, and 4th bit from the right.
                    
                    2) One operation is the bitwise AND ( & ). It compares 2 bits and if BOTH are true, then the result is true.
                    
                    For example (1001 & 1010) = 1000 because only the 4th bit from the right is both 1 & 1 = 1.
                    
                    3) The final operation I will cover is the bitwise inverse (~). This takes 1 bit, and flips every value (true -> false, false -> true).
                    
                    For example ~(1010) = (0101) since everything is flipped from 1 to 0 and 0 to 1.
            
            
            
            Now going back to our default state of paint flags, what if the 2nd bit from the right was the flag which determines whether the text has a strike through or not? How can we use boolean operations to change that single bit while keeping everything else the same? This way, all the other properties will be the same except the strike through.
            
            The solution is this:
            
                    Paint.StrikeThrough = 00000010 (in our hypothetical example)
                    
                    10101000 | 00000010 => 10101010
                    
                    Notice how everything is the same except the single bit we flipped. This is only possible using bitwise OR and the single flag!
                    
                    How about removing it? Now, our current flag state is 10101010.
                    
                    If Paint.StrikeThrough was the series of bits above, ~(Paint.StrikeThrough) = 11111101
                    
                    10101010 & 11111101 = 10101000.
                    
                    Notice how everything is the same except the single bit we flipped. This is only possible using bitwise AND and the inverse of the single flag!
                    
            
            
            There are numerous more cool things that we can do with boolean operations! However seeing as this is not an electrical engineering circuits course or a low level programming course, I just wanted to give you a very very fast intro into the world of boolean logic and why we use bitwise or vs bitwise and for the various operations.