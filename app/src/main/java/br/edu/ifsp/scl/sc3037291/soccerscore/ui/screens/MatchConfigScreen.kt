package br.edu.ifsp.scl.sc3037291.soccerscore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun MatchConfigScreen(
    onNavigateToSummary: (String, String, Int, Int) -> Unit
) {
    var teamA by rememberSaveable { mutableStateOf("") }
    var teamB by rememberSaveable { mutableStateOf("") }
    var goalsA by rememberSaveable { mutableStateOf("") }
    var goalsB by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = teamA,
            onValueChange = { teamA = it },
            label = { Text("Nome do Time A") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = teamB,
            onValueChange = { teamB = it },
            label = { Text("Nome do Time B") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = goalsA,
            onValueChange = { goalsA = it },
            label = { Text("Gols do Time A") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = goalsB,
            onValueChange = { goalsB = it },
            label = { Text("Gols do Time B") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val gA = goalsA.toIntOrNull()
                val gB = goalsB.toIntOrNull()
                if (teamA.isNotBlank() && teamB.isNotBlank() && gA != null && gB != null && gA >= 0 && gB >= 0) {
                    onNavigateToSummary(teamA, teamB, gA, gB)
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Ver Resultado")
        }
    }
}
