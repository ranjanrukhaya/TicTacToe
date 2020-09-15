package com.gaura.learn.tictactoe.viewModel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gaura.learn.tictactoe.model.Cell
import com.gaura.learn.tictactoe.model.Game
import com.gaura.learn.tictactoe.model.Player
import com.gaura.learn.tictactoe.utils.StringUtility.stringFromNumbers

class GameViewModel : ViewModel() {

    var cells: ObservableArrayMap<String, String> = ObservableArrayMap()
    private var game: Game = Game("player1", "player2")

    fun onCellClicked(row: Int, col: Int) {
        if (game.cells[row][col] == null) {
            game.cells[row][col] = Cell(game.currentPlayer)
            cells[stringFromNumbers(row, col)] = game.currentPlayer.value
            if (game.hasGameEnded()) {
                game.reset()
            } else {
                game.switchPlayer()
            }
        }
    }

    public fun getWinner(): LiveData<Player> {
        return game.winner
    }
}