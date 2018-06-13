package com.example.viniciusalbuquerque.todotest.daos

import com.example.viniciusalbuquerque.todotest.models.classes.TODOWrapper
import com.example.viniciusalbuquerque.todotest.models.interfaces.OnRequestReponse

interface TodoWrapperDAO {
    fun create(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse)
    fun read(onRequestReponse: OnRequestReponse)
    fun update(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse)
    fun delete(todoWrapper: TODOWrapper, onRequestReponse: OnRequestReponse)
}