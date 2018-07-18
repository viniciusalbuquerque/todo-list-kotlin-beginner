package com.example.viniciusalbuquerque.todotest.environment.parsers

import com.example.viniciusalbuquerque.todotest.domain.parsers.Parser
import com.example.viniciusalbuquerque.todotest.models.classes.*
import org.json.JSONArray
import org.json.JSONObject

class TodoWrapperJSONParser : Parser.TodoWrapperParser {

    override fun parseList(response : Any) : ArrayList<TODOWrapper> {
        val json = response as JSONObject
        val arrayList = ArrayList<TODOWrapper>()

        val success = json.getBoolean(SUCCESS)
        if(!success) return arrayList

        //todo If data is null, it will throw an exception
        val todoWrappersJsonArray : JSONArray = json.getJSONArray(DATA)

        for (i in 0..(todoWrappersJsonArray.length() - 1)) {
            val todoWrapperJson = (todoWrappersJsonArray.get(i) as JSONObject)
            val todoWrapper = TODOWrapper(todoWrapperJson.getLong(ID), todoWrapperJson.getString(TITLE))
            arrayList.add(todoWrapper)
        }

        return arrayList
    }

    override fun parseTodoWrapper(response: Any): TODOWrapper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun parseRemove(response: Any): TODOWrapper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}