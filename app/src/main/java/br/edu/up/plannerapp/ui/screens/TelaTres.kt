package br.edu.up.plannerapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import br.edu.up.plannerapp.ui.screens.util.PlannerBottomBar
import br.edu.up.plannerapp.ui.screens.util.PlannerTopBar

@Composable
fun TelaTres(state: DrawerState){
    Scaffold(
        topBar = { PlannerTopBar(state) },
        content = { p -> ConteudoPaginaTres(Modifier.padding(p)) },
        floatingActionButton = { FloatingButton() },
        bottomBar = { PlannerBottomBar() }
    )
//    { p -> ConteudoDaPagina(Modifier.padding(p)) }
}
@Composable
fun ConteudoPaginaTres(padding: Modifier){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Página 3", fontSize = 50.sp)
    }
}