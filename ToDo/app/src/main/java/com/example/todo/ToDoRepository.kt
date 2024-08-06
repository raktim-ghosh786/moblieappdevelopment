package com.example.todo

import androidx.lifecycle.LiveData

class ToDoRepository(private val toDoDao: ToDoDao) {
    val allToDos: LiveData<List<ToDo>> = toDoDao.getAllToDos()

    suspend fun insert(toDo: ToDo) {
        toDoDao.insert(toDo)
    }

    suspend fun update(toDo: ToDo) {
        toDoDao.update(toDo)
    }

    suspend fun delete(toDo: ToDo) {
        toDoDao.delete(toDo)
    }
}