package com.example.tictactoe.di

import androidx.navigation.NavHostController
import com.example.tictactoe.AppViewModel
import com.example.tictactoe.models.AppState
import com.example.tictactoe.network.TicTacToeService
import com.example.tictactoe.ui.landing.LandingViewModel
import com.example.tictactoe.ui.play.PlayViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.websocket.WebSockets
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        single {
            HttpClient(CIO) {
                install(WebSockets)
            }
        }
        single { TicTacToeService(get()) }

        viewModel {
                (
                    navController: NavHostController, ticTacToeService: TicTacToeService, appState: StateFlow<AppState>,
                ),
            ->
            LandingViewModel(navController, get(), appState)
        }
        viewModel {
                (
                    navController: NavHostController,
                    ticTacToeService: TicTacToeService,
                    appState: StateFlow<AppState>,
                    snackBarEvent: MutableSharedFlow<String>,
                ),
            ->
            PlayViewModel(navController, get(), appState, snackBarEvent)
        }
        viewModel {
            AppViewModel(get())
        }
    }
