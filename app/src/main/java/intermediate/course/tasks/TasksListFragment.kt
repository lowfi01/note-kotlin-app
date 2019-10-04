package intermediate.course.tasks


import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import intermediate.course.R
import intermediate.course.models.Task
import intermediate.course.models.Todo
import kotlinx.android.synthetic.main.fragment_tasks_list.*


class TasksListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    // Right click, generate > override methods > onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // determine here if the fragment has been created

        // RecyclerViewTask = fragment_tasks_list recycler view item id
        RecyclerViewTask.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(mutableListOf(
            Task("Testing 1", mutableListOf(
                    Todo("Testing programatically adding views"),
                    Todo("Testing programatically adding views", true),
                    Todo("Testing programatically adding views", true),
                    Todo("Testing programatically adding views")
            )),
            Task("Testing 2"),
            Task("Testing 3"),
            Task("Testing 4")
        ))
        RecyclerViewTask.adapter = adapter


    }

    companion object {
        fun newInstance(): TasksListFragment {
            return TasksListFragment()
        }
    }

}// Required empty public constructor
