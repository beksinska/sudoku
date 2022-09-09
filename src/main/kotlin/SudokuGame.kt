import Solver.copy
import Solver.grid
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import javax.naming.Context

@Composable
fun SudokuGame() {
    val solution = remember { mutableStateOf(false) }
    val correct = remember { mutableStateOf(false) }
    val solAnim = remember { mutableStateOf(true) }
    val corAnim = remember { mutableStateOf(true) }
    val spacerHeight by animateFloatAsState(targetValue = if (!solAnim.value or !corAnim.value) 0.04f else 0f, tween(1000))
    val fadeIn by animateFloatAsState(targetValue = if (solution.value) 0f else 1f, tween(1000))
    val fade by animateFloatAsState(targetValue = if (solution.value or correct.value) 0f else 1f, tween(1000))


    Builder.Sudoku.Builder().setLevel(Level.JUNIOR).build().printGrid()

    Column {
        Spacer(modifier = Modifier.padding(12.dp))
        HeadingText()
        Spacer(modifier = Modifier.fillMaxHeight(0.04f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box {
                table(0.9f)
                }
            Spacer(Modifier.fillMaxHeight(0.06f))
            DialPad()
            Spacer(modifier = Modifier.padding(10.dp))
            }
    }
}
    /*
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Sudoku.Builder()
        when {
            !corAnim.value -> {
                FinalScreen(text = "VICTORY!")
            }
            !solAnim.value -> {
                FinalScreen(text = "TRY AGAIN")
            }
        }
    }
}

    @Composable
    fun FinalScreen(text: String, color: Color = Color.White) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = text,
                fontSize = 50.sp,
                color = color,
                fontWeight = FontWeight.Light,
                letterSpacing = 10.sp,
                textAlign = TextAlign.Center
            )
        }
    }


     */
