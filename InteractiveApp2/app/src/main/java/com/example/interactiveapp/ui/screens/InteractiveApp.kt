package com.example.interactiveapp.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interactiveapp.R

@Composable
fun InteractiveApp() {
	var expanded by remember {
		mutableStateOf(false)
	}
	val (showInputs, setShowInputs) = remember { mutableStateOf(false) }
	val (nameInput, setNameInput) = remember { mutableStateOf("") }
	val (surnameInput, setSurnameInput) = remember {mutableStateOf("")}


	Column (
		modifier = Modifier
			.fillMaxSize()
			.wrapContentWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	){
		Image(
			painter = painterResource(id = R.drawable.slika1),
			contentDescription = ""
		)

		Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

		Text(
			text = "Jetpack Compose tutorial",
			modifier = Modifier.padding(horizontal = 16.dp)
		)

		Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

		Text (
			text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n" +
					"\n" +
					"\n" +
					"In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app's UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI's construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.\n",
			maxLines = if(!expanded) 3 else Int.MAX_VALUE,
			modifier = Modifier
				.animateContentSize()
				.padding(horizontal = 16.dp)
		)

		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			TextButton(onClick = { expanded = !expanded }) {
				Text(text = if(!expanded) "Show more" else "Show less")
			}
		}

		Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

		Button(onClick = { setShowInputs(true) }) {
			Text("Subscribe")
		}

		if(showInputs) {
			Column {
				Text(
					text = "Please enter your name and surname"
				)
				TextField(
					value = nameInput,
					onValueChange = { setNameInput(it) },
					label = { Text("Name")},
					modifier = Modifier.padding(horizontal = 16.dp)
				)
				TextField(
					value = surnameInput,
					onValueChange = { setSurnameInput(it) },
					label = { Text("Surname")},
					modifier = Modifier.padding(horizontal = 16.dp)
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun InteractiveAppPreview() {
	InteractiveApp()
}