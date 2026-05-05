package com.example.t_bmi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.t_bmi.ui.theme.TBMITheme

class MainActivity : ComponentActivity() {

    // ビューモデルを使えるように、アクセス用
    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel が使えているかのテスト
   //     Log.d("Test", viewModel.test)

        enableEdgeToEdge()
        setContent {
            TBMITheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->

                    Spacer(modifier = Modifier.height(20.dp))

                    Column (horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(40.dp),
                        ) {

                        // アプリタイトル　表示
                        Text(text = "BMI計算アプリ", fontSize = 26.sp, fontWeight = FontWeight.ExtraBold,
                            )

                        Spacer(modifier = Modifier.height(30.dp))

                        // 身長
                        PinkLabeldTextField(
                            value = viewModel.height,
                            onValueChange = { viewModel.height = it },
                            label = "身長(CM)",
                            placeholder = "170"
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // 体重
                        PinkLabeldTextField(
                            value = viewModel.weight,
                            onValueChange = { viewModel.weight = it },
                            label = "体重(KG)",
                            placeholder = "65"
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        // 計算ボタン
                        Button(
                            onClick = { viewModel.calculateBMI() },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF85F6A)
                            ),
                        ) {
                            Text(text = "計算する",
                            color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        // 結果表示　テキスト
                        Text(
                            text = "あなたのBMIは${viewModel.bmi}です",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun PinkLabeldTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
) {
    Column {

        // テキストラベル 身長
        Text(text = label,
            color = Color(0xFFF85F6A),
            fontWeight = FontWeight.Bold,
        )

        // テキストフィールド 身長
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            // === 背景透明
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),

            // プレイスホルダー
            placeholder = {
                Text(text = placeholder)
            },
            // 数字だけ入力
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            // 1行
            singleLine = true,
        )

    }
}
