package com.example.composequadrantapp

import android.os.Bundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrantapp.ui.theme.ComposeQuadrantAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantAppTheme {
                Surface(modifier = Modifier.fillMaxSize(),color= MaterialTheme.colorScheme.background)
                {
                    QuadrantAppScreen()
                }
            }
        }
    }
}

@Composable
fun QuadrantAppScreen()
{
    val textComposable= stringResource(id = R.string.text_composable)
    val textComposableDesc= stringResource(id = R.string.text_composable_desc)
    val imageComposable= stringResource(id = R.string.image_composable)
    val imageComposableDesc= stringResource(id = R.string.image_composable_desc)
    val rowComposable= stringResource(id = R.string.row_composable)
    val rowComposableDesc= stringResource(id = R.string.row_composable_desc)
    val columnComposable= stringResource(id = R.string.column_composable)
    val columnComposableDesc= stringResource(id = R.string.column_composable_desc)
    Column (Modifier.fillMaxWidth()){
        Row(Modifier.weight(1f)) {
            QuadrantCard(heading =textComposable , description =textComposableDesc , color = Color(0xFFEADDFF), modifier = Modifier.weight(1f))
            QuadrantCard(heading =imageComposable , description =imageComposableDesc , color = Color(0xFFD0BCFF), modifier = Modifier.weight(1f))
        }

        Row(Modifier.weight(1f)) {
            QuadrantCard(heading =rowComposable , description =rowComposableDesc , color = Color(0xFFB69DF8), modifier = Modifier.weight(1f))
            QuadrantCard(heading =columnComposable , description = columnComposableDesc, color = Color(0xFFF6EDFF), modifier = Modifier.weight(1f))
        }
    }
}
@Composable
fun QuadrantCard(heading:String,description:String,color:Color,modifier:Modifier=Modifier)
{
        Column(modifier = modifier.fillMaxSize().background(color).padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement =Arrangement.Center) {
            Text(text = heading, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom=16.dp))
            Text(text = description, textAlign = TextAlign.Justify)
        }
    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantAppTheme {
        QuadrantAppScreen()
    }
}