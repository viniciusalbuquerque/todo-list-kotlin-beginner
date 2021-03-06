package com.example.viniciusalbuquerque.todotest.domain.daos

import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.domain.interfaces.OnRequestReponse

interface TodoWrapperDAO {
    fun create(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse)
    fun read(onRequestReponse: OnRequestReponse)
    fun update(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse)
    fun delete(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse)

    fun cancelRequests()
}