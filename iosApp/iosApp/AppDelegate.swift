//
//  AppDelegate.swift
//  iosApp
//
//  Created by RandyWei on 2023/8/11.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit
import shared
@main
class AppDelegate:UIResponder,UIApplicationDelegate, WXApiDelegate{
    
    var window: UIWindow?
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        
        window = UIWindow()
        window?.rootViewController = Main_iosKt.MainViewController()
        window?.makeKeyAndVisible()
        
        return true
    }
    
    
    
    func application(_ application: UIApplication, continue userActivity: NSUserActivity, restorationHandler: @escaping ([UIUserActivityRestoring]?) -> Void) -> Bool {
        return WXApi.handleOpenUniversalLink(userActivity, delegate: self)
    }
    
    
    func onReq(_ req: BaseReq) {
        
    }
    
    func onResp(_ resp: BaseResp) {
        print(resp.type)
        print(resp.errCode)
    }
    
}
