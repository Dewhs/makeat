package com.example.makeat.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makeat.ui.components.MCheckbox
import com.example.makeat.ui.components.MTextField
import sv.lib.squircleshape.CornerSmoothing
import sv.lib.squircleshape.SquircleShape

@Composable
fun LoginPage(modifier: Modifier = Modifier) {

    val host = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val register = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.titleLarge,
            lineHeight = 116.sp
        )
        MTextField(
            label = "Host",
            value = host.value,
            onValueChange = { host.value = it },
            keyboardType = KeyboardType.Uri
        )
        MTextField(
            label = "Email",
            value = email.value,
            onValueChange = { email.value = it },
            keyboardType = KeyboardType.Email
        )
        MTextField(
            label = "Password",
            value = password.value,
            onValueChange = { password.value = it },
            keyboardType = KeyboardType.Password,
            hideContent = true
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = register.value,
                        onValueChange = { register.value = it }
                    )
                    .padding(8.dp)
            ) {
                MCheckbox(
                    checked = register.value,
                    onCheckedChange = null,
                    size = 20.dp
                )

                Spacer(modifier = Modifier.width(8.dp))
                Text("I don't have an account", style = MaterialTheme.typography.bodyMedium)
            }

            Button(
                onClick = { /* TODO: Action login */ },
                shape = SquircleShape(
                    radius = 25.dp,
                    cornerSmoothing = CornerSmoothing.Full
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Enter",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
}