package com.example.viniciusalbuquerque.todotest.models.interfaces

interface OnTODORequestMethods {
    fun update(todoWrapperID : Long, todoID: Long, done: Boolean)
}
