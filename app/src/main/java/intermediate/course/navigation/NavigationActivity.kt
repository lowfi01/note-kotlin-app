package intermediate.course.navigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import intermediate.course.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    // create Navigation listener, lamba implements call back (anonymous function item ->)
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_tasks -> {
                    messageTextView.setText(R.string.title_task)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notes -> {
                    messageTextView.setText(R.string.title_note)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        messageTextView.text = getString(R.string.title_task)
    }

}
