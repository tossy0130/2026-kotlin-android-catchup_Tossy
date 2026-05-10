package com.example.t_todo

import androidx.room.Entity
import androidx.room.PrimaryKey


// ======= Task　の箇所がテーブル名になる
@Entity
data class Task (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title: String,
    var description: String,
)

