import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
        fontSize = 40.sp,
        fontWeight = FontWeight.ExtraLight,
        color = Color.Black,
        letterSpacing = 10.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 2.dp),
    )
}

@Composable
fun eraseButton() {
    Text(
        modifier = Modifier
            .padding(15.dp)
            .background(Color.White)
            .clickable {
                change = "0"
            }
            .padding(6.dp),
        text = "ERASE",
        fontSize = 22.sp,
        color = Color.Black,
        fontWeight = FontWeight.Light,
        letterSpacing = 5.sp,
    )
}

@Composable
fun statusText(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        color = Color.Black,
        letterSpacing = 4.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 10.dp)
    )
}

