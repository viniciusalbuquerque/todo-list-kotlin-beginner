package com.example.viniciusalbuquerque.todotest.daos

import com.example.viniciusalbuquerque.todotest.models.classes.TODO
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse

interface TodoDAO {
    fun create(todo: TODO, onRequestReponse: OnRequestReponse)
    fun read(onRequestReponse: OnRequestReponse)
    fun update(todoId: Long, todoWrapperId: Long, done: Boolean, onRequestReponse: OnRequestReponse)
    fun delete(todo: TODO, onRequestReponse: OnRequestReponse)

    fun cancelRequests()
}