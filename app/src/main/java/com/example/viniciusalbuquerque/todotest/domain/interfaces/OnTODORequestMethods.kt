package com.example.viniciusalbuquerque.todotest.domain.interfaces

interface OnTODORequestMethods {
    fun update(todoWrapperID : Long, todoID: Long, done: Boolean)
}
