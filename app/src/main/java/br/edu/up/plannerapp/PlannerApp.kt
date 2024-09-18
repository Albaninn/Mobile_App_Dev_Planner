package br.edu.up.plannerapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.up.plannerapp.ui.screens.TelaDois
import br.edu.up.plannerapp.ui.screens.TelaPrincipalA
import br.edu.up.plannerapp.ui.screens.TelaPrincipalB
import br.edu.up.plannerapp.ui.screens.TelaTres
import kotlinx.coroutines.launch

object PlannerRotas {
    val TelaPrincipalA = "principal"
    val Tela2= "dois"
    val Tela3 = "tres"
}

@Preview
@Composable
fun PlannerApp() {

    val state = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route ?: PlannerRotas.TelaPrincipalA
    val telaPrincipalSelect = rotaAtual == PlannerRotas.TelaPrincipalA
    val telaDoisSelect = rotaAtual == PlannerRotas.Tela2
    val telaTresSelect = rotaAtual == PlannerRotas.Tela3

    ModalNavigationDrawer(
        drawerState = state,
        drawerContent = {
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .fillMaxHeight()
                    .background(Color(0xFF59B7FF)),
            ) {
                Spacer(modifier = Modifier.height(70.dp))
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = getBack(telaPrincipalSelect)
                    ),
                        onClick = {
                        navController.navigate(PlannerRotas.TelaPrincipalA)
                        coroutineScope.launch { state.close() }
                    }) {
                        Icon(painter = painterResource(id = R.drawable.checklist),
                            contentDescription = "D",
                            modifier = Modifier.size(40.dp),
                            tint = getTint(telaPrincipalSelect)
                        )
                        Text(
                            color = getTint(telaPrincipalSelect),
                            text = "Tela Principal", fontSize = 30.sp,
                            modifier = Modifier.padding(30.dp, 5.dp)
                        )
                }
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = getBack(telaDoisSelect)
                    ),
                    onClick = {
                    navController.navigate(PlannerRotas.Tela2)
                    coroutineScope.launch { state.close() }
                }) {
                    Icon(painter = painterResource(id = R.drawable.checklist),
                        contentDescription = "D",
                        modifier = Modifier.size(40.dp),
                        tint = getTint(telaDoisSelect)
                    )
                    Text(
                        color = getTint(telaDoisSelect),
                        text = "Tela Dois", fontSize = 30.sp,
                        modifier = Modifier.padding(30.dp, 5.dp)
                    )
                }
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = getBack(telaTresSelect)
                    ),
                    onClick = {
                    navController.navigate(PlannerRotas.Tela3)
                    coroutineScope.launch { state.close() }
                }) {
                    Icon(painter = painterResource(id = R.drawable.checklist),
                        contentDescription = "D",
                        modifier = Modifier.size(40.dp),
                        tint = getTint(telaTresSelect)
                    )
                    Text(
                        color = getTint(telaTresSelect),
                        text = "Tela Três", fontSize = 30.sp,
                        modifier = Modifier.padding(30.dp, 5.dp)
                    )
                }
            }
        },
        content = { PlannerNavHost(navController, state) }
    )
}

@Composable
private fun PlannerNavHost(
    navController: NavHostController,
    state: DrawerState
) {
    NavHost(
        navController = navController,
        startDestination = PlannerRotas.TelaPrincipalA
    ) {
        composable(PlannerRotas.TelaPrincipalA) {
            TelaPrincipalA(state)
        }
        composable(PlannerRotas.Tela2) {
            TelaDois(state)
        }
        composable(PlannerRotas.Tela3) {
            TelaTres(state)
        }
    }
}

fun getTint(selected: Boolean): Color {
    if (selected){
        return Color.Black
    }else{
        return Color.DarkGray
    }
}

fun getBack(selected: Boolean): Color {
    if (selected){
        return Color.LightGray
    }else{
        return Color.Transparent
    }
}