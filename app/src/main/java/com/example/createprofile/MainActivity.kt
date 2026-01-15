package com.example.createprofile

     import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
     import androidx.navigation.NavHostController
     import androidx.navigation.compose.rememberNavController
     import com.example.createprofile.ui.theme.CreateProfileTheme


class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CreateProfileTheme {
                navController = rememberNavController()
               SetupNavGraph(navController = navController)
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CreateProfileTheme {
        Profiles(navController = rememberNavController())

    }
}
