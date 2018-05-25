package com.example.viniciusalbuquerque.todotest

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import org.json.JSONObject

class Requests(val context: Context) {
    val requestQueue : RequestQueue

    init {
        requestQueue = Volley.newRequestQueue(context.applicationContext)
    }


    fun request(jsonObject: JSONObject, url:String, method:Int, onRequestReponse: OnRequestReponse) {
        val request = JsonObjectRequest(method, url, jsonObject, Response.Listener<JSONObject> {
            onRequestReponse.onRequestSuccess(it)
        }, Response.ErrorListener {
            onRequestReponse.onRequestError(it)
        })
        this.requestQueue.add(request)
    }
}
