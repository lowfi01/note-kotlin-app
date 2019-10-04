package intermediate.course.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.foundations.BaseRecyclerAdapter
import intermediate.course.models.Task
import intermediate.course.views.TodoView
import kotlinx.android.synthetic.main.item_task.view.*

// Convert construct from val to param by removing val
class TaskAdapter(
   taskList: MutableList<Task> = mutableListOf()  // default list for member variable of taskList automatically generated
): BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent,false))
    }

    // Convert construct from val to param by removing val
    class ViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            view.titleView.text = data.title
            
            // setup custom view & assign values
            data.todos.forEach { todo ->
                val todoView =  // Inflate View of view_todo & cast it to type of TodoView (custom view created)
                    (LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todoContainer, false) as TodoView)
                        .apply {
                            initView(todo)
                        }

                view.todoContainer.addView(todoView)  // Programmatically add view as a child of LinearLayout @todoContainer
            }
        }
    }
}