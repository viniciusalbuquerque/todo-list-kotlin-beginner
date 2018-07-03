package com.example.viniciusalbuquerque.todotest.domain.daos

import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse

interface TodoDAO {
    fun create(todoWrapperId: Long, todoTitle: String, onRequestReponse: OnRequestReponse)
    fun read(onRequestReponse: OnRequestReponse)
    fun update(todoWrapperId: Long, todoId: Long, done: Boolean, onRequestReponse: OnRequestReponse)
    fun delete(todoWrapperId: Long, todoId: Long, onRequestReponse: OnRequestReponse)

    fun cancelRequests()
}