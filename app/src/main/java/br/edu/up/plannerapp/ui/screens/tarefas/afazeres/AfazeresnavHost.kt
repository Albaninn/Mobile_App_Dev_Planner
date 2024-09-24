package br.edu.up.plannerapp.ui.screens.tarefas.afazeres

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.plannerapp.data.Afazer

object TelaUmARotas {
    val LISTAR_AFAZARES_ROUTE = "listar_afazeres"
    val VISUALIZAR_AFAZER_ROUTE = "visualizar_afazer"
    val EDITAR_AFAZER_ROUTE = "editar_afazer"
    val INCLUIR_AFAZER_ROUTE = "incluir_afazer"
}

@Composable
fun AfazeresNavHost(state: DrawerState, bottonNavBar: @Composable () -> Unit) {

    val navController = rememberNavController()

    var afazeres = remember {
        mutableStateListOf(
            Afazer(
                titulo = "Afazer 1",
                descricao = "Descricao 1",
                concluido = false,
                id = 1
            ),
            Afazer(
                titulo = "Afazer 2",
                descricao = "Descricao 2",
                concluido = false,
                id = 2
            ),
            Afazer(
                titulo = "Afazer 3",
                descricao = "Descricao 3",
                concluido = false,
                id = 3
            )
        )
    }

    NavHost(
        navController = navController,
        startDestination = TelaUmARotas.LISTAR_AFAZARES_ROUTE
    ) {
        composable(TelaUmARotas.LISTAR_AFAZARES_ROUTE) {
            ListarAfazeresScreen(afazeres, state, navController, bottonNavBar)
        }
        composable(TelaUmARotas.VISUALIZAR_AFAZER_ROUTE) {

        }
        composable(TelaUmARotas.EDITAR_AFAZER_ROUTE) {
            CriarOuEditarAfazerScreen(
                Afazer("", ""),
                aoSalvar = { afazerEditado ->
                    //Simulação de salvar na lista de memória como
                    //se fosse uma inclusão no banco de dados.
                    val index = afazeres.indexOfFirst { it.id == afazerEditado.id }
                    if (index != -1){
                        afazeres[index] = afazerEditado
                    }
                    navController.navigate(TelaUmARotas.LISTAR_AFAZARES_ROUTE)
                },
                state,
                navController,
                bottonNavBar
            )
        }
        composable(TelaUmARotas.INCLUIR_AFAZER_ROUTE) {
            CriarOuEditarAfazerScreen(
                aoSalvar = { novoAfazer ->
                    novoAfazer.id = (afazeres.maxByOrNull { it.id ?: 0 }?.id?:0) + 1
                    afazeres.add(novoAfazer)
                    navController.navigate(TelaUmARotas.LISTAR_AFAZARES_ROUTE)
                },
                state = state,
                navController = navController,
                bottonNavBar = bottonNavBar
            )
        }
    }

}