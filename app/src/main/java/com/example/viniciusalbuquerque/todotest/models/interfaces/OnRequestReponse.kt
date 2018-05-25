package com.example.viniciusalbuquerque.todotest.models.interfaces

import com.android.volley.VolleyError
import org.json.JSONObject

interface OnRequestReponse {

    fun onRequestSuccess(response:JSONObject)
    fun onRequestError(error: VolleyError)

}