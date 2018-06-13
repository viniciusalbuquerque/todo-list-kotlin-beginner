package com.example.viniciusalbuquerque.todotest.usecases

import com.android.volley.VolleyError
import com.example.viniciusalbuquerque.todotest.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import org.json.JSONObject

class AddTodoWrapperUserCase : OnRequestReponse {

    fun addTodoWrapper(title : String, todoWrapperDAO : TodoWrapperDAO) {
        todoWrapperDAO.create(TODOWrapper(-1, title), this)
    }

    override fun onRequestSuccess(response: Any) {
        // Parse to TodoWrapper
    }

    override fun onRequestError(error: Any) {
    }

}