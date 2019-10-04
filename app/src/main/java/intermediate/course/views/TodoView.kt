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

    // NOTE - Importing views from view_todo.xml
    fun initView(todo: Todo) {
        descriptionView.text = todo.description
        completedCheckBox.isChecked = todo.isComplete
        if (todo.isComplete) {
            descriptionView.paintFlags =
                descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }

        setupCheckStateListener()
    }

    private fun setupCheckStateListener() {
        completedCheckBox.setOnCheckedChangeListener { _ , isChecked ->
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
