package com.example.t_profile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompanySection() {


    Column (
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {

        // 会社名
        Text(
            text = "Google",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
            ,                            )

        Spacer(modifier = Modifier.height(10.dp))

        // グループ名
        Text(text = "MYカンパニー テクノロジー",
            color = Color.Gray, fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // メール　, Row 横並び
        Label(icon = Icons.Default.Email, text = "Email")


        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "email@ezweb.ne.jp", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(10.dp))

        // 線
        Divider(
            modifier = Modifier.clip(RoundedCornerShape(1000.dp)),
            thickness = 2.dp,
        )
    }


}