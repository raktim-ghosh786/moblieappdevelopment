package com.example.todo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditToDoActivity : AppCompatActivity() {
    private lateinit var editTextTask: EditText
    private lateinit var checkBoxCompleted: CheckBox
    private lateinit var buttonSave: Button
    private var toDo: ToDo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_to_do)

        editTextTask = findViewById(R.id.editTextTask)
        checkBoxCompleted = findViewById(R.id.checkBoxCompleted)
        buttonSave = findViewById(R.id.buttonSave)

        toDo = intent.getParcelableExtra(EXTRA_TODO)
        toDo?.let {
            editTextTask.setText(it.task)
            checkBoxCompleted.isChecked = it.completed
        }

        buttonSave.setOnClickListener {
            saveToDo()
        }
    }

    private fun saveToDo() {
        val task = editTextTask.text.toString()
        val completed = checkBoxCompleted.isChecked

        val newToDo = if (toDo == null) {
            ToDo(task = task, completed = completed)
        } else {
            toDo!!.copy(task = task, completed = completed)
        }

        val resultIntent = Intent().apply {
            putExtra(EXTRA_TODO, newToDo)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    companion object {
        const val EXTRA_TODO = "com.example.todo.EXTRA_TODO"
    }
}
