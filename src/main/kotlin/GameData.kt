/*
interface GameData {

    suspend fun updateGame(game:SudokuPuzzle): GameResult
    suspend fun updateCell(x: Int, y: Int): GameResult
    suspend fun getCurrentGame(): GameResult
}

sealed class GameResult {
    data class OnSuccess(val currentGame: SudokuPuzzle): GameResult()
    data class OnError(val exception: Exception): GameResult()
}
*/
