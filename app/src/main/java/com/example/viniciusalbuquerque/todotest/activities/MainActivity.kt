package com.example.viniciusalbuquerque.todotest.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.viniciusalbuquerque.todotest.R
import com.example.viniciusalbuquerque.todotest.WebRequests
import com.example.viniciusalbuquerque.todotest.presenters.TodoWrapperPresenter
import com.example.viniciusalbuquerque.todotest.contracts.TodoWrapperContract
import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperWebTodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.fragments.AddToDoDialogFragment
import com.example.viniciusalbuquerque.todotest.interactors.TodoWrapperInteractor
import com.example.viniciusalbuquerque.todotest.models.adapters.ListOfTODOSAdapter
import com.example.viniciusalbuquerque.todotest.models.classes.KEY_SHARED_PREFERENCES
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.classes.URL_LIST_TODO
import com.example.viniciusalbuquerque.todotest.models.dialogs.MyAlertDialog
import com.example.viniciusalbuquerque.todotest.models.dialogs.MyProgressDialog
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(), View.OnClickListener, TodoWrapperContract.View {

    private val TAG = MainActivity::class.java.name
    private lateinit var todoWrappers : ArrayList<TODOWrapper>
    private lateinit var listOfTODOSAdapter : ListOfTODOSAdapter
    private lateinit var progressDialog : AlertDialog
    private lateinit var presenter : TodoWrapperContract.Presenter

    private lateinit var todoWrapperWebTodoWrapperDAO: TodoWrapperWebTodoWrapperDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoWrappers = ArrayList()
        listOfTODOSAdapter = ListOfTODOSAdapter(this, todoWrappers, this)

        recyclerViewListOfTODOS.adapter = listOfTODOSAdapter
        recyclerViewListOfTODOS.layoutManager = LinearLayoutManager(this)

        fabButtonConfig()
        progressDialog = MyProgressDialog().create(this, layoutInflater)

        todoWrapperWebTodoWrapperDAO = TodoWrapperWebTodoWrapperDAO(this)
        presenter = TodoWrapperPresenter(this, todoWrapperWebTodoWrapperDAO)

    }

    private fun fabButtonConfig() {
        fabNewTODOWrapper.setOnClickListener {
            presenter.fabAddTodoWrapperClicked()
        }
    }

    override fun showAddNewTodoWrapperDialog() {
        openAddNewToDoDialog()
    }

    private fun openAddNewToDoDialog() {
        val addDialog = AddToDoDialogFragment()
        addDialog.textTitle = "Register New List Of Tasks"
        addDialog.onClickListener = View.OnClickListener {
            val todoTitle = addDialog.editTextToDoText?.text.toString()
            presenter.addTodoWrapperDialogButtonClicked(todoTitle)
            Log.i(TODOActivity::class.java.simpleName, "Register new ToDo Wrapper")
            addDialog.dismiss()
        }

        addDialog.show(fragmentManager, addDialog.TAG)
    }

    override fun finishAddingNewTodoWrapper(todoWrapper : TODOWrapper) {
        todoWrappers.add(todoWrapper)
        listOfTODOSAdapter.notifyDataSetChanged()
    }

    override fun finishAddingNewTodoWrapperWithError(error: Any) {
        //Show error
    }

    override fun finishLoadingList(todoWrappers: ArrayList<TODOWrapper>) {
        this.todoWrappers = todoWrappers
        listOfTODOSAdapter.notifyDataSetChanged()
    }

    override fun finishLoadingListWithError(error: Any) {
        //Show error
    }

    override fun onResume() {
        super.onResume()
        progressDialog.show()
        presenter.listTodoWrappers()
    }

    override fun onPause() {
        super.onPause()
        presenter.cancelRequestsFromDAO()
    }

    override fun onClick(v: View?) {
        val adapterPosition = recyclerViewListOfTODOS.getChildAdapterPosition(v)
        val todo = this.todoWrappers.get(adapterPosition)

        val intent = Intent(this, TODOActivity::class.java).apply {
            this.putExtra(com.example.viniciusalbuquerque.todotest.activities.INTENT_TODO, todo)
        }
        startActivity(intent)
    }

}



