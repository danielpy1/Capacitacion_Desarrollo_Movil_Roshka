package com.cursosandroidant.jetpackcomposeinstagram

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
        Body(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
        )
        Footer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }

}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier) {
        Divider()
        SignUp(modifier)
    }
}

@Composable
fun SignUp(modifier: Modifier) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Don't have an account?", modifier = Modifier.padding(end = 4.dp))
        Text(
            text = "Sign up.",
            fontWeight = FontWeight.Bold,
            color = Color(0xff1BBBEA),
            modifier = Modifier.clickable { })
    }
}

@Composable
fun Body(modifier: Modifier) {
    var user_name by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnabled by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        ImageHeader(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        Email(modifier = Modifier, text = user_name, onValueChange = {
            user_name = it
            isLoginEnabled = enableLogin(user_name, password)
        })
        Spacer(modifier = Modifier.height(8.dp))
        Password(modifier = Modifier, text = password, onValueChange = {
            password = it
            isLoginEnabled = enableLogin(user_name, password)
        })
        Spacer(modifier = Modifier.height(8.dp))
        ForgotPaswword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(16.dp))
        LoginButton(isLoginEnabled)
        Spacer(modifier = Modifier.height(16.dp))
        OrComponent()
        Spacer(modifier = Modifier.height(24.dp))
        ContinueWithFacebook(modifier = Modifier.align(Alignment.CenterHorizontally))

    }
}

@Composable
fun ContinueWithFacebook(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "logo_facebook",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Jose Luis Cazal",
            modifier = modifier
                .clickable { }
                .padding(start = 12.dp),
            color = Color(0xff1BBBEA), fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun OrComponent() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Divider(Modifier.weight(1f))
        Text(
            text = "OR", modifier = Modifier
                .padding(horizontal = 16.dp), fontWeight = FontWeight.Bold
        )
        Divider(Modifier.weight(1f))
    }
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    OutlinedButton(
        onClick = { },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xff1BBBEA),
            disabledContainerColor = Color(0xff1BBBEA).copy(alpha = 0.5f),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log in")
    }
}

@Composable
fun ForgotPaswword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xff1BBBEA),

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(modifier: Modifier, text: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = { onValueChange(it) },
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color(0xff1BBBEA)
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(modifier: Modifier, text: String, onValueChange: (String) -> Unit) {
    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }
    TextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = text,
        onValueChange = { onValueChange(it) },
        placeholder = { Text(text = "Password") },
        modifier = modifier.fillMaxWidth(),
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xff1BBBEA),
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = imagen, contentDescription = "Password visibility")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}


@Composable
fun ImageHeader(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "logo_insta",
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close app",
        modifier = modifier.clickable { activity.finish() })
}

fun enableLogin(user_name: String, password: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(user_name).matches() && password.length >= 8
}