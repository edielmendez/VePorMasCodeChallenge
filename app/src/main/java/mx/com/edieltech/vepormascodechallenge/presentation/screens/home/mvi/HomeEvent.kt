package mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi

import mx.com.edieltech.vepormascodechallenge.presentation.common.viewmodel.UiEvent

sealed interface HomeEvent: UiEvent {
    data object FetchPhotos: HomeEvent
    data object DeletePhoto: HomeEvent
}