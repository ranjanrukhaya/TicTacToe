package com.gaura.learn.tictactoe

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.gaura.learn.tictactoe.databinding.ActivityMainBinding
import com.gaura.learn.tictactoe.model.Player
import com.gaura.learn.tictactoe.viewModel.GameViewModel


class MainActivity : AppCompatActivity() {

    private val GAME_BEGIN_DIALOG_TAG = "game_dialog_tag"
    private val GAME_END_DIALOG_TAG = "game_end_dialog_tag"
    private val NO_WINNER = "No one"

    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        activityMainBinding.gameViewModel = gameViewModel
        gameViewModel.getWinner().observe(this, this::onGameWinnerChanged);
    }

    private fun onGameWinnerChanged(player: Player?) {
        if (player == null || player.name.isEmpty()) {
            Toast.makeText(this, "No Winner", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, player.name, Toast.LENGTH_SHORT).show()
        }
    }
}