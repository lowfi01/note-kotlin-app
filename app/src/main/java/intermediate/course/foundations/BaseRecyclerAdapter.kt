package intermediate.course.foundations

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.tasks.TaskAdapter
import kotlinx.android.synthetic.main.view_add_button.view.*

// Takes type of generic
abstract class BaseRecyclerAdapter<T>(
    protected val masterList: MutableList<T> = mutableListOf() //protected is sharable to children
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    /*
  * NOTE - if conditions return a type
  * generally you if conditions can be returned as a ternary or variable
  **/
    override fun getItemViewType(position: Int): Int = if (position == 0) {
        TYPE_ADD_BUTTON
    } else {
        TYPE_INFO
    }

    override fun getItemCount(): Int = masterList.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddButtonViewHolder) {
            holder.onBind(Unit)
        } else {
            (holder as BaseViewHolder<T>).onBind(masterList[position - 1])
        }
    }

    abstract class BaseViewHolder<E>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E)
    }

    abstract class AddButtonViewHolder(view: View): BaseViewHolder<Unit>(view)

    companion object {

        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1

    }

}