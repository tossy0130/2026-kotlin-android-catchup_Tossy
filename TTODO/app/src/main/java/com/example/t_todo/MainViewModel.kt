package com.example.t_todo

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val taskDao: TaskDao): ViewModel() {

    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var isShowDialog by mutableStateOf(false)

    // タスク全件を取得する （データベースから取得）
    val tasks = taskDao.loadAllTasks().distinctUntilChanged()

    // 更新用に使う、ID取得用
    private var editingTask: Task? = null
    val isEditing: Boolean
        get() = editingTask != null

    fun setEditingTask(task: Task) {
        editingTask = task
        title = task.title
        description = task.description
    }

    /**
     *  新規作成　処理 DB
     */
    fun createTask() {
        viewModelScope.launch {
            val newTask = Task(title = title, description = description)
            taskDao.insertTask(newTask)

            Log.d(MainViewModel::class.simpleName, "success create task")
        }
    }

    /**
     *  削除機能　処理 DB
     */
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.deleteTask(task)
        }
    }

    /**
     *  更新機能　処理 DB
     */

    /*
    fun updateTask() {
        // nill じゃなければ、task　に値が渡り、下の処理を実行
        editingTask?.let { task ->
            viewModelScope.launch {
                task.title = title
                task.description = description
                taskDao.updateTask(task)
            }
        }

    }
    */
    /**
     *  更新機能　処理 DB
     */
    fun updateTask() {
        // 更新対象がなければ何もしない
        val targetTask = editingTask ?: return

        // 現在の入力値を先に退避
        val newTitle = title
        val newDescription = description

        // 元のTaskを直接書き換えず、更新用のコピーを作る
        val updatedTask = targetTask.copy(
            title = newTitle,
            description = newDescription
        )

        viewModelScope.launch {
            taskDao.updateTask(updatedTask)

            Log.d(MainViewModel::class.simpleName, "success update task")
        }
    }

    fun resetProperties() {
        editingTask = null
        title = ""
        description = ""
    }


}