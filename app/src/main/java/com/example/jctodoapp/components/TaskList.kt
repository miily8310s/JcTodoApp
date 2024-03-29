package com.example.jctodoapp.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.jctodoapp.Task

@Composable
fun TaskList(
    tasks: List<Task>,
    onClickRow: (Task) -> Unit,
    onClickDelete: (Task) -> Unit
) {
    LazyColumn {
        items(tasks) { task ->
            TaskRow(
                task = task,
                onClickRow = onClickRow,
                onClickDelete = onClickDelete
            )
        }
    }
}