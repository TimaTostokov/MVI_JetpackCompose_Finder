package jolchu.tolik.mvi_jetpackcompose_finder.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import jolchu.tolik.mvi_jetpackcompose_finder.ui.components.ErrorComponent
import jolchu.tolik.mvi_jetpackcompose_finder.ui.components.LoadingComponent
import jolchu.tolik.mvi_jetpackcompose_finder.ui.components.SuccessComponent
import jolchu.tolik.mvi_jetpackcompose_finder.ui.viewmodel.RecipeViewIntent
import jolchu.tolik.mvi_jetpackcompose_finder.ui.viewmodel.RecipeViewModel
import jolchu.tolik.mvi_jetpackcompose_finder.ui.viewmodel.RecipeViewState

@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel) {
    val state by recipeViewModel.state

    when (state) {
        is RecipeViewState.Loading -> LoadingComponent()
        is RecipeViewState.Success -> {
            val recipes = (state as RecipeViewState.Success).recipes
            SuccessComponent(recipes = recipes) {
                recipeViewModel.processIntent(RecipeViewIntent.SearchRecipes(it))
            }
        }

        is RecipeViewState.Error -> {
            val message = (state as RecipeViewState.Error).message
            ErrorComponent(message = message) {
                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            }
        }
    }

}