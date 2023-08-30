package wechat.platform

expect object OpenSDK {
    /**
     * 分享文本
     *
     * @param text
     */
    fun shareText(text: String,scene:WXScene)

    fun shareUrl(url:String,title:String,desc:String,thumb:ByteArray, scene: WXScene)
}