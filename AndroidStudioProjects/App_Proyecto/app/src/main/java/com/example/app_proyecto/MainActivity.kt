package com.example.app_proyecto


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_proyecto.ui.theme.App_ProyectoTheme

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent {
                scope.launch { drawerState.close() }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                DailyPlanContent()
            }
        }
    }
}

//Las opciones que se muestran al darle click al botón de display en la esquina superior de la pantalla
@Composable
fun DrawerContent(onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Menú",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        //Aquí irán las opciones al desplegar el botón ubicado en la esquina superior izquierda
        Text(
            text = "Inicio",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick() }
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Crear plan personalizado",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick() }
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Mi plan de comidas",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick() }
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Recetario peruano",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick() }
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Favoritos",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick() }
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Perfil del usuario",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick() }
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Historial",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick() }
                .padding(vertical = 8.dp)
        )
    }
}

@Composable
fun DailyPlanContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            GreetingSection()
            Spacer(modifier = Modifier.height(24.dp))
            DailyPlanSection()
            Spacer(modifier = Modifier.height(24.dp))
            ViewDetailsSection()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun GreetingSection() {
    Column {
        Text(
            text = "¡Buenos días!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Hoy es sábado 10 de mayo",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun DailyPlanSection() {
    Column {

        Text(
            text = "PLAN DE HOY",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)  //Altura de la imagen fija
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ajidegallina),
                contentDescription = "Plato del día",
                modifier = Modifier
                    .fillMaxWidth(0.9f)  //90% del ancho disponible
                    .height(200.dp),  //Se define la altura de la imagen
                contentScale = ContentScale.Crop  //Escala de la imagen
            )
        }


        MealItem("Desayuno:", "Pan con palta y quinua atamalada")
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        MealItem("Almuerzo:", "Ají de gallina con arroz integral")
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        MealItem("Cena:", "Sopa de quinua y ensalada fresca")
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        MealItem("Snack:", "Yogur natural con frutas")
    }
}

@Composable
fun MealItem(mealType: String, description: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = mealType,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(0.3f)
        )
        Text(
            text = description,
            modifier = Modifier.weight(0.7f)
        )
    }
}


@Composable
fun ViewDetailsSection() {
    //Aquí se definen los estados para los checkboxes (los botones de 'check')
    val (recChecked, setRecChecked) = remember { mutableStateOf(false) }
    val (waterChecked, setWaterChecked) = remember { mutableStateOf(true) }
    val (menuChecked, setMenuChecked) = remember { mutableStateOf(false) }
    val (shoppingChecked, setShoppingChecked) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Botón de 'VER DETALLE DEL DÍA'
        Button(
            onClick = { /* Aquí falta implementar la lógica que se mostrará cuando el usuario da click en el botón */ },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(0.7f)
        ) {
            Text("VER DETALLE DEL DÍA")
        }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        //Sección de recomendación (texto e imagen)
        Text(
            text = "RECOMENDACIÓN DEL DÍA:",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)  //Se le define una altura fija
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.quinua),
                contentDescription = "Recomendación",
                modifier = Modifier
                    .fillMaxWidth(0.9f)  //90% del ancho disponible
                    .height(200.dp),  //Aquí se define la altura fija
                contentScale = ContentScale.Crop  //Se define el ajuste de escala de la imagen
            )
        }



        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = recChecked,
                onCheckedChange = { setRecChecked(it) },
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text("La quinua es rica en proteína vegetal.")
                Text("Agrégala a tus sopas.")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Esta es la sección de notificaciones
        Text(
            text = "NOTIFICACIONES:",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
        )

        NotificationItem(
            text = "Te faltan 2 vasos de agua",
            checked = waterChecked,
            onCheckedChange = { setWaterChecked(it) }
        )
        NotificationItem(
            text = "¿Quieres un menú especial para mañana sábado?",
            checked = menuChecked,
            onCheckedChange = { setMenuChecked(it) }
        )
        NotificationItem(
            text = "Recuerda comprar palta y huevo",
            checked = shoppingChecked,
            onCheckedChange = { setShoppingChecked(it) }
        )
    }
}

@Composable
fun NotificationItem(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}




@Composable
fun NotificationItem(text: String, checked: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {},
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        MainScreen()
    }
}