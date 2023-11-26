package es.ulpgc.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import es.ulpgc.diceroller.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ArtApp()
            }
        }
    }
}


@Composable
fun ArtApp() {
    // Suponiendo que tienes una lista de obras de arte
    val artworks = listOf(
        Artwork(R.drawable.jovenperla, "La joven de la perla", "Johannes Vermeer"),
        Artwork(R.drawable.meninas, "Las meninas", "Diego Velázquez"),
        Artwork(R.drawable.monalisa, "La Mona Lisa", " Leonardo da Vinci"),
        Artwork(R.drawable.nocheestrellada, "La noche estrellada", "Vincent van Gogh ")
    )
    var currentArtIndex by remember { mutableStateOf(0) }

    // Crear un composable que muestra la obra de arte actual
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen de la obra de arte
        Image(
            painter = painterResource(id = artworks[currentArtIndex].imageRes),
            contentDescription = artworks[currentArtIndex].title
        )

        // Título y autor de la obra de arte
        Text(text = artworks[currentArtIndex].title)
        Text(text = "by ${artworks[currentArtIndex].author}",
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

        // Botones para navegar a la siguiente y anterior obra de arte
        Row {
            Button(onClick = {
                if (currentArtIndex > 0) currentArtIndex--
            }) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(18.dp))
            Button(onClick = {
                if (currentArtIndex < artworks.size - 1) currentArtIndex++
            }) {
                Text(text = "Next")
            }
        }
    }
}

// Definir una clase para las obras de arte
data class Artwork(val imageRes: Int, val title: String, val author: String)




