package com.example.greetingcard

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Tarjeta()
            }
        }
    }
}

@Composable
fun Tarjeta(modifier: Modifier=Modifier) {


    var image=painterResource(R.drawable.images2)


    //El primer column es para alinear la posición de la columna (vertical y horizontal)
    Column(
        modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally
    ) {

        //El segundo column es para colocar la imagen y ambos textos en una misma columna, y especificar sus propiedades
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp) //Espacio entre las imágenes y los textos
        )
        {

            Image(
                painter = image,
                contentDescription = "Image"
            )

            Column(
                verticalArrangement=Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("DIANA MARYSABELL LLAMOCA ZÁRATE", fontSize = 20f.sp)
                Text("ALEXANDRA NANCY LIMA QUISPE",fontSize=20f.sp)
                Text("UPCH", fontSize = 30f.sp)
            }
        }
    }



    Box(modifier=modifier.fillMaxSize())
    {
        Box(
            modifier = Modifier
                .size(400.dp) //Aquí ajusto el tamaño del box
                .offset(x = 0.dp, y = 100.dp) //Defino la posición específica del box
                .align(Alignment.BottomCenter)
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp), //Defino el espacio entre los elementos
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.telefono), //Aquí cargo la imagen
                            contentDescription = "Icono 1",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp)) //Defino el espacio entre la imagen y el texto

                        Column() {
                            Text("+51 960 971 324", fontSize = 22f.sp)
                            Text("+51 988 954 149", fontSize = 22f.sp)
                        }


                    }
                }

                //Coloco espacios entre los elementos
                Spacer(modifier = Modifier.width(10.dp))

                Box() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.github), //Aquí cargo la imagen
                            contentDescription = "Icono 2",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp)) //Defino el espacio entre la imagen y el texto
                        Column() {
                            Text("DianaLlamoca", fontSize = 22f.sp)
                            Text("alexandralima1602", fontSize = 22f.sp)
                        }
                    }
                }

                //Coloco espacios entre los elementos
                Spacer(modifier = Modifier.width(10.dp))
                Box() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gmail), //Aquí cargo la imagen
                            contentDescription = "Icono 3",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp)) //Defino el espacio entre la imagen y el texto
                        Column() {
                            Text("DIANA.LLAMOCA@UPCH.PE", fontSize = 18f.sp)
                            Text("ALEXANDRA.LIMA@UPCH.PE", fontSize = 18f.sp)
                        }
                    }
                }
            }

        }
    }

}