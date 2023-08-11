import androidx.compose.ui.window.ComposeUIViewController
import wechat.platform.OpenSDK

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController {
    OpenSDK.registerApp("wxdab815a00288fddd","https://applinks.shituzaixian.com/app/")
    App()
}