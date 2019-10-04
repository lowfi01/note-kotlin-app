package intermediate.course.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import intermediate.course.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    /*
        NOTE - Importing views from view_todo.xml
        Pass callback function to allow us to pass data between views
    */
    fun initView(todo: Todo, callback: (() -> Unit)? = null ) {
        descriptionView.text = todo.description
        completedCheckBox.isChecked = todo.isComplete
        if (todo.isComplete) {
            descriptionView.paintFlags =
                descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        setupCheckStateListener(todo, callback)
    }

    // Pass callback function to allow us to pass data between views
    fun setupCheckStateListener(todo: Todo, callback: (() -> Unit)? = null) {
        completedCheckBox.setOnCheckedChangeListener { _ , isChecked ->
            todo.isComplete = isChecked // assign complete to todo item
            callback?.invoke() // Nullable Callback, if it exists this is the data we pass back
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikeThrough()
            }
        }
    }

    // Line through todo item
    private fun createStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }



        //descriptionView.paintFlags = descriptionView!!.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    // Remove line through todo item
    private fun removeStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        //descriptionView.paintFlags = descriptionView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv() // inverse ~()
    }
}
