package com.example.viniciusalbuquerque.todotest.environment

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnRequestReponse
import org.json.JSONObject

class WebRequests(context: Context) {

    private val requestQueue : RequestQueue

    init {
        requestQueue = Volley.newRequestQueue(context.applicationContext)
    }

    fun request(jsonObject: JSONObject, url:String, method:Int, onRequestReponse: OnRequestReponse) {
        val request = JsonObjectRequest(method, url, jsonObject, Response.Listener<JSONObject> {
            onRequestReponse.onRequestSuccess(it)
        }, Response.ErrorListener {
            onRequestReponse.onRequestError(it)
        }).setTag(url)
        this.requestQueue.add(request)
    }

    fun cancellRequestsForTAG(REQUEST_TAG: String) {
        requestQueue.cancelAll(REQUEST_TAG)
    }

}
