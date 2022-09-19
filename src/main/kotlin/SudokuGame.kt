import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun sudokuGame() {

 //   val solution = remember { mutableStateOf(false) }

    Builder().setLevel(Level.JUNIOR).build().printGrid()

    Column {
        Spacer(modifier = Modifier.padding(12.dp))
        headingText()
 //       topBar(solution)
        Spacer(modifier = Modifier.fillMaxHeight(0.04f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box {
                /*
                if (solution.value) {
                    for (i in 0 until GRID_SIZE) {
                        for (j in 0 until GRID_SIZE) {
                            grid[i][j] = original[i][j]
                        }
                    }
                }

                 */
                table()
            }
            Spacer(Modifier.fillMaxHeight(0.06f))
//            finalScreen(text = "VICTORY!")
            Spacer(Modifier.fillMaxHeight(0.06f))
            dialPad()
            Spacer(modifier = Modifier.padding(10.dp))
            }
    }
}

