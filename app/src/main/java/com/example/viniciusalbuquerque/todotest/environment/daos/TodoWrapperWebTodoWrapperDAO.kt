package com.example.viniciusalbuquerque.todotest.environment.daos

import android.content.Context
import com.android.volley.Request
import com.example.viniciusalbuquerque.todotest.environment.WebRequests
import com.example.viniciusalbuquerque.todotest.domain.daos.TodoWrapperDAO
import com.example.viniciusalbuquerque.todotest.models.classes.*
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnRequestReponse
import org.json.JSONObject

class TodoWrapperWebTodoWrapperDAO(context: Context) : TodoWrapperDAO {

    private var webRequest : WebRequests = WebRequests(context)

    override fun create(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_ADD_TODO_WRAPPER, Request.Method.PUT, onRequestReponse)
    }

    override fun read(onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_LIST_TODO_WRAPPER, Request.Method.GET, onRequestReponse)
    }

    override fun update(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_UPDATE_TODO_WRAPPER, Request.Method.POST, onRequestReponse)
    }

    override fun delete(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_REMOVE_TODO_WRAPPER, Request.Method.DELETE, onRequestReponse)
    }

    override fun cancelRequests() {
        webRequest.cancellRequestsForTAG(URL_ADD_TODO_WRAPPER)
        webRequest.cancellRequestsForTAG(URL_LIST_TODO_WRAPPER)
        webRequest.cancellRequestsForTAG(URL_UPDATE_TODO_WRAPPER)
        webRequest.cancellRequestsForTAG(URL_REMOVE_TODO_WRAPPER)
    }
}