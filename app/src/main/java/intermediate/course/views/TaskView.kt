package intermediate.course.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import intermediate.course.R
import intermediate.course.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskView @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {
    lateinit var task: Task

    // When all todos are completed - ALL tasks should be checked off
    fun initView(task: Task){
        this.task = task


        titleView.text = task.title
        task.todos.forEach { todo ->
            val todoView =  // Inflate View of view_todo & cast it to type of TodoView (custom view created)
                (LayoutInflater.from(context).inflate(R.layout.view_todo, todoContainer, false) as TodoView)
                    .apply {
                        initView(todo) {
                            // Implement Callback
                            if (isTaskComplete()) {
                                createStrikeThrough()
                            } else {
                                removeStrikeThrough()
                            }
                        }
                    }
            todoContainer.addView(todoView)
        }



    }

    // Filter this.task to check all todos & if result return nothing return true else false
    fun isTaskComplete() : Boolean = task.todos.filter { !it.isComplete }.isEmpty()


    // Line through todo item
    private fun createStrikeThrough() {
        titleView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    // Remove line through todo item
    private fun removeStrikeThrough() {
        titleView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

}