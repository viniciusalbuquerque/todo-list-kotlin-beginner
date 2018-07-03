package com.example.viniciusalbuquerque.todotest.domain.interfaces

interface OnRequestReponse {

    fun onRequestSuccess(response: Any)
    fun onRequestError(error: Any)

}