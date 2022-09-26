import kotlin.random.Random

var grid = Array(GRID_SIZE) { IntArray(GRID_SIZE) {0} }
var original = Array(GRID_SIZE) { IntArray(GRID_SIZE) {0} }

class Sudoku constructor(private val level: Level) {
    init {
        fillGrid()
    }

    fun printGrid() {
        for (i in 0 until GRID_SIZE) {
            for (j in 0 until GRID_SIZE) {
                print(grid[i][j].toString().plus(" "))
            }
            println()
        }
        println()
    }

    private fun fillGrid() {
        buildPuzzle()
        removeDigits()
    }

    private fun buildPuzzle() {
        fillDiagonalBoxes()
        fillRemaining(0, GRID_SIZE_SQUARE_ROOT)
        for (i in 0 until GRID_SIZE) {
            for (j in 0 until GRID_SIZE) {
                original[i][j] = grid[i][j]
                print(original[i][j].toString().plus(" "))
            }
            println()
        }
        println()
    }

    //Fill all the diagonal 3x3 boxes
    private fun fillDiagonalBoxes() {
        for (i in 0 until GRID_SIZE step GRID_SIZE_SQUARE_ROOT) fillBox(i, i)
    }

    //Fill a 3 x 3 box
    private fun fillBox(row: Int, column: Int) {
        var generatedDigit: Int
        for (i in 0 until GRID_SIZE_SQUARE_ROOT) {
            for (j in 0 until GRID_SIZE_SQUARE_ROOT) {
                do {
                    generatedDigit = generateRandomInt(MIN_DIGIT_VALUE, MAX_DIGIT_VALUE)
                } while (!isUnusedInBox(row, column, generatedDigit))
                grid[row + i][column + j] = generatedDigit
            }
        }
    }

    //Randomly take any number from min to max
    private fun generateRandomInt(min: Int, max: Int) = Random.nextInt(min, max + 1)

    //Fill rest of the non-diagonal matrices.
    //For every cell to be filled, we try all numbers until
    //we find a safe number to be placed.
    private fun fillRemaining(i: Int, j: Int) : Boolean {
        var i = i
        var j = j
        if (j >= GRID_SIZE && i < GRID_SIZE - 1) {
            i += 1
            j = 0
        }
        if (i >= GRID_SIZE && j >= GRID_SIZE) {
            return true
        }
        if (i < GRID_SIZE_SQUARE_ROOT) {
            if (j < GRID_SIZE_SQUARE_ROOT) {
                j = GRID_SIZE_SQUARE_ROOT
            }
        } else if (i < GRID_SIZE - GRID_SIZE_SQUARE_ROOT) {
            if (j == (i / GRID_SIZE_SQUARE_ROOT) * GRID_SIZE_SQUARE_ROOT) {
                j += GRID_SIZE_SQUARE_ROOT
            }
        } else {
            if (j == GRID_SIZE - GRID_SIZE_SQUARE_ROOT) {
                i += 1
                j = 0
                if (i >= GRID_SIZE) {
                    return true
                }
            }
        }
        for (digit in 1..MAX_DIGIT_VALUE) {
            if (isSafeToPutIn(i, j, digit)) {
                grid[i][j] = digit
                if (fillRemaining(i, j + 1)) {
                    return true
                }
                grid[i][j] = 0
            }
        }
        return false
    }

    //Check if it is safe to put in the cell
    private fun isSafeToPutIn(row: Int, column: Int, digit: Int) =
        isUnusedInBox(findBoxStart(row), findBoxStart(column), digit)
                && isUnusedInRow(row, digit)
                && isUnusedInColumn(column, digit)

    private fun findBoxStart(index: Int) = index - index % GRID_SIZE_SQUARE_ROOT

    private fun isUnusedInBox(rowStart: Int, columnStart: Int, digit: Int) : Boolean {
        for (i in 0 until GRID_SIZE_SQUARE_ROOT) {
            for (j in 0 until GRID_SIZE_SQUARE_ROOT) {
                if (grid[rowStart + i][columnStart + j] == digit) {
                    return false
                }
            }
        }
        return true
    }

    private fun isUnusedInRow(row: Int, digit: Int) : Boolean {
        for (i in 0 until GRID_SIZE) {
            if (grid[row][i] == digit) {
                return false
            }
        }
        return true
    }

    private fun isUnusedInColumn(column: Int, digit: Int) : Boolean {
        for (i in 0 until GRID_SIZE) {
            if (grid[i][column] == digit) {
                return false
            }
        }
        return true
    }

    //Once grid is fully filled, remove elements randomly to complete the
    //game if the puzzle is still solvable after each removal
    private fun removeDigits() {
        var digitsToRemove = GRID_SIZE * GRID_SIZE - level.numberOfProvidedDigits
        while (digitsToRemove > 0) {
            val randomRow = generateRandomInt(MIN_DIGIT_INDEX, MAX_DIGIT_INDEX)
            val randomColumn = generateRandomInt(MIN_DIGIT_INDEX, MAX_DIGIT_INDEX)
            if (grid[randomRow][randomColumn] != 0) {
                val digitToRemove = grid[randomRow][randomColumn]
                grid[randomRow][randomColumn] = 0
                if (!Solver.solvable(grid)) {
                    grid[randomRow][randomColumn] = digitToRemove
                } else {
                    digitsToRemove --
                }
            }
        }
    }
}

class Builder {
    private var level = Level.JUNIOR

    fun setLevel(level: Level) : Builder {
        this.level = level
        return this
    }

    fun build() : Sudoku {
        return Sudoku(level)
    }
}

