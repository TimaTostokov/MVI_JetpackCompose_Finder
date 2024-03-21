package jolchu.tolik.mvi_jetpackcompose_finder.ui.viewmodel

import jolchu.tolik.mvi_jetpackcompose_finder.data.model.Meal

sealed class RecipeViewState {
    data object Loading : RecipeViewState()
    data class Success(val recipes: List<Meal>) : RecipeViewState()
    data class Error(val message: String) : RecipeViewState()
}