package wechat.platform

import cocoapods.WechatOpenSDK.*

actual object OpenSDK {
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