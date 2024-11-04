package com.example.tictactoe.models

data class AppState(
    var isConnected: Boolean = false,
    var isLoading: Boolean = false,
    var isGetAvailableGamesLoading: Boolean = false,
    var isConnectionError: Boolean = false,
    var isJoinedGame: Boolean = false,
    var isGameStarted: Boolean = false,
    var isWinCurrentGame: Boolean = false,
    var isLoseCurrentGame: Boolean = false,
    var isGameFinished: Boolean = false,
    var isOpponentQuitGame: Boolean = false,
    var isJoiningGame: Boolean = false,
    var availableGames: List<Game> = emptyList(),
    var clientId: String? = null,
    var error: String? = null,
    var clientName: String = "",
    var turn: CellState? = null,
    var playIdTurn: String? = null,
    var opponent: Opponent = Opponent("", ""),
    var board: Array<Array<CellState>> = arrayOf(),
    var gameId: String? = null,
    var myCellState: CellState = CellState.NONE,
)