import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SudokuTheme {
                SudokuApp()
            }
        }
    }
}


 */

@Composable
fun HeadingText() {
    Text(
        text = "SUDOKU",
        fontSize = 70.sp,
        fontWeight = FontWeight.ExtraLight,
        color = Color.Black,
        letterSpacing = 10.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 70.dp)
    )
}