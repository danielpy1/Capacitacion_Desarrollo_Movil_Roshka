package com.cursosandroidant.mynewcompose

import android.R
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.cursosandroidant.mynewcompose.ui.theme.MyNewComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    MyBox()
                    MyRow()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!", modifier = modifier
//            .fillMaxSize()
//    )
//}
@Preview
@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Gray)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyColum() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            "Hola 1",
            Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
        )
        Text(
            "Hola 2",
            Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
        )
        Text(
            "Hola 3",
            Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
        )
        Text(
            "Hola 4",
            Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
        )

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyRow() {
//    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
//        Text("ejemplo1")
//        Text("ejemplo2")
//        Text("ejemplo3")
//        Text("ejemplo4")
//        Text("ejemplo5")
//    }
    Row(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        Text("ejemplo1", Modifier.width(200.dp))
        Text("ejemplo2", Modifier.width(200.dp))
        Text("ejemplo3", Modifier.width(200.dp))
        Text("ejemplo4", Modifier.width(200.dp))
        Text("ejemplo5", Modifier.width(200.dp))
    }

}

@Preview
@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .weight(1f)
        )
        Row(
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .background(Color.Green).fillMaxHeight()
            ) {

            }
            Column(
                Modifier
                    .weight(1f)
                    .background(Color.Red).fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text ="Hola 2")
            }
        }
        Box(
            Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .weight(1f)
        )

    }

}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    MyNewComposeTheme {
//        Greeting("Android")
//    }
//}