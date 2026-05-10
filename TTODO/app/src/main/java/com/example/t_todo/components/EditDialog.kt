package com.example.t_todo.components

import android.R.attr.text
import android.R.attr.title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.t_todo.MainViewModel


@Composable
fun EditDialog(
    viewModel: MainViewModel = hiltViewModel() // MainViewModel
    ) {

    /**
     *  アラートダイアログが非表示になるタイミング
     */
    DisposableEffect(Unit) {
        onDispose {
            // リセット処理
            viewModel.resetProperties()
        }
    }

    AlertDialog(
        onDismissRequest = {
            // ダイアログ外をタップした時の処理
            viewModel.isShowDialog = false
        },
        title = {
            Text(text = if(viewModel.isEditing) "タスク更新" else "タスク新規作成")
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
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {

                Spacer(modifier = Modifier.weight(1f))
                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = {
                        // キャンセル処理
                        viewModel.isShowDialog = false
                    }
                ) {
                    Text("キャンセル")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = {

                        if(viewModel.isEditing) {
                            // 更新処理
                            viewModel.updateTask()
                        } else {
                            // create タスク（新規作成）実行
                            viewModel.createTask()
                        }

                        viewModel.isShowDialog = false

                    }
            ) {
                    Text("保存")
            }

            }
        }
    )
}