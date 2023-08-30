package wechat

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import wechat.platform.OpenSDK
import wechat.platform.WXScene
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

object WXFeatureScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)
    @Composable
    override fun Content() {


        val navigator = LocalNavigator.currentOrThrow
        val scope = rememberCoroutineScope()
        Scaffold(topBar = {
            CenterAlignedTopAppBar(title = {
                Text("微信Open SDK")
            }, navigationIcon = {
                IconButton(onClick = {
                    navigator.pop()
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            })
        }) {
            LazyColumn(modifier = Modifier.fillMaxWidth().padding(it)) {
                item {
                    Button(modifier = Modifier.fillMaxWidth(), onClick = {
                        OpenSDK.shareText("示例文本", WXScene.Session)
                    }) {
                        Text("分享文本")
                    }
                }

                item {
                    Button(modifier = Modifier.fillMaxWidth(), onClick = {
                        scope.launch {
                            OpenSDK.shareUrl(
                                "https://www.baidu.com",
                                "百度",
                                "分享百度",
                                resource("demo@4x.png").readBytes(),
                                WXScene.Session
                            )
                        }
                    }) {
                        Text("分享见面")
                    }
                }
            }
        }
    }
}