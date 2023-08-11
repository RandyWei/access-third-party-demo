package wechat.platform

import cocoapods.WechatOpenSDK.*

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

}