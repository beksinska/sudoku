import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun headingText() {
    Text(
        text = "SUDOKU",
        fontSize = 70.sp,
        fontWeight = FontWeight.ExtraLight,
        color = Color.Black,
        letterSpacing = 10.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Composable
fun topBar(solution: MutableState<Boolean>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
//        solutionButton(solution)
    }
}

/*
@Composable
fun solutionButton(solution: MutableState<Boolean>) {
    Button(
        onClick = {
        solution.value = true
        }
    )
    {
    Text(
        "SOLUTION"
    )
    }
}

 */



@Composable
fun finalScreen(text: String, color: Color = Color.White) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = text,
            fontSize = 50.sp,
            color = Color.Black,
            fontWeight = FontWeight.Light,
            letterSpacing = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}

