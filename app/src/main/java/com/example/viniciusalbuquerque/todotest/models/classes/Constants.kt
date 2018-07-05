package com.example.viniciusalbuquerque.todotest.models.classes

const val SERVER_PORT = "5555"
const val SERVER_IP = "10.0.2.2"
const val SERVER_HOST = "http://$SERVER_IP:$SERVER_PORT"

// ToDo URLs
const val URL_ADD_TODO = "$SERVER_HOST/todo/add"
const val URL_REMOVE_TODO = "$SERVER_HOST/todo/rem"
const val URL_LIST_TODO = "$SERVER_HOST/todo/list"
const val URL_UPDATE_TODO = "$SERVER_HOST/todo/update"

// ToDoWrapper URLs
const val URL_ADD_TODO_WRAPPER = "$SERVER_HOST/todo/add"
const val URL_UPDATE_TODO_WRAPPER = "$SERVER_HOST/todo/update"
const val URL_REMOVE_TODO_WRAPPER = "$SERVER_HOST/todo/rem"
const val URL_LIST_TODO_WRAPPER = "$SERVER_HOST/todo/list"
