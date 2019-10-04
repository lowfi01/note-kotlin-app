package intermediate.course.foundations

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.tasks.TaskAdapter

// Takes type of generic
abstract class BaseRecyclerAdapter<T>(
    protected val masterList: MutableList<T> = mutableListOf() //protected is sharable to children
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = masterList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Check instance of type - instanceOf vs is
        if (holder is TaskAdapter.AddButtonViewHolder) {
            holder.onBind(Unit) // NOTE - Casting is automated if you are checking for instance of
        } else {
            (holder as BaseViewHolder<T>).onBind(masterList[position -1] ) // We must now subtract by 1 Always as we are adding a button view
        }
    }

    // Take type of generic
    abstract class BaseViewHolder<E>(protected val view: View): RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E)
    }
}