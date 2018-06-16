package com.example.viniciusalbuquerque.todotest.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.viniciusalbuquerque.todotest.R
import com.example.viniciusalbuquerque.todotest.R.id.*
import com.example.viniciusalbuquerque.todotest.WebRequests
import com.example.viniciusalbuquerque.todotest.contracts.TodoContract
import com.example.viniciusalbuquerque.todotest.fragments.AddToDoDialogFragment
import com.example.viniciusalbuquerque.todotest.models.adapters.TODOAdapter
import com.example.viniciusalbuquerque.todotest.models.classes.*
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnTODORequestMethods
import com.example.viniciusalbuquerque.todotest.presenters.TodoPresenter
import kotlinx.android.synthetic.main.activity_todos.*
import org.json.JSONObject

const val INTENT_TODO = "INTENT_TODO_EXTRA"
class TODOActivity : AppCompatActivity(), OnTODORequestMethods, TodoContract.View {

    private lateinit var listOfActivities: ArrayList<TODO>
    private lateinit var todoWrapper : TODOWrapper
    private lateinit var adapter : TODOAdapter
    private lateinit var presenter : TodoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        val actionBar = supportActionBar
        actionBar!!.elevation = 4.0F

        todoWrapper = getTodoFromIntent()

        Log.i(TODOActivity::class.java.simpleName, todoWrapper.title)

        configLayout()
        fabButtonConfig()

        presenter = TodoPresenter(this)
    }

    private fun fabButtonConfig() {
        fabNewTODO.setOnClickListener {
            presenter.fabAddTodoClicked()
        }
    }

    private fun openAddNewToDoDialog() {
        val addDialog = AddToDoDialogFragment()
        addDialog.onClickListener = View.OnClickListener {
            val todoTitle = addDialog.editTextToDoText?.text.toString()
            presenter.addTodoDialogButtonClicked(todoWrapper.id, todoTitle)
            Log.i(TODOActivity::class.java.simpleName, "Register new ToDo")
            addDialog.dismiss()
        }
        addDialog.show(fragmentManager, addDialog.TAG)
    }

    private fun configLayout() {
        activityTodoTextViewTitle.text = todoWrapper.title
        var todoActivies = todoWrapper.todoActivies
        if(null == todoActivies)
            todoActivies = ArrayList()

        listOfActivities = todoActivies
        adapter = TODOAdapter(this, todoWrapper.id, listOfActivities, this)
        activityTodoRecyclerViewTodos.adapter = adapter
        activityTodoRecyclerViewTodos.layoutManager = LinearLayoutManager(this)
    }

    private fun getTodoFromIntent(): TODOWrapper {
        return intent.extras.get(INTENT_TODO) as TODOWrapper
    }

    override fun showAddNewTodoDialog() {
        openAddNewToDoDialog()
    }

    override fun finishedAddingTodo(todo: TODO) {
        listOfActivities.add(todo)
        adapter.notifyDataSetChanged()
    }

    override fun finishedAddingTodoWithError(error: Any) {
        //Show error
    }

    override fun finishedRemovingTodo(todo: TODO) {
        listOfActivities.remove(todo)
        adapter.notifyDataSetChanged()
    }

    override fun finishedRemovingTodoWithError(error: Any) {
        //Show error
    }

    override fun addTODO(todoWrapperID: Long, todoID: Long) {
        presenter.updateTodo(todoWrapperID, todoID, true)
    }

    override fun removeTODO(todoWrapperID: Long, todoID: Long) {
        presenter.updateTodo(todoWrapperID, todoID, false)
    }
}