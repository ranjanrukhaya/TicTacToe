package com.gaura.learn.tictactoe.model

import com.gaura.learn.tictactoe.utils.StringUtility

class Cell(public var player: Player) {
    val isEmpty: Boolean
        get() = player == null || StringUtility.isNullOrEmpty(player!!.value)
}