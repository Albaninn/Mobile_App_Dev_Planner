package br.edu.up.plannerapp.ui.screens.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PlannerBottomBar(){
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

@Composable
fun PlannerBottomNavBar(){
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