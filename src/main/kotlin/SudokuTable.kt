import Builder.grid
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.*

var change = "0"

data class SudokuCellData(
    val row: Int,
    val column: Int,
    val number: String = "",
    var state: SudokuCellState = SudokuCellState.EMPTY
): Serializable {
    override fun hashCode(): Int {
        return getHash(row, column)
    }
}

internal fun getHash(row: Int, column: Int): Int {
    val newX = row*100
    return "$newX$column".toInt()
}


@Composable
fun sudokuCell(row: Int, column: Int) {
    var number = grid[row][column].toString()
    val fixed = remember { mutableStateOf(number != "0") }
   /* val backgroundColor = if (isSelected) {
        MaterialTheme.colors.onBackground.copy(alpha = 0.2f)
    } else {
        MaterialTheme.colors.background
    }
    val backgroundColorAnimated = animateColorAsState(targetValue = backgroundColor).value
    */
    Box(Modifier
        .height(40.dp)
        .width(40.dp)
        .padding(0.75.dp)
        .border(1.dp, Color.Gray)
//        .background(backgroundColorAnimated)
        .aspectRatio(1f)
        .background(color = Red)
        .clickable {
            if (!fixed.value) {
                number = change
                grid[row][column] = change.toInt()
            }
        }
    ) {
        Text(
            color = Black,
            text = if (number == "0") "" else number,
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
fun table(f: Float) {
    Column(
        Modifier
            .padding(2.dp)
            .alpha(f)) {
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