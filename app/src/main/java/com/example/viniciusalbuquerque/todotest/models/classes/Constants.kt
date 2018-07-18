package com.example.viniciusalbuquerque.todotest.models.classes

const val SERVER_PORT = "3000"
const val SERVER_IP = "10.0.2.2"
const val SERVER_HOST = "http://$SERVER_IP:$SERVER_PORT"

const val SUCCESS = "success"
const val DATA = "data"
const val ID = "id"
const val TITLE = "title"
const val DONE = "done"

// ToDo URLs
const val URL_ADD_TODO = "$SERVER_HOST/todo/add"
const val URL_REMOVE_TODO = "$SERVER_HOST/todo/rem"
const val URL_LIST_TODO = "$SERVER_HOST/todo/list"
const val URL_UPDATE_TODO = "$SERVER_HOST/todo/update"

// ToDoWrapper URLs
const val URL_ADD_TODO_WRAPPER = "$SERVER_HOST/todo/wrapper/add"
const val URL_UPDATE_TODO_WRAPPER = "$SERVER_HOST/todo/update"
const val URL_REMOVE_TODO_WRAPPER = "$SERVER_HOST/todo/wrapper/rem"
const val URL_LIST_TODO_WRAPPER = "$SERVER_HOST/todo/wrapper/list"
