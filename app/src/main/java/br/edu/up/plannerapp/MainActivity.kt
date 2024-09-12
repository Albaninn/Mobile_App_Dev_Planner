package br.edu.up.plannerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavDrawerMinimo()
            //TelaPrincipal()

            //PlannerTheme {
            //PlannerApp()
            //}
        }
    }
}

@Preview
@Composable
fun NavDrawerMinimo(){

    val state = rememberDrawerState(
        initialValue = DrawerValue.Open
    )

    ModalNavigationDrawer(
        drawerState = state,
        drawerContent = {
            Column(
                modifier = Modifier
                    .width(300.dp)
                    //.fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xFFC0E0FA)),
            ) {
                Spacer(modifier = Modifier.height(70.dp))
                Text(text = "Item 1", fontSize = 30.sp,
                    modifier = Modifier.padding(30.dp, 5.dp))
                Text(text = "Item 2", fontSize = 30.sp,
                    modifier = Modifier.padding(30.dp, 5.dp))
                Text(text = "Item 3", fontSize = 30.sp,
                    modifier = Modifier.padding(30.dp, 5.dp))
            }
        },
        content = {
            TelaPrincipal(state)
        }
    )
}


@Composable
fun TelaPrincipal(state: DrawerState){
    Scaffold(
        topBar = { TopBarMinima(state) },
        content = { p -> ConteudoDaPagina(Modifier.padding(p)) },
        floatingActionButton = { FloatingButton() },
        bottomBar = { BottomBarMinina() }
    )
//    { p -> ConteudoDaPagina(Modifier.padding(p)) }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarMinima(state: DrawerState){
    val scope = rememberCoroutineScope()
    //TopAppBar(
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name),
                fontSize = 35.sp,
                fontWeight = FontWeight(
                    integerResource(id = R.integer.peso)
                ),
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    state.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "=",
                    modifier = Modifier.size(
                        dimensionResource(id = R.dimen.icon_size)
                    ),
                    tint = Color.White)
            }
        },
        actions = {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.MoreVert,
                    contentDescription = ":",
                    modifier = Modifier.size(35.dp),
                    tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.azul) //  Color(0xFF2196F3)
        )
    )
}

@Composable
fun ConteudoDaPagina(padding: Modifier){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Conteúdo...", fontSize = 50.sp)
    }
}

@Composable
fun FloatingButton(){
    FloatingActionButton(onClick = {  }) {
        Icon(imageVector = Icons.Filled.Add,
            contentDescription = "+",
            modifier = Modifier.size(40.dp))
    }
}

@Composable
fun BottomBarMinina(){
    BottomAppBar(
        containerColor = Color(0x752196F3)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = Icons.Filled.DateRange,
                contentDescription = "d",
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(50.dp))
            Icon(imageVector = Icons.Filled.Email,
                contentDescription = "c",
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(50.dp))
            Icon(imageVector = Icons.Filled.Call,
                contentDescription = "+",
                modifier = Modifier.size(40.dp))
        }
    }
}
