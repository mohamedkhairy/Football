import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.football.navigation.Screen
import com.example.home.presentation.screens.HomeScreen


@Composable
fun NavigationSystem() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        builder = {
            addHomeScreen()
        }
    )

}


fun NavGraphBuilder.addHomeScreen(
) {
    composable(
        route = Screen.Home.route,
    ){
        HomeScreen()
    }
}




