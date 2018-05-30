package com.example.viniciusalbuquerque.todotest.models.classes

const val KEY_SHARED_PREFERENCES = "key-shared-prefs"
const val KEY_SAVED_TODOS = "key-saved-todos"
const val SERVER_PORT = "5555"
const val SERVER_IP = "localhost"
const val SERVER_HOST = "http://$SERVER_IP:$SERVER_PORT"
const val URL_ADD_TODO = "$SERVER_HOST/todo/add"
const val URL_REMOVE_TODO = "$SERVER_HOST/todo/rem"
const val URL_LIST_TODO = "$SERVER_HOST/todo/list"

const val KEY_PARAM_TODO_WRAPPER_ID = "todoWrapperID"
const val KEY_PARAM_TODO_ID = "todoID"