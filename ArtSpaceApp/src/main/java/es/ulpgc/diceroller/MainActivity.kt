package es.ulpgc.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.ulpgc.diceroller.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtApp()
            }
        }
    }
}


@Composable
fun ArtApp() {
    BoxWithConstraints {
        // Calcula si está en modo horizontal o vertical
        val isLandscape = maxWidth > maxHeight

        // Lista de obras de arte
        val artworks = listOf(
            Artwork(R.drawable.jovenperla, "La joven de la perla", "Johannes Vermeer"),
            Artwork(R.drawable.meninas, "Las meninas", "Diego Velázquez"),
            Artwork(R.drawable.monalisa, "La Mona Lisa", "Leonardo da Vinci"),
            Artwork(R.drawable.nocheestrellada, "La noche estrellada", "Vincent van Gogh")
        )
        var currentArtIndex by remember { mutableStateOf(0) }

        // Layout de la aplicación
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de la obra de arte
            Image(
                painter = painterResource(id = artworks[currentArtIndex].imageRes),
                contentDescription = artworks[currentArtIndex].title,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )

            // Caja para el texto con color de fondo
            Surface(
                modifier = Modifier.padding(4.dp).fillMaxWidth(),
                color = Color(0xFFEEEEEE) // Color gris claro
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título de la obra de arte
                    Text(
                        text = artworks[currentArtIndex].title,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = if (isLandscape) 24.sp else 18.sp // Tamaño de texto diferente en modo horizontal
                        )
                    )
                    // Autor de la obra de arte
                    Text(
                        text = "by ${artworks[currentArtIndex].author}",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = if (isLandscape) 20.sp else 14.sp // Tamaño de texto diferente en modo horizontal
                        )
                    )
                }
            }

            // Botones para navegar
            if (isLandscape) Spacer(modifier = Modifier.height(8.dp)) // Espacio adicional en modo horizontal

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Botón 'Previous' alineado a la izquierda
                Button(
                    onClick = {
                        if (currentArtIndex > 0) currentArtIndex--
                    },
                    modifier = Modifier.align(Alignment.CenterStart) // Alinea el botón al inicio (izquierda)
                ) {
                    Text(text = "Previous", style = TextStyle(fontSize = 18.sp))
                }

                // Botón 'Next' alineado a la derecha
                Button(
                    onClick = {
                        if (currentArtIndex < artworks.size - 1) currentArtIndex++
                    },
                    modifier = Modifier.align(Alignment.CenterEnd) // Alinea el botón al final (derecha)
                ) {
                    Text(text = "Next", style = TextStyle(fontSize = 18.sp))
                }
            }
        }
    }
}


// Clase para definir las obras de arte
data class Artwork(val imageRes: Int, val title: String, val author: String)




