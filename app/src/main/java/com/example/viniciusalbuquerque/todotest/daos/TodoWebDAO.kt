package com.example.viniciusalbuquerque.todotest.daos

import android.content.Context
import com.android.volley.Request
import com.example.viniciusalbuquerque.todotest.WebRequests
import com.example.viniciusalbuquerque.todotest.models.classes.*
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import org.json.JSONObject

class TodoWebDAO(context: Context) : TodoDAO {
    private var webRequest : WebRequests = WebRequests(context)

    override fun create(todo: TODO, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_ADD_TODO, Request.Method.PUT, onRequestReponse)
    }

    override fun read(onRequestReponse: OnRequestReponse) {
        //nothing yet
    }

    override fun update(todoId: Long, todoWrapperId: Long, done: Boolean, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_UPDATE_TODO, Request.Method.POST, onRequestReponse)
    }

    override fun delete(todo: TODO, onRequestReponse: OnRequestReponse) {
        webRequest.request(JSONObject(), URL_REMOVE_TODO, Request.Method.DELETE, onRequestReponse)
    }

    override fun cancelRequests() {
        webRequest.cancellRequestsForTAG(URL_ADD_TODO)
//        webRequest.cancellRequestsForTAG(URL_LIST_TODO)
        webRequest.cancellRequestsForTAG(URL_UPDATE_TODO)
        webRequest.cancellRequestsForTAG(URL_REMOVE_TODO)
    }

}