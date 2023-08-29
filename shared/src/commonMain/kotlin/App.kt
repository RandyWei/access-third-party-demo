import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.transitions.SlideTransition
import wechat.WXFeatureScreen


data class Feature(val name: String, val target: Screen)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun App() {
    Navigator(Home) {
        SlideTransition(it)
    }
}

object Home : Screen {
    @Composable
    override fun Content() {



        val features = listOf(Feature("微信open sdk功能", WXFeatureScreen))

        val navigator = LocalNavigator.currentOrThrow

        MaterialTheme {

            LazyColumn(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(features) { feature ->

                    Card(modifier=Modifier.padding(8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(8.dp).clickable {
                                navigator.push(feature.target)
                            },
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(feature.name)

                            Icon(Icons.Default.ArrowForward, contentDescription = null)
                        }
                    }

                }

            }
        }
    }

}

expect fun getPlatformName(): String