package br.edu.up.plannerapp.ui.screens.tarefas.afazeres

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.plannerapp.data.Afazer
import br.edu.up.plannerapp.ui.screens.util.PlannerTopBar

@Composable
fun ListarAfazeresScreen(
    afazeres: MutableList<Afazer>,
    state: DrawerState,
    navController: NavController,
    bottonNavBar: @Composable () -> Unit
) {

    Scaffold(
        topBar = { PlannerTopBar(state) },
        content = { iPad ->
            iPad
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(130.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(afazeres) { afazer ->
                        Row {
                            Checkbox(checked = afazer.concluido, onCheckedChange = {
                                //todo
                            })
                            Text(text = afazer.titulo, fontSize = 50.sp)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))
            }
        },
        floatingActionButton = {

            FloatingActionButton(onClick = {
                navController.navigate(TelaUmARotas.INCLUIR_AFAZER_ROUTE)
            }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "+",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        bottomBar = { bottonNavBar() }
    )
}