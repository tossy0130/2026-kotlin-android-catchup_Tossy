package com.example.t_profile

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.t_profile.ui.theme.TProfileTheme

import com.example.t_profile.components.*

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

import android.graphics.Color as AndroidColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @OptIn(ExperimentalMaterial3Api::class)
        //enableEdgeToEdge()
        setContent {
            TProfileTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text (
                                    text = "Tossy App",
                                    color = Color.White
                                )
                            },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = Color(0xFFF85F6A)
                            )
                        )
                    }
                ) { innerPadding ->

                    MainContent(
                        modifier = Modifier.padding(innerPadding)
                    )

                } // END innerPadding

            }
        }
    }
}

@Composable
fun MainContent( modifier: Modifier = Modifier) {

    // === カラム
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()), // スクロール実装
        horizontalAlignment = Alignment.CenterHorizontally) {

        // プロフィール画像
        Image(
            painter = painterResource(id = R.drawable.img068),
            contentDescription = "プロフィール",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp) // 縦横のサイズ
                .clip(RoundedCornerShape(30.dp)) // 角丸
        )

        // スペース
        Spacer(modifier = Modifier.height(20.dp))


        // 名前
        Text(
            text = "Tossy NNN",
            color = Color.Gray,
            fontSize = 16.sp
        )

        // スペース
        Spacer(modifier = Modifier.height(20.dp))

        // 職業
        Text(
            text = "職業: エンジニア",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(20.dp))

        CompanySection()

        Spacer(modifier = Modifier.height(20.dp))

        // 詳細表示ボタン
        var isShowDetail by remember { mutableStateOf(false) }

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF85F6A)),
            onClick = {isShowDetail = !isShowDetail}
        ) {
            Text(text = "詳細を表示", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (isShowDetail) {
            // 趣味・居住地
            DetailSection()
        }


    }

}


