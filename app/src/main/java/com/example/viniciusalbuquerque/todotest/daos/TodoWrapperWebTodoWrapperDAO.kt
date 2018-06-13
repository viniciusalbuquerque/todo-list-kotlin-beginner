package com.example.viniciusalbuquerque.todotest.daos

import android.content.Context
import com.android.volley.Request
import com.example.viniciusalbuquerque.todotest.WebRequests
import com.example.viniciusalbuquerque.todotest.models.classes.*
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import org.json.JSONObject

class TodoWrapperWebTodoWrapperDAO(val context: Context) : TodoWrapperDAO {

    override fun create(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse) {
        WebRequests(context).request(JSONObject(), URL_ADD_TODO_WRAPPER, Request.Method.PUT, onRequestReponse)
    }

    override fun read(onRequestReponse: OnRequestReponse) {
        WebRequests(context).request(JSONObject(), URL_LIST_TODO_WRAPPER, Request.Method.GET, onRequestReponse)
    }

    override fun update(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse) {
        WebRequests(context).request(JSONObject(), URL_UPDATE_TODO_WRAPPER, Request.Method.POST, onRequestReponse)
    }

    override fun delete(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse) {
        WebRequests(context).request(JSONObject(), URL_REMOVE_TODO_WRAPPER, Request.Method.DELETE, onRequestReponse)
    }
}