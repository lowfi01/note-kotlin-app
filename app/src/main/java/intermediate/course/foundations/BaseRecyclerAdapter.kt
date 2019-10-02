package intermediate.course.foundations

import android.view.View
import androidx.recyclerview.widget.RecyclerView

// Takes type of generic
abstract class BaseRecyclerAdapter<T>(
    protected val masterList: MutableList<T> = mutableListOf() //protected is sharable to children
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = masterList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder<T>).onBind(masterList[position])
    }

    // Take type of generic
    abstract class BaseViewHolder<E>(protected val view: View): RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E)
    }
}