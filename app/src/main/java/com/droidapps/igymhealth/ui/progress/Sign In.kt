//package com.example.loginui
//
//import android.content.Context
//import android.graphics.drawable.Icon
//import android.graphics.fonts.FontFamily
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontFamily.Companion.Serif
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import org.w3c.dom.Text
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
////            LoginUI(applicationContext)
//        }
//    }
//
//}
//
//@Composable
//fun LoginUi(context: Context){
//    var email by remember { mutableStateOf(value = "") }
//    var password by remember { mutableStateOf(value = "") }
//    Column(
//        modifier = Modifier.fillMaxWidth().padding(20.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        //creating text fields
//        Text(
//            text = "Sign in",
//            fontFamily = FontFamily.Serif,
//            textAlign = TextAlign.Center,
//            fontSize = 40.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Yellow,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 20.dp)
//
//        )
//        //Editing text fields
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text(text = "Enter your email address") },
//            leadingIcon = {
//                Icon(Icons.Default.Email, contentDescription = "person's email")
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp, top = 10.dp)
//
//        )
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text(text = "Enter your password address") },
//            leadingIcon = {
//                Icon(Icons.Default.Info, contentDescription = "person's password")
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp, top = 10.dp),
//
//            //Visual transformation for masking the password
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        )
//        //creating the sign in button
//        OutlinedButton(
//            onClick = { logIn(email, password, context) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(all = 10.dp)
//        ) {
//            Text(
//                text = "Sign in",
//                textAlign = TextAlign.Center
//            )
//        }
//
//    }
//}
//
//fun logIn(email: String, password: String, context: Context) =
////function for checking whether details are in database
////function for checking whether email and password is correct
////function for testing in the demo
//    if (email == "none.none@igymhealth.demo" && password == "strong password") {
//        Toast.makeText(context, "Sign in successful", Toast.LENGTH_SHORT).show()
//    } else {
//        Toast.makeText(context, "Sign in failed. Please try again!", Toast.LENGTH_SHORT).show()
//    }
//// function for limiting the number of logins to 5 before temporary account suspension
//
//
