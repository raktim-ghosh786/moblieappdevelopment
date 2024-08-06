package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAddTask: FloatingActionButton
    private lateinit var toDoAdapter: ToDoAdapter
    private lateinit var toDoViewModel: ToDoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        fabAddTask = findViewById(R.id.fabAddTask)

        toDoAdapter = ToDoAdapter { toDo -> onToDoClicked(toDo) }
        recyclerView.adapter = toDoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        toDoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        toDoViewModel.allToDos.observe(this) { toDos ->
            toDos?.let { toDoAdapter.submitList(it) }
        }

        fabAddTask.setOnClickListener {
            // Navigate to Add/Edit Task Activity
            navigateToEditToDoActivity(null)
        }
    }

    private fun onToDoClicked(toDo: ToDo) {
        // Handle task click, e.g., edit or mark as completed
        navigateToEditToDoActivity(toDo)
    }

    private fun navigateToEditToDoActivity(toDo: ToDo?) {
        val intent = Intent(this, EditToDoActivity::class.java)
        if (toDo != null) {
            intent.putExtra(EditToDoActivity.EXTRA_TODO, toDo)
        }
        startActivity(intent)
    }
}