package wechat.platform

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.tencent.mm.opensdk.constants.ConstantsAPI
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXTextObject
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory

private lateinit var api: IWXAPI

actual object OpenSDK {


    fun registerApp(context: Context, appID: String) {
        if (!::api.isInitialized) {
            // 通过WXAPIFactory工厂，获取IWXAPI的实例
            api = WXAPIFactory.createWXAPI(context, appID, false)
        }
        // 将应用的appId注册到微信
        api.registerApp(appID)

        //建议动态监听微信启动广播进行注册到微信
        context.registerReceiver(
            object : BroadcastReceiver() {
                override fun onReceive(p0: Context?, p1: Intent?) {
                    api.registerApp(appID)
                }
            },
            IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP)
        )

    }

    /**
     * 分享文本
     *
     * @param text
     */
    actual fun shareText(text: String, scene: WXScene) {

        val textObj = WXTextObject()
        textObj.text = text

        val msg = WXMediaMessage()
        msg.mediaObject = textObj
        msg.description = text

        val req = SendMessageToWX.Req()
        req.transaction = System.currentTimeMillis().toString()
        req.message = msg
        req.scene = scene.ordinal

        api.sendReq(req)
    }
}