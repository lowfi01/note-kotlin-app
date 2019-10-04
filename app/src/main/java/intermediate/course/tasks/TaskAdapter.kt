package intermediate.course.tasks

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.foundations.BaseRecyclerAdapter
import intermediate.course.models.Task
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*
import kotlinx.android.synthetic.main.view_todo.view.descriptionView

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
            data.todos.forEach {todo ->

                // inflate view, & apply view
                val todoView =
                    LayoutInflater
                        .from(view.context)
                        .inflate(R.layout.view_todo, view.todoContainer, false)
                        .apply {
                            descriptionView.text = todo.description
                            completedCheckBox.isChecked = todo.isComplete
                            if (todo.isComplete) {
                                descriptionView.paintFlags = descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                            }
                            // add Listener to view
                            completedCheckBox.setOnCheckedChangeListener { button, isChecked ->
                                // implement callback

                                if (isChecked){
                                    descriptionView.paintFlags = descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG// strike text
                                } else {
                                    descriptionView.paintFlags = descriptionView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv() // invert strike
                                }
                            }
                        }

                // Programmatically add view as a child of LinearLayout @todoContainer
                view.todoContainer.addView(todoView)
            }
        }
    }
}