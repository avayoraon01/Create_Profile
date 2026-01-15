package com.example.createprofile

sealed class Screen(var route:String ){
    object CreateProfile:Screen("create_profile")
    object Dashboard:Screen("dashboard")


}