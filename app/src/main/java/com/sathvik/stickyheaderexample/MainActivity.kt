package com.sathvik.stickyheaderexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sathvik.stickyheaderexample.entities.User

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = UserAdapter(createDummyObjects())

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        recyclerView.addItemDecoration(StickyHeaderItemDecoration(recyclerView, viewAdapter as UserAdapter))
    }

    fun createDummyObjects(): List<User> {
        val dummyObjects = ArrayList<User>()
        for(i in 1..5) {  //Repeating to just create more objects to show the scroll.
            dummyObjects += User("Year 1987", -1, true)
            dummyObjects += User("kevin", 542366390, false)
            dummyObjects += User("Christiano", 552129590, false)
            dummyObjects += User("Year 1990", -1, true)
            dummyObjects += User("Jake", 631531190, false)
            dummyObjects += User("Claire", 644231990, false)
            dummyObjects += User("Year 1992", -1, true)
            dummyObjects += User("Kumar", 697108790, false)
            dummyObjects += User("Harold", 715339190, false)
        }
        return dummyObjects
    }
}
