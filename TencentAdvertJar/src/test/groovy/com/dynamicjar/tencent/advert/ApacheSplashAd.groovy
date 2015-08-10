package com.dynamicjar.tencent.advert

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.andadvert.model.AdCustom;
import com.andframe.application.AfExceptionHandler;
import com.andframe.util.java.AfReflecter
import com.dynamicjar.DynnamicJar
import com.qq.e.splash.SplashAdListener;

import java.lang.reflect.Method

/**
 * Created by SCWANG on 2015-07-26.
 */
public class ApacheSplashAd {

    public static final int AD_PRESENT = 1;
    public static final int AD_DISMISSED = 2;
    public static final int AD_FAILED = 3;

    Object connect;
    Context context;

    private ApacheSplashAd(Context instance) {
        connect = new Object();
        context = instance;
    }

    public static ApacheSplashAd getInstance(Context context) {
        DynnamicJar.initize();
        return new ApacheSplashAd(context);
    }

    public int splashAd(Activity var1, ViewGroup var2, String var3, String var4) {
        Class<?> clazz = DynnamicJar.loadClass(context, "com.dynamicjar.tencent.advert.DjSplashAd");
        Class<?>[] types = [Activity.class,ViewGroup.class,String.class,String.class];
        Method method = AfReflecter.getMethod(clazz, "splashAd", types);
        Object instance = AfReflecter.doStaticMethod(clazz, method, var1, var2, var3, var4);
        return (int)instance;
    }


}
