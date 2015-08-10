//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dynamicjar.tencent.advert;

import android.app.Activity;
import android.view.ViewGroup;
import com.qq.e.splash.AdViewFactory;
import com.qq.e.splash.SplashAd;
import com.qq.e.splash.SplashAdListener;
import com.qq.e.splash.SplashAdView;
import com.qq.e.v2.managers.GDTADManager;
import com.qq.e.v2.managers.plugin.a;
import com.qq.e.v2.util.GDTLogger;
import com.qq.e.v2.util.StringUtil;

public final class DjSplashAd {

    private static final int AD_PRESENT = 1;
    private static final int AD_DISMISSED = 2;
    private static final int AD_FAILED = 3;

    public int splashAd(Activity var1, ViewGroup var2, String var3, String var4) {
        final int[] result = {0};
        new SplashAd(var1, var2, var3, var4, new SplashAdListener(){

            @Override
            public void onAdPresent() {
                result[0] = AD_PRESENT;
            }

            @Override
            public void onAdDismissed() {
                result[0] = AD_DISMISSED;
            }

            @Override
            public void onAdFailed(int errCode) {
                result[0] = AD_FAILED;
            }
        });
        while (result[0] == 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result[0];
    }

}
