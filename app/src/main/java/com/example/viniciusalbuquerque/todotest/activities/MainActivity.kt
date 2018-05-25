package com.example.viniciusalbuquerque.todotest.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.viniciusalbuquerque.todotest.R
import com.example.viniciusalbuquerque.todotest.models.adapters.ListOfTODOSAdapter
import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "MainActivity";
    private var todoWrappers : List<TODOWrapper>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoWrappers = getTodos()
        val listOfTODOSAdapter = ListOfTODOSAdapter(this, todoWrappers as ArrayList<TODOWrapper>, this)

        recyclerViewListOfTODOS.adapter = listOfTODOSAdapter
        recyclerViewListOfTODOS.layoutManager = LinearLayoutManager(this)

        Log.i(TAG, "Loaded adapter")

    }

    override fun onClick(v: View?) {
        val adapterPosition = recyclerViewListOfTODOS.getChildAdapterPosition(v)
        val todo = this.todoWrappers?.get(adapterPosition)

        val intent = Intent(this, TODOActivity::class.java).apply {
            this.putExtra(com.example.viniciusalbuquerque.todotest.activities.INTENT_TODO, todo)
        }
        startActivity(intent)
    }

    private fun getTodos(): ArrayList<TODOWrapper> {
        val todos = ArrayList<TODOWrapper>()
        val todoW1 = TODOWrapper(1L)
        todoW1.title = "22/05/2018"

        val todos1 = ArrayList<TODO>()
        todos1.apply {
            this.add(TODO(1L,"Test 1"))
            this.add(TODO(2L, "Test 2"))
        }

        todoW1.todoActivies = todos1

        val todoW2 = TODOWrapper(2L)
        todoW2.title = "23/05/2018"

        val todos2 = ArrayList<TODO>()
        todos2.apply {
            this.add(TODO(1L,"Test 3"))
            this.add(TODO(2L,"Test 4"))
        }

        todoW2.todoActivies = todos2

        todos.add(todoW1)
        todos.add(todoW2)

        return todos
    }
}



