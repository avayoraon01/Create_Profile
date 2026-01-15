package com.example.createprofile

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
   NavHost(
        navController = navController,
      startDestination = Screen.CreateProfile.route
    ){
       composable(
          route = Screen.CreateProfile.route
       ){
           Profiles(navController = navController)
       }
       composable(
           route = Screen.Dashboard.route
       ){
            Dashboard(navController = navController)
       }
   }
}