package br.edu.up.plannerapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.up.plannerapp.ui.theme.CorDeTitulo

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PlannerApp(){
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Text(text = "Planner",
                        fontWeight = FontWeight(600),
                        color = Color.White
                    )
                }
            },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            tint = Color.White,
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Menu",
                            modifier = Modifier.size(40.dp)
                                .fillMaxWidth()
                                .padding(8.dp)

                        )
                    }
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            tint = Color.White,
                            contentDescription = "Menu",
                            modifier = Modifier.size(40.dp)
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(CorDeTitulo)
            )
        },
        content = { innerPadding ->
            Text(text = "Planner", Modifier.padding(innerPadding))
        }
    )
}