package intermediate.course.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intermediate.course.R
import intermediate.course.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(
    private val taskList: MutableList<Task> = mutableListOf()  // default list for member variable of taskList automatically generated
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent,false))
    }

    override fun getItemCount(): Int = taskList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // CAST holder: RecyclerView.ViewHolder to type of viewholder
        (holder as ViewHolder).onBind(taskList[position])
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(task: Task) {
            view.titleView.text = task.title
        }
    }
}