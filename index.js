const express = require('express') // Importing the express module
const {getTodoById, getAllTodo} = require('./db')
const app = express() // const... creating the app
const Todo = require('./todo')
const port = 3000

app.get('/', (req, res) => res.send('Hello World!'))

// TODO --> task manager

// Get All Todos
app.get('/all', (req, res) => {
    const todos = getAllTodo();
    res.json({
        data: todos,
        msg: "Success"
    })
})

// Get a Todo
app.get('/todo/:id', (req, res) => {
    const id = req.params.id;
    const todo = getTodoById(id);

    res.json({
        data: todo,
        msg: "Success"
    })
})


// Create a TODO


// Delete a TODO

app.listen(port, () => console.log(`App listening on port ${port}!`))