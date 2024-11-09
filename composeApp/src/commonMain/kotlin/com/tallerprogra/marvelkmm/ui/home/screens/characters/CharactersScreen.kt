package com.tallerprogra.marvelkmm.ui.home.screens.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import com.tallerprogra.marvelkmm.ui.core.extensions.vertical
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharactersScreen() {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val characterList by charactersViewModel.characters.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(items = characterList) { character ->
            CharacterModelItem(character)
        }
    }
//    Box(Modifier.fillMaxSize().background(Color.DarkGray))
}

@Composable
fun CharacterItem(character: CharacterModel) {
    Row(modifier = Modifier.padding(12.dp)) {
        Text(
            text = character.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        // Aquí puedes agregar una imagen si el personaje tiene una URL de imagen
    }
}



@Composable
fun CharacterModelItem(characterModel: CharacterModel? = null) {

    Spacer(modifier = Modifier.fillMaxWidth().height(4.dp))
    Card(
        modifier = Modifier.fillMaxWidth().height(200.dp),
        shape = RoundedCornerShape(12)
    ) {
        if (characterModel == null) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(color = Color.Green)
            }
        } else {
            Box(contentAlignment = Alignment.BottomStart) {
                AsyncImage(
                    model = characterModel.thumbnail,
                    contentDescription = "Character from Marvel API",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    Modifier.fillMaxSize().background(
                        Brush.horizontalGradient(
                            0f to Color.Black.copy(alpha = 0.9f),
                            0.5f to Color.White.copy(alpha = 0f),
                            1f to Color.White.copy(alpha = 0f)
                        )
                    )
                )
                Text(
                    characterModel.name,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    minLines = 1,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                        .vertical()
                        .fillMaxHeight()
                        .rotate(-90f)
                )
            }
        }
    }
    CharacterModelDescriptionCard(characterModel)
    Spacer(modifier = Modifier.fillMaxWidth().height(4.dp))
}


@Composable
fun CharacterModelDescriptionCard(
    characterModel: CharacterModel? = null
) {
    Spacer(modifier = Modifier.fillMaxWidth().height(1.dp))
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(
                color = Color.White.copy(alpha = 0.5f),
                shape = RoundedCornerShape(8.dp),
            ).padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            if (characterModel!!.description.isNotBlank()) {
                Text(
                    text = characterModel.description,
                    style = MaterialTheme.typography.bodyMedium,
                    minLines = 1,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            } else {
                Text(
                    "Information classified by the S.H.I.E.L.D. bureau.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
            }

        }
    }
}