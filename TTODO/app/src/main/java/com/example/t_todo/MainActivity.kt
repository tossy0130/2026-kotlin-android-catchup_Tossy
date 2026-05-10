package com.example.t_todo

import android.R.attr.contentDescription
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.t_todo.components.EditDialog
import com.example.t_todo.components.TaskList
import com.example.t_todo.components.TaskRow
import com.example.t_todo.ui.theme.TTODOTheme
import dagger.hilt.android.AndroidEntryPoint


// 依存関係注入
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TTODOTheme {
                MainContent()
            }
        }
    }
}

// FAB ボタン
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(viewModel: MainViewModel = hiltViewModel())  {

 //   val isShowDialog = remember { mutableStateOf(false) }

    if (viewModel.isShowDialog) {
        EditDialog() // ダイアログ
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),

        // 上部バー　追加
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Room テストアプリ",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF3F51B5)
                )
            )
        },

        // 右下の丸い追加ボタン
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.isShowDialog = true // ダイアログを開く
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "新規作成"
                )
            }
        }
    ) { innerPadding ->

        // 全件表示用
        val tasks by viewModel.tasks.collectAsState(initial = emptyList())
      //  Log.d("COUNT", tasks.size.toString())

            // === 一覧表示
            TaskList(
                tasks = tasks ,
                onClickRow = {
                    // 値をセット
                    viewModel.setEditingTask(it)
                    // ダイアログ表示
                    viewModel.isShowDialog = true
                },
                onClickDelete = { viewModel.deleteTask(it)},
            )
        }

}
