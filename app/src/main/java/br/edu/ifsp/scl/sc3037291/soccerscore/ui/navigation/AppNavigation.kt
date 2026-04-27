package br.edu.ifsp.scl.sc3037291.soccerscore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc3037291.soccerscore.ui.screens.MatchConfigScreen
import br.edu.ifsp.scl.sc3037291.soccerscore.ui.screens.MatchResultScreen
import br.edu.ifsp.scl.sc3037291.soccerscore.ui.screens.MatchSummaryScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.CONFIG
    ) {
        composable(Routes.CONFIG) {
            MatchConfigScreen(
                onNavigateToSummary = { teamA, teamB, goalsA, goalsB ->
                    navController.navigate("summary/$teamA/$teamB/$goalsA/$goalsB")
                }
            )
        }

        composable(
            route = Routes.SUMMARY,
            arguments = listOf(
                navArgument("teamA") { type = NavType.StringType },
                navArgument("teamB") { type = NavType.StringType },
                navArgument("goalsA") { type = NavType.IntType },
                navArgument("goalsB") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val teamA = backStackEntry.arguments?.getString("teamA") ?: ""
            val teamB = backStackEntry.arguments?.getString("teamB") ?: ""
            val goalsA = backStackEntry.arguments?.getInt("goalsA") ?: 0
            val goalsB = backStackEntry.arguments?.getInt("goalsB") ?: 0

            MatchSummaryScreen(
                teamA = teamA,
                teamB = teamB,
                goalsA = goalsA,
                goalsB = goalsB,
                onEdit = { navController.popBackStack() },
                onConfirm = {
                    navController.navigate("result/$teamA/$teamB/$goalsA/$goalsB")
                }
            )
        }

        composable(
            route = Routes.RESULT,
            arguments = listOf(
                navArgument("teamA") { type = NavType.StringType },
                navArgument("teamB") { type = NavType.StringType },
                navArgument("goalsA") { type = NavType.IntType },
                navArgument("goalsB") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val teamA = backStackEntry.arguments?.getString("teamA") ?: ""
            val teamB = backStackEntry.arguments?.getString("teamB") ?: ""
            val goalsA = backStackEntry.arguments?.getInt("goalsA") ?: 0
            val goalsB = backStackEntry.arguments?.getInt("goalsB") ?: 0

            MatchResultScreen(
                teamA = teamA,
                teamB = teamB,
                goalsA = goalsA,
                goalsB = goalsB,
                onNewGame = {
                    navController.navigate(Routes.CONFIG) {
                        popUpTo(Routes.CONFIG) { inclusive = true }
                    }
                }
            )
        }
    }
}
