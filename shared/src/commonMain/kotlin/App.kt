import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

data class Feature(val name:String,val target:String)

@Composable
fun App() {

    val features = listOf()

    MaterialTheme {

        LazyColumn (Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {



        }
    }
}

expect fun getPlatformName(): String