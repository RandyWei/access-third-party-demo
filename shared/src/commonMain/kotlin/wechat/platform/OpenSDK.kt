package wechat.platform

expect object OpenSDK {
    /**
     * 分享文本
     *
     * @param text
     */
    fun shareText(text: String,scene:WXScene)
}