//
//  SceneDelegate.swift
//  iosApp
//
//  Created by RandyWei on 2023/8/11.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit


class SceneDelegate:UIResponder,UIWindowSceneDelegate,WXApiDelegate{
    var window: UIWindow?
    
    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        
        
        print("willConnectTo")
        
        guard let _ = (scene as? UIWindowScene) else {return}
    }
    
    func scene(_ scene: UIScene, continue userActivity: NSUserActivity) {
        WXApi.handleOpenUniversalLink(userActivity, delegate: self)
    }
    
    func sceneDidDisconnect(_ scene: UIScene) {
        // Called as the scene is being released by the system.
        
        print("sceneDidDisconnect")
    }
    
    func sceneDidBecomeActive(_ scene: UIScene) {
        // Called when the scene has moved from an inactive state to an active state.
        
        
        print("sceneDidBecomeActive")
    }
    
    func sceneWillResignActive(_ scene: UIScene) {
        
        print("sceneWillResignActive")
        
    }
    
    func onReq(_ req: BaseReq) {
        
    }
    
    func onResp(_ resp: BaseResp) {
        print(resp.type)
        print(resp.errCode)
    }
}
