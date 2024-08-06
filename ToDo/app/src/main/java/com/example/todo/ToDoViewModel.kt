package com.example.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ToDoRepository
    val allToDos: LiveData<List<ToDo>>

    init {
        val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
        repository = ToDoRepository(toDoDao)
        allToDos = repository.allToDos
    }

    fun insert(toDo: ToDo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(toDo)
    }

    fun update(toDo: ToDo) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(toDo)
    }

    fun delete(toDo: ToDo) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(toDo)
    }
}
