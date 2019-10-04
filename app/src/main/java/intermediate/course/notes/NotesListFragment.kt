package intermediate.course.notes


import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import intermediate.course.R
import intermediate.course.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    // Fragment is attached to activity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RecyclerViewNote.layoutManager = LinearLayoutManager(context)
        val adapter = NoteAdapter(mutableListOf(
                Note("Description 1"),
                Note("Not another description qwqgwqwgqwgqwggqwgqwgqwgqwgqwgwqgqwgqwgqwgqwgqwgqwgqwg"),
                Note("Description 1"),
                Note("Description 1")
            ))
        RecyclerViewNote.adapter = adapter
    }

    companion object {
        fun newInstance() = NotesListFragment()  // short hand for functions similar to javascript
    }

}// Required empty public constructor
