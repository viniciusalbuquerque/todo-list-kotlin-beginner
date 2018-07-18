package com.example.viniciusalbuquerque.todotest.environment.parsers

import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser
import com.example.viniciusalbuquerque.todotest.models.classes.*
import org.json.JSONArray
import org.json.JSONObject

class TodoJSONParser : Parser.TodoParser {
    override fun parseList(response: Any): ArrayList<TODO> {
        val json = response as JSONObject
        val arrayList = ArrayList<TODO>()

        val success = json.getBoolean(SUCCESS)
        if(!success) return arrayList

        //todo If data is null, it will throw an exception
        var todoJSONArray = json.get(DATA)
        if(todoJSONArray == null) return arrayList

        todoJSONArray = todoJSONArray as JSONArray

        for (i in 0..(todoJSONArray.length() - 1)) {
            val todoJSON = (todoJSONArray.get(i) as JSONObject)
            val todo = TODO(todoJSON.getLong(ID), todoJSON.getString(TITLE))
            todo.isDone = todoJSON.getBoolean(DONE)
            arrayList.add(todo)
        }

        return arrayList
    }

    override fun parseTodo(response: Any): TODO {
        return TODO(1L, "First")
    }

    override fun parseRemove(response: Any): TODO {
        return TODO(1L, "First")
    }

    override fun parseUpdate(response: Any): String {
        return "Updated"
    }

}