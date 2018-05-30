package com.example.viniciusalbuquerque.todotest.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.viniciusalbuquerque.todotest.R
import com.example.viniciusalbuquerque.todotest.Requests
import com.example.viniciusalbuquerque.todotest.fragments.AddToDoDialogFragment
import com.example.viniciusalbuquerque.todotest.models.adapters.ListOfTODOSAdapter
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.classes.URL_LIST_TODO
import com.example.viniciusalbuquerque.todotest.models.classes.dialogs.MyAlertDialog
import com.example.viniciusalbuquerque.todotest.models.classes.dialogs.MyProgressDialog
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(), View.OnClickListener, OnRequestReponse {

    private val TAG = MainActivity::class.java.name
    private lateinit var todoWrappers : ArrayList<TODOWrapper>
    private lateinit var requests: Requests
    private lateinit var listOfTODOSAdapter : ListOfTODOSAdapter
    private lateinit var progressDialog : AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requests = Requests(this)
        todoWrappers = getTodos()
        listOfTODOSAdapter = ListOfTODOSAdapter(this, todoWrappers as ArrayList<TODOWrapper>, this)

        recyclerViewListOfTODOS.adapter = listOfTODOSAdapter
        recyclerViewListOfTODOS.layoutManager = LinearLayoutManager(this)

        fabButtonConfig()


        progressDialog = MyProgressDialog().create(this, layoutInflater)
    }

    private fun fabButtonConfig() {
        fabNewTODOWrapper.setOnClickListener {
            openAddNewToDoDialog()
        }
    }

    private fun openAddNewToDoDialog() {
        val addDialog = AddToDoDialogFragment()
        addDialog.onClickListener = View.OnClickListener {
            val todoTitle = addDialog.editTextToDoText?.text.toString()
            saveToDoWrapper(todoTitle)
            Log.i(TODOActivity::class.java.simpleName, "Register new ToDo Wrapper")
            addDialog.dismiss()
        }

        addDialog.show(fragmentManager, addDialog.TAG)
    }

    private fun saveToDoWrapper(todoTitle: String) {
        val idTodoWrapper = if(todoWrappers.isEmpty()) 0 else todoWrappers.sortedBy { it.id }.last().id.plus(1)
        val todoWrapper = TODOWrapper(idTodoWrapper)
        todoWrapper.title = todoTitle

        todoWrappers.add(todoWrapper)
        listOfTODOSAdapter.notifyDataSetChanged()

    }


    override fun onResume() {
        super.onResume()
        progressDialog.show()
        requests.request(JSONObject(), URL_LIST_TODO, Request.Method.GET, this)
    }

    override fun onPause() {
        super.onPause()
        requests.requestQueue.cancelAll(URL_LIST_TODO)
    }

    override fun onClick(v: View?) {
        val adapterPosition = recyclerViewListOfTODOS.getChildAdapterPosition(v)
        val todo = this.todoWrappers.get(adapterPosition)

        val intent = Intent(this, TODOActivity::class.java).apply {
            this.putExtra(com.example.viniciusalbuquerque.todotest.activities.INTENT_TODO, todo)
        }
        startActivity(intent)
    }

    override fun onRequestSuccess(response: JSONObject) {
        Log.i(TAG, response.toString())
        progressDialog.dismiss()
        //GET TODO WRAPPERS FROM JSON
    }

    override fun onRequestError(error: VolleyError) {
        val message = if(error.message != null) error.message else "onRequestError"
        Log.i(TAG, message)
        progressDialog.dismiss()
        MyAlertDialog().create(this, message = message!!)
    }

    private fun getTodos(): ArrayList<TODOWrapper> {
        val todos = ArrayList<TODOWrapper>()
//        val todoW1 = TODOWrapper(1L)
//        todoW1.title = "22/05/2018"
//
//        val todos1 = ArrayList<TODO>()
//        todos1.apply {
//            this.add(TODO(1L,"Test 1"))
//            this.add(TODO(2L, "Test 2"))
//        }
//
//        todoW1.todoActivies = todos1
//
//        val todoW2 = TODOWrapper(2L)
//        todoW2.title = "23/05/2018"
//
//        val todos2 = ArrayList<TODO>()
//        todos2.apply {
//            this.add(TODO(1L,"Test 3"))
//            this.add(TODO(2L,"Test 4"))
//        }
//
//        todoW2.todoActivies = todos2
//
//        todos.add(todoW1)
//        todos.add(todoW2)

        return todos
    }
}



