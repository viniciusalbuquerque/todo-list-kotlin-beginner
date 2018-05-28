package com.example.viniciusalbuquerque.todotest.activities

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.viniciusalbuquerque.todotest.R
import com.example.viniciusalbuquerque.todotest.Requests
import com.example.viniciusalbuquerque.todotest.fragments.AddToDoDialogFragment
import com.example.viniciusalbuquerque.todotest.models.adapters.TODOAdapter
import com.example.viniciusalbuquerque.todotest.models.classes.*
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTODORequestMethods
import kotlinx.android.synthetic.main.activity_todos.*
import org.json.JSONObject

const val INTENT_TODO = "INTENT_TODO_EXTRA";
class TODOActivity : AppCompatActivity(), OnRequestReponse, OnTODORequestMethods {

    private lateinit var listOfActivities: ArrayList<TODO>
    var todoWrapper : TODOWrapper? = null
    var adapter : TODOAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        val actionBar = supportActionBar
        actionBar!!.elevation = 4.0F

        todoWrapper = getTodoFromIntent()

        Log.i(TODOActivity::class.java.simpleName, todoWrapper?.title)

        configLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            R.id.menu_action_add -> {
                openAddNewToDoDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openAddNewToDoDialog() {
        val addDialog = AddToDoDialogFragment()
        addDialog.onClickListener = View.OnClickListener {
            val todoTitle = addDialog.editTextToDoText?.text.toString()
            saveToDo(todoTitle)
            Log.i(TODOActivity::class.java.simpleName, "Register new ToDo")
            addDialog.dismiss()
        }

        addDialog.show(fragmentManager, addDialog.TAG)
    }

    private fun saveToDo(todoTitle: String) {
        val lastId = listOfActivities.sortedBy { it.id }.last().id
        val todo = TODO(lastId.plus(1), todoTitle)
        listOfActivities.add(todo)
        adapter?.notifyDataSetChanged()
    }

    private fun configLayout() {
        activityTodoTextViewTitle.text = todoWrapper?.title
        listOfActivities = ArrayList(todoWrapper?.todoActivies!!)
        adapter = TODOAdapter(this, todoWrapper?.id!!, listOfActivities, this)
        activityTodoRecyclerViewTodos.adapter = adapter
        activityTodoRecyclerViewTodos.layoutManager = LinearLayoutManager(this)
    }

    private fun getTodoFromIntent(): TODOWrapper? {
        return intent.extras.get(INTENT_TODO) as TODOWrapper?
    }

    fun getTODOJSON(todoWrapperID: Long, todoID: Long) : JSONObject {
        val json = JSONObject()
        json.put(KEY_PARAM_TODO_WRAPPER_ID, todoWrapperID)
        json.put(KEY_PARAM_TODO_ID, todoID)
        return json
    }

    override fun addTODO(todoWrapperID: Long, todoID: Long) {
        val json = getTODOJSON(todoWrapperID, todoID)
        Requests(this).request(json, URL_ADD_TODO, Request.Method.PUT, this)
    }

    override fun removeTODO(todoWrapperID: Long, todoID: Long) {
        val json = getTODOJSON(todoWrapperID, todoID)
        Requests(this).request(json, URL_REMOVE_TODO, Request.Method.POST, this)
    }

    override fun onRequestSuccess(response: JSONObject) {
        Log.i("TODOActivity", response.toString()) //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestError(error: VolleyError) {
        Log.i("TODOAcVolleyError:", error.message)
    }
}