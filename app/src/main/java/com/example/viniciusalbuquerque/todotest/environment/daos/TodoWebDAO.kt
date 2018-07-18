package com.example.viniciusalbuquerque.todotest.environment.daos

import android.content.Context
import com.android.volley.Request
import com.example.viniciusalbuquerque.todotest.environment.WebRequests
import com.example.viniciusalbuquerque.todotest.domain.daos.TodoDAO
import com.example.viniciusalbuquerque.todotest.models.classes.*
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnRequestReponse
import org.json.JSONObject

class TodoWebDAO(context: Context) : TodoDAO {
    private var webRequest : WebRequests = WebRequests(context)

    override fun create(todoWrapperId: Long, todoTitle: String, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_ADD_TODO, Request.Method.PUT, onRequestReponse)
    }

    override fun read(todoWrapperId: Long, onRequestReponse: OnRequestReponse) {
        val url = URL_LIST_TODO + "?id=" + todoWrapperId
        webRequest.request(JSONObject(), url, Request.Method.GET, onRequestReponse)
    }

    override fun update(todoWrapperId: Long, todoId: Long, done: Boolean, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_UPDATE_TODO, Request.Method.POST, onRequestReponse)
    }

    override fun delete(todoWrapperId: Long, todoId: Long, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_REMOVE_TODO, Request.Method.DELETE, onRequestReponse)
    }

    override fun cancelRequests() {
        webRequest.cancellRequestsForTAG(URL_ADD_TODO)
        webRequest.cancellRequestsForTAG(URL_LIST_TODO)
        webRequest.cancellRequestsForTAG(URL_UPDATE_TODO)
        webRequest.cancellRequestsForTAG(URL_REMOVE_TODO)
    }

}