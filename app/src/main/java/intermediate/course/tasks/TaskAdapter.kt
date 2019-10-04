package intermediate.course.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.foundations.BaseRecyclerAdapter
import intermediate.course.models.Task
import intermediate.course.views.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*

// Convert construct from val to param by removing val
class TaskAdapter(
   taskList: MutableList<Task> = mutableListOf()  // default list for member variable of taskList automatically generated
): BaseRecyclerAdapter<Task>(taskList) {
    companion object {
        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }

    /*
     * NOTE - if conditions return a type
     * generally you if conditions can be returned as a ternary or variable
     **/
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_ADD_BUTTON  // Top of recycler view
        } else {
            TYPE_INFO  // All other instances
        }
    }

    override fun getItemCount(): Int = masterList.size + 1 // remember we have add button view holder so we add +1

    /*
        * Conditional inflate the list of items or the Add_button view
        * Dependant on the getItemViewType
        * Top of the page should always have add task
        **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_INFO) {
            TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent,false))
        } else {
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent,false))
        }
    }

    // Convert construct from val to param by removing val
    class TaskViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)

//            view.titleView.text = data.title
//
//            // setup custom view & assign values
//            data.todos.forEach { todo ->
//                val todoView =  // Inflate View of view_todo & cast it to type of TodoView (custom view created)
//                    (LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todoContainer, false) as TodoView)
//                        .apply {
//                            initView(todo)
//                        }
//
//                view.todoContainer.addView(todoView)  // Programmatically add view as a child of LinearLayout @todoContainer
//            }
}
}

    class AddButtonViewHolder(view: View) : BaseViewHolder<Unit>(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_task)
        }
    }
}