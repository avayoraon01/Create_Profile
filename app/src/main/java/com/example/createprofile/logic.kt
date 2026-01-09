package com.example.createprofile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profiles() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Create Profile") }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues =it )
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

            )
        {
            var name by rememberSaveable { mutableStateOf("") }
            var email by rememberSaveable { mutableStateOf("") }
            var phone by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var confirmPassword by rememberSaveable { mutableStateOf("") }
            var bio by rememberSaveable { mutableStateOf("") }
            val isNameValid = name.length >= 3
            val isEmailValid = email.contains("@") && email.contains(".")
            val isPhoneValid = phone.length == 10
            val isPasswordValid = password.length >= 6
            val isPasswordMatch = password == confirmPassword
            var passwordVisibility by remember { mutableStateOf(false) }
            val isFormValid =
                isNameValid &&
                        isEmailValid &&
                        isPhoneValid &&
                        isPasswordValid &&
                        isPasswordMatch

            TextField(
                value = name,
                onValueChange = { newName -> name = newName },
                isError = name.isNotEmpty() && !isNameValid,
                supportingText = {
                    if (name.isNotEmpty() && !isNameValid) {
                        Text(
                            text = "Name must be at least 3 characters"
                        )
                    }
                },
                label = { Text(text = "Name") },
                modifier = Modifier.padding(16.dp),
                singleLine = true,
                placeholder = { Text(text = "Enter your name") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                maxLines = 1,
            )
            TextField(
                value = email,
                onValueChange = { newEmail -> email = newEmail },
                isError = email.isNotEmpty() && !isEmailValid,
                supportingText = {
                    if (email.isNotEmpty() && !isEmailValid) {
                        Text(
                            text = "Enter valid email"
                        )
                    }
                },
                singleLine = true,
                placeholder = { Text(text = "Enter your email") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(16.dp),
                label = { Text(text = "Email") },
                maxLines = 1,

                )

            TextField(
                value = phone,
                onValueChange = {
                    if (it.length <= 10 &&it.all { char -> char.isDigit() }) {
                        phone = it
                    }
                },
                isError = phone.isNotEmpty() && !isPhoneValid,
                supportingText = {
                    if (phone.isNotEmpty() && !isPhoneValid) {
                        Text(
                            text = "Enter valid phone number"
                        )
                    }
                },
                singleLine = true,
                placeholder = { Text(text = "Enter your phone number") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(16.dp),
                label = { Text(text = "Phone") },
                maxLines = 1,

                )

            TextField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                placeholder = { Text(text = "create password") },
                isError = password.isNotEmpty() && !isPasswordValid,
                supportingText = {
                    if (password.isNotEmpty() && !isPasswordValid) {
                        Text(
                            text = "Password must be at least 6 characters"
                        )
                    }
                },
                label = { Text(text = "Password") },
                modifier = Modifier.padding(16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                maxLines = 1,
                singleLine = true,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            painter = painterResource(if (passwordVisibility) R.drawable.visibilityoff else R.drawable.design_ic_visibility),
                            contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                        )

                    }
                }

            )
            TextField(
                value = confirmPassword,
                onValueChange = { newPassword -> confirmPassword = newPassword },
                placeholder = { Text(text = "Re-enter your password") },
                isError = confirmPassword.isNotEmpty() && !isPasswordMatch,
                supportingText = {
                    if (confirmPassword.isNotEmpty() && !isPasswordMatch) {
                        Text(
                            text = "Password do not match"
                        )
                    }
                },
                label = { Text(text = "Conform Password") },
                modifier = Modifier.padding(16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                maxLines = 1,
                singleLine = true,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            painter = painterResource(if (passwordVisibility) R.drawable.visibilityoff else R.drawable.design_ic_visibility),
                            contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                        )

                    }
                }


            )

            TextField(
                value = bio,
                onValueChange = { newBio -> bio = newBio },
                placeholder = { Text(text = "Enter your bio") },
                label = { Text(text = "Bio") },
                modifier = Modifier.padding(16.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                maxLines = 4,
                singleLine = false,
            )
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                enabled = isFormValid,
                contentPadding = PaddingValues(16.dp),
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Account created successfully")
                    }
                })
            {
                Text(text = "Create Account")
            }
        }
    }
}