package jolchu.tolik.mvi_jetpackcompose_finder.ui.viewmodel

sealed class RecipeViewIntent {
    data object LoadRandomRecipe : RecipeViewIntent()
    data class SearchRecipes(val query: String) : RecipeViewIntent()
}