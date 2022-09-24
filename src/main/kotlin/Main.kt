import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

var change = "0"

fun main() = application {

    fun disableAll(dialStateList: List<MutableState<Boolean>>) {
        for (i in 0..8) {
            dialStateList[i].value = false
        }
    }

    @Composable
    fun dial(number: String = "", dialStateList: List<MutableState<Boolean>>) {
        Box(
            Modifier
                .height(48.dp)
                .width(48.dp)
                .padding(2.dp)
                .background(if (dialStateList[number.toInt() - 1].value) Color.Red else Color.White)
                .clickable {
                    change = number
                    disableAll(dialStateList)
                    dialStateList[number.toInt() - 1].value = true
                }) {
            Text(
                text = number,
                Modifier
                    .align(Alignment.Center),
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
    }

    @Composable
    fun dialPad() {
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
                .padding(1.dp)) {
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

    @Composable
    fun sudokuCell(row: Int, column: Int) {
        val number = grid[row][column].toString()
        val visibleNumber = remember { mutableStateOf(if (number == "0") "" else number) }
        val fixed = remember { mutableStateOf(number != "0") }
        Box(Modifier
            .height(40.dp)
            .width(40.dp)
            .padding(0.75.dp)
            .border(1.dp, Color.Gray)
            .aspectRatio(1f)
            .background(if (fixed.value) Color.Red else Color.White)
            .clickable {
                if (!fixed.value) {
                    visibleNumber.value = change
                    grid[row][column] = change.toInt()
                }
            }
        ) {
            Text(
                color = Color.Black,
                text = if (visibleNumber.value == "0") "" else visibleNumber.value,
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = if (fixed.value) FontWeight.Normal else FontWeight.Light
            )
        }
    }

    @Composable
    fun smallTable(i: Int) {
        val row: Int = (i / 3) * 3
        val column: Int = (i % 3) * 3
        Column(Modifier.padding(1.dp)) {
            Row {
                sudokuCell(row, column)
                sudokuCell(row, column + 1)
                sudokuCell(row, column + 2)
            }
            Row {
                sudokuCell(row + 1, column)
                sudokuCell(row + 1, column + 1)
                sudokuCell(row + 1, column + 2)
            }
            Row {
                sudokuCell(row + 2, column)
                sudokuCell(row + 2, column + 1)
                sudokuCell(row + 2, column + 2)
            }
        }
    }

    @Composable
    fun table() {
        Column(
            Modifier
                .padding(2.dp)) {
            Row {
                smallTable(0)
                smallTable(1)
                smallTable(2)
            }
            Row {
                smallTable(3)
                smallTable(4)
                smallTable(5)
            }
            Row {
                smallTable(6)
                smallTable(7)
                smallTable(8)
            }
        }
    }

    @Composable
    fun buttonBar() {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            eraseButton()
        }
    }

    Window(
        onCloseRequest = ::exitApplication,
        state =  rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            width = 900.dp,
            height = 900.dp
        )
    )
    {
        sudokuGame()
        Column {
            Spacer(modifier = Modifier.padding(12.dp))
            headingText()
            Spacer(modifier = Modifier.fillMaxHeight(0.04f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Box {
                    table()
                }
                Box {
                    if (check()) {
                        statusText("WIN!")
                    } else {
                        statusText("Game in progress")
                    }
                }
                Spacer(Modifier.fillMaxHeight(0.06f))
                Spacer(Modifier.fillMaxHeight(0.06f))
                dialPad()
                buttonBar()
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }

}











