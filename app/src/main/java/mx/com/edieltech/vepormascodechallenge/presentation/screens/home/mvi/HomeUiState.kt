package mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi

import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel
import mx.com.edieltech.vepormascodechallenge.presentation.common.viewmodel.UiState

data class HomeUiState(
    val isLoading: Boolean = true,
    val error: String = "",
    val photos: List<PhotoModel> = emptyList()
): UiState
