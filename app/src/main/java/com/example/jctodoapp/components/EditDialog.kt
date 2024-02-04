package com.example.jctodoapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jctodoapp.MainViewModel

@Composable
fun EditDialog(viewModel: MainViewModel = hiltViewModel()) {
    DisposableEffect(Unit) {
        onDispose {
            viewModel.resetProperties()
        }
    }
    AlertDialog(
        onDismissRequest = { viewModel.isShowDialog = false },
        title = {
            Text(text = "タスク新規作成")
        },
        text = {
            Column {
                Text(text = "タイトル")
                TextField(value = viewModel.title, onValueChange = { viewModel.title = it })
                Text(text = "詳細")
                TextField(value = viewModel.description, onValueChange = { viewModel.description = it })
            }
        },
        confirmButton = {
            Button(onClick = {
                viewModel.isShowDialog = false
                if (viewModel.isEditing) {
                    viewModel.updateTask()
                } else {
                    viewModel.createTask()
                }
            }) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            Button(onClick = { viewModel.isShowDialog = false }) {
                Text(text = "キャンセル")
            }
        }
    )
}