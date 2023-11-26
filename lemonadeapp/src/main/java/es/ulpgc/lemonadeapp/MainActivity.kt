package es.ulpgc.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import es.ulpgc.lemonadeapp.ui.theme.LemonadeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    val lemonadeViewModel = viewModel<LemonadeViewModel>()
    val currentStep by lemonadeViewModel.currentStep.observeAsState(1)

    Scaffold(
        topBar = { LemonadeTopBar() }
    ) { innerPadding ->
        LemonadeContent(
            currentStep = currentStep,
            onImageClick = lemonadeViewModel::handleImageClick,
            innerPadding = innerPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeTopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Lemonade", fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius_forButton)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.image_width_forButton))
                        .height(dimensionResource(R.dimen.image_height_forButton))
                        .padding(dimensionResource(R.dimen.interior_padding_forButton))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.verticalPadding)))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
fun LemonadeContent(
    currentStep: Int,
    onImageClick: () -> Unit,
    innerPadding: PaddingValues
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> LemonStepContent(R.string.SelectLemon, R.drawable.lemon_tree, R.string.LemonTree, onImageClick)
            2 -> LemonStepContent(R.string.SqueezeLemon, R.drawable.lemon_squeeze, R.string.Lemon, onImageClick)
            3 -> LemonStepContent(R.string.DrinkLemonade, R.drawable.lemon_drink, R.string.GlassOfLemonade, onImageClick)
            4 -> LemonStepContent(R.string.StartAgain, R.drawable.lemon_restart, R.string.EmptyGlass, onImageClick)
        }
    }
}

@Composable
fun LemonStepContent(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit
) {
    LemonTextAndImage(
        textLabelResourceId = textLabelResourceId,
        drawableResourceId = drawableResourceId,
        contentDescriptionResourceId = contentDescriptionResourceId,
        onImageClick = onImageClick
    )
}

class LemonadeViewModel : ViewModel() {

    private val _currentStep = MutableLiveData(1)
    val currentStep: LiveData<Int> = _currentStep

    // Contador para las veces que se exprime el limón
    private var squeezeCount = 0

    fun handleImageClick() {
        when (_currentStep.value) {
            1 -> startSqueezing()
            2 -> squeezeLemon()
            3 -> drinkLemonade()
            4 -> restart()
        }
    }

    private fun startSqueezing() {
        squeezeCount = (2..4).random() // Número aleatorio de veces para exprimir
        _currentStep.value = 2
    }

    private fun squeezeLemon() {
        if (squeezeCount > 0) {
            squeezeCount--
            if (squeezeCount == 0) {
                _currentStep.value = 3 // Cambiar al paso de beber limonada
            }
        }
    }

    private fun drinkLemonade() {
        _currentStep.value = 4 // Cambiar al paso de reinicio
    }

    private fun restart() {
        _currentStep.value = 1 // Volver al primer paso
    }
}

@Preview
@Composable
fun LemonPreview() {
    LemonadeAppTheme {
        LemonadeApp()
    }
}