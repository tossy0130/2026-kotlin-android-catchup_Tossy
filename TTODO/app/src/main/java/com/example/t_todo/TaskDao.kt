package com.example.t_todo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    // インサートメソッド
    @Insert
    suspend fun insertTask(task: Task)

    // 一覧表示
    @Query("SELECT * FROM Task")
    fun loadAllTasks(): Flow<List<Task>>

    // 更新
    @Update
    suspend fun updateTask(task: Task)

    // 削除
    @Delete
    suspend fun deleteTask(task: Task)
}