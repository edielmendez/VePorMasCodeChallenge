package mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi

import mx.com.edieltech.vepormascodechallenge.presentation.common.viewmodel.UiEffect

sealed interface HomeEffect: UiEffect {
    data class ShowToast(val message: String) : HomeEffect
}