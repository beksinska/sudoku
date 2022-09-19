import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var change = "0"

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
            if (numberQuantity()) {
                check()
                println(check())
            }
       }
    ) {
        Text(
            color = Black,
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