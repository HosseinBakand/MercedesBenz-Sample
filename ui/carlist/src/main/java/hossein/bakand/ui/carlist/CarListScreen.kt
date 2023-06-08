package hossein.bakand.ui.carlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text

@Composable
fun CarListScreen(){
    CarListScreen("Mercedes")
}

@Composable
fun CarListScreen(title:String){
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = title
        )
    }
}