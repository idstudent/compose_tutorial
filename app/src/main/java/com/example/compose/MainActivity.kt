package com.example.compose

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.theme.ComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 머티리얼 디자인 적용 (프로젝트명에 따라 이름이 달라짐)
            // ComposeTutorial 이라고 플젝명을 지었으면 ComposeTutorialTheme 가 됨
            ComposeTheme {
                PreviewMessageCard(Message("android", "compose"))
            }
        }
    }
}

data class Message(val tv1: String, val tv2: String)

@Composable
fun PreviewMessageCard(msg: Message) {
    // 전체에 대한 padding 값을 줌 (이미지, 텍스트 사이 마진 영향x, 그냥 한묶음으로 보고 padding 준 듯
    // 필요없는 경우 안써주고 그냥 row { ... } 이런식으로 써도 됨
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp) // 이미지 사이즈
                .clip(CircleShape) // 이미지 동그라미
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape) // 이미지 바깥테두리 색 및 두께
        )
        // 이미지랑 텍스트 사이 마진 마지막줄에 쓰면 아마 텍스트 오른쪽에 마진을 주는거같음, 사이에 써줘야됨
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = msg.tv1,
                color = MaterialTheme.colors.secondaryVariant, // 텍스트 색상
                style = MaterialTheme.typography.subtitle2 // 폰트
            )
            Spacer(modifier = Modifier.width(4.dp)) // 텍스트 사이 마진
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) { // 버튼같은 ui로 나옴
                Text(
                    text = msg.tv2,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        PreviewMessageCard(Message("android", "compose"))
    }
}