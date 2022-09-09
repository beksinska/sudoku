import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun dial(num: String = "", dialStateList: List<MutableState<Boolean>>) {
    Box(
        Modifier
            .height(60.dp)
            .width(60.dp)
            .padding(2.dp)

            .background(Color.Red)
            .clickable {
                change = num
                dialStateList[num.toInt() - 1].value = true
            }) {
        Text(
            text = num,
            Modifier
                .align(Alignment.Center),
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun DialPad() {
    val dialStateList = listOf(remember { mutableStateOf(false) },
        remember { mutableStateOf(false) },
        remember { mutableStateOf(false) },
        remember { mutableStateOf(false) },
        remember { mutableStateOf(false) },
        remember { mutableStateOf(false) },
        remember { mutableStateOf(false) },
        remember { mutableStateOf(false) },
        remember { mutableStateOf(false) })
    Column(
        Modifier
            .padding(1.dp)
            .clickable { }) {
        Row {
            dial("1", dialStateList)
            dial("2", dialStateList)
            dial("3", dialStateList)
        }
        Row {
            dial("4", dialStateList)
            dial("5", dialStateList)
            dial("6", dialStateList)
        }
        Row {
            dial("7", dialStateList)
            dial("8", dialStateList)
            dial("9", dialStateList)

        }
    }
}
