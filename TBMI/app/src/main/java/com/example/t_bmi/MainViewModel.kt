package com.example.t_bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {

    // ログ出力用
   // val test = "test"

    // 身長
    var height by mutableStateOf("")

    // 体重
    var weight by mutableStateOf("")

    // 計算結果
    var bmi by mutableStateOf(0f) // float　型


    // BMI = (体重) / 身長 ** 2
    fun calculateBMI() {
        val heightNum = height.toFloatOrNull()?.div(100) ?: 0f
        val weightNum = weight.toFloatOrNull() ?: 0f

        bmi = if(heightNum > 0f && weightNum > 0f) {
            (weightNum / heightNum.pow(2) * 10).roundToInt() / 10f
        } else 0f
    }

}