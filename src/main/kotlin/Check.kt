import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


fun numberQuantity() : Boolean {
    for (i in 0..8) {
        for (j in 0..8) {
            if (grid[i][j] == 0) {
                return false
            }
        }
    }
    return true
}


fun check() : Boolean {
    for (i in 0..8) {
        for (j in 0..8) {
            if (grid[i][j] != original[i][j]) {
                return false
            }
        }
    }
    return true
}



