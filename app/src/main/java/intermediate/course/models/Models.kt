package intermediate.course.models

//public class Task {
//    public String title;
//    public Final constantVariable;
//    public Task(String s) {
//        // Constructor
//        title = s;
//    }
//}


// Note - @JvmOverloads constructor is only required if your call this kt file in java
data class Task @JvmOverloads constructor(
     var title: String,
     val todo: MutableList<Todo> = mutableListOf(), // assign empty mutable list, referring by type
     var tag: Tag? = null // can be null & default is set to null
) { // body is not required
    //Declare this within the constructor is enough
    //private lateinit var title: String
}

data class Todo(
     var description: String,
     var isComplete: Boolean
)

data class Note(
     var description: String,
     var tag: Tag? = null // can be null
)

data class Tag(
     val name: String,
     val colourResId: Int // R.colors.accent == Int
)
