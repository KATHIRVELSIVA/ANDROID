package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DiceRollerApp(){
    DiceWithImgAndBtn(message="Dice Rolling"
        ,modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        ,by="Design by SKV")
}

@Composable
fun DiceWithImgAndBtn(message:String,modifier: Modifier=Modifier,by: String){
    var result by remember {
        mutableStateOf(1)
    }

    val imageResource=when(result){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }

Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally) {

    Text(
        text = message,
        fontSize = 36.sp
    )

    Spacer(modifier=Modifier.height(100.dp))

    Image(
        painter= painterResource(imageResource)
        ,contentDescription = result.toString())

    Spacer(modifier=Modifier.height(40.dp))

    Button(onClick = { result=(1..6).random() }) {
        Text(text = stringResource(R.string.roll))
    }

    Spacer(modifier=Modifier.height(100.dp))

    Text(
        text = by,
        fontSize = 20.sp
    )

}
}
