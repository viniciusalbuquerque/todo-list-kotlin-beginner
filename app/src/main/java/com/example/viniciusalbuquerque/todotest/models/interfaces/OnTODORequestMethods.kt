package com.example.viniciusalbuquerque.todotest.models.interfaces

interface OnTODORequestMethods {
    fun addTODO(todoWrapperID : Long, todoID: Long)
    fun removeTODO(todoWrapperID : Long, todoID: Long)
}
