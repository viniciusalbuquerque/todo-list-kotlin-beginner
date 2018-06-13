package com.example.viniciusalbuquerque.todotest

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.models.classes.URL_LIST_TODO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnResponseCallback
import com.example.viniciusalbuquerque.todotest.models.interfaces.Requests
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
