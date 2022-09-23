import androidx.compose.runtime.Composable

@Composable
fun sudokuGame() {
    Builder().setLevel(Level.JUNIOR).build().printGrid()
}