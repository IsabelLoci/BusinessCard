package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardImage(message = "Isabel Loci", from = "Email: Isabel.Loci@cix.csi.cuny.edu LinkedIn: https://www.linkedin.com/in/isabel-loci/", modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun CardImage(message: String, from: String, modifier: Modifier) {
    val image = painterResource(R.drawable.isabel_headshot)
    Row(modifier.fillMaxSize()) {
        Box( // Used to make rectangle on the side that will contain info
            modifier = Modifier.width(200.dp).height(290.dp).background(Color(0xFFF1E0D3))
        ) {
            InfoText( // Formatting of text on top of rectangle
                message = message,
                from = from,
                modifier = Modifier.fillMaxSize().padding(8.dp)
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 1F
            )
        }
    }
}

@Composable
fun InfoText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 30.sp,
            lineHeight = 116.sp,
            color = Color.Black,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = from,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostcardPreview() {
    BusinessCardTheme {
        CardImage(message = "Isabel Loci", from = "Email: Isabel.Loci@cix.csi.cuny.edu LinkedIn: https://www.linkedin.com/in/isabel-loci/", modifier = Modifier)
    }
}