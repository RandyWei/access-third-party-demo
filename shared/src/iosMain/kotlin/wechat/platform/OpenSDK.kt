package wechat.platform

import cocoapods.WechatOpenSDK_XCFramework.*
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.memScoped
import platform.Foundation.NSData
import platform.Foundation.create

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
actual object OpenSDK {

    fun registerApp(appID: String, universalLink: String) {
//        WXApi.startLogByLevel(WXLogLevelDetail) {
//            println(it)
//        }

        WXApi.registerApp(appID, universalLink)
//        WXApi.checkUniversalLinkReady { step, result ->
//            println("step:$step result.success:${result?.success},errorInfo:${result?.errorInfo},suggestion:${result?.suggestion}")
//        }
    }


    /**
     * 分享文本
     *
     * @param text
     */
    actual fun shareText(text: String, scene: WXScene) {
        val req = SendMessageToWXReq()
        req.bText = true
        req.text = text
        req.scene = scene.ordinal
        WXApi.sendReq(req) {
            println("sendReq:$it")
        }
    }


    actual fun shareUrl(
        url: String,
        title: String,
        desc: String,
        thumb: ByteArray, scene: WXScene
    ) {
        val webObj = WXWebpageObject()
        webObj.webpageUrl = url
        val msg = WXMediaMessage()
        msg.mediaObject = webObj
        msg.title = title
        msg.setDescription(desc)
        msg.thumbData = memScoped {
            NSData.create(bytes = allocArrayOf(thumb), length = thumb.size.toULong())
        }

        val req = SendMessageToWXReq()
        req.message = msg
        req.scene = scene.ordinal

        WXApi.sendReq(req) {}
    }

}