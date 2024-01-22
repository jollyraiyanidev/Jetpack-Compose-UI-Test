package com.app.authwithjetpacktest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.authwithjetpacktest.ui.authentication.Authentication
import com.app.authwithjetpacktest.ui.theme.AuthWithJetpackTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                    Authentication()
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        Authentication()
    }
}