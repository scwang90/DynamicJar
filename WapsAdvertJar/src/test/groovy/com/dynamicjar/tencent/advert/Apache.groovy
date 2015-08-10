package com.dynamicjar.tencent.advert;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.LinearLayout;

import com.andadvert.model.AdCustom;
import com.andframe.application.AfExceptionHandler;
import com.andframe.util.java.AfReflecter
import com.dynamicjar.DynnamicJar;

import java.lang.reflect.Method

/**
 * Created by SCWANG on 2015-07-26.
 */
public class Apache {

    Object connect;

    private Apache(Object instance) {
        if (instance == null){
            connect = new Object();
            AfExceptionHandler.handler(new RuntimeException("connect=null"),"Apache.init");
        } else {
            connect = instance;
        }
    }

    public static Apache getInstance(Context context) {
        Class<?> clazz = DynnamicJar.loadClass(context, "org.apache.AppConnect");
        Class<?>[] types = [Context.class];
        Method method = AfReflecter.getMethod(clazz, "getInstance", types);
        Object instance = AfReflecter.doStaticMethod(clazz, method, context);
        return new Apache(instance);
    }

    public static Apache getInstance(String s, Context context) {
        Class<?> clazz = DynnamicJar.loadClass(context, "org.apache.AppConnect");
        Class<?>[] types = [String.class,Context.class];
        Method method = AfReflecter.getMethod(clazz, "getInstance", types);
        Object instance = AfReflecter.doStaticMethod(clazz, method, s, context);
        return new Apache(instance);
    }

    public static Apache getInstance(String s, String s1, Context context) {
        Class<?> clazz = DynnamicJar.loadClass(context, "org.apache.AppConnect");
        Class<?>[] types = [String.class,String.class,Context.class];
        Method method = AfReflecter.getMethod(clazz, "getInstance", types);
        Object instance = AfReflecter.doStaticMethod(clazz, method, s, s1, context);
        return new Apache(instance);
    }

    public void awardPoints(int i) {
//        connect.awardPoints(i);
        AfReflecter.doMethod(connect, "awardPoints", i);
    }

    public void showBannerAd(Context context, LinearLayout linearLayout) {
//        connect.showBannerAd(context, linearLayout);
        AfReflecter.doMethod(connect, "showBannerAd", context, linearLayout);
    }

    public void showOffers(Context context) {
//        connect.showOffers(context);
        AfReflecter.doMethod(connect, "showOffers", context);
    }

    public void showAppOffers(Context context, String s) {
//        connect.showAppOffers(context, s);
        AfReflecter.doMethod(connect, "showAppOffers", context, s);
    }

    public void showShareOffers(Context context) {
//        connect.showShareOffers(context);
        AfReflecter.doMethod(connect, "showShareOffers", context);
    }

    public String getSignatureMd5(Context context) {
//        return connect.getSignatureMd5(context);
        return AfReflecter.doMethod(connect, "getSignatureMd5", String.class, context);
    }

    public Dialog getOffersDialog() {
//        return connect.getOffersDialog();
        return AfReflecter.doMethod(connect, "getOffersDialog", Dialog.class);
    }

    public void showMiniAd(Context context, LinearLayout linearLayout, int i) {
//        connect.showMiniAd(context, linearLayout, i);
        AfReflecter.doMethod(connect, "showMiniAd", context, linearLayout, i);
    }

//    public void spendPoints(int i, UpdatePointsNotifier updatePointsNotifier) {
//        connect.spendPoints(i, updatePointsNotifier);
//        AfReflecter.doMethod(connect,"spendPoints",updatePointsNotifier);
//    }

    public void setWebViewTransparent(boolean b) {
//        connect.setWebViewTransparent(b);
        AfReflecter.doMethod(connect, "setWebViewTransparent", b);
    }

    public void cleanCache() {
//        connect.cleanCache();
        AfReflecter.doMethod(connect, "cleanCache");
    }

    public void setUpdatePointsFlag(boolean b) {
//        connect.setUpdatePointsFlag(b);
        AfReflecter.doMethod(connect, "setUpdatePointsFlag", b);
    }

    public void showMore(Context context) {
//        connect.showMore(context);
        AfReflecter.doMethod(connect, "showMore", context);
    }

    public void showOffers(Context context, String s) {
//        connect.showOffers(context, s);
        AfReflecter.doMethod(connect, "showOffers", context, s);
    }

    public void showMore(Context context, String s) {
//        connect.showMore(context, s);
        AfReflecter.doMethod(connect, "showMore", context, s);
    }

    public boolean hasPopAd(Context context) {
//        return connect.hasPopAd(context);
        return AfReflecter.doMethod(connect, "hasPopAd", Boolean.class, context);
    }

    public void showDialogAd() {
//        connect.showDialogAd();
        AfReflecter.doMethod(connect, "showDialogAd");
    }

//    public void setActPointsListener(AppListener appListener) {
////        connect.setActPointsListener(appListener);
//        AfReflecter.doMethod(connect,"setActPointsListener",appListener);
//    }

    public void showPopAd(Context context, int i) {
//        connect.showPopAd(context, i);
        AfReflecter.doMethod(connect, "showPopAd", context, i);
    }

    public void showFeedback(Context context) {
//        connect.showFeedback(context);
        AfReflecter.doMethod(connect, "showFeedback" ,context);
    }

    public void clearPoints() {
//        connect.clearPoints();
        AfReflecter.doMethod(connect, "clearPoints");
    }

    public void showTuanOffers(Context context) {
//        connect.showTuanOffers(context);
        AfReflecter.doMethod(connect, "showTuanOffers", context);
    }

    public void showGameOffers(Context context) {
//        connect.showGameOffers(context);
        AfReflecter.doMethod(connect, "showGameOffers", context);
    }

    public AdCustom getAdInfo() {
//        return connect.getAdInfo();
        Object info = AfReflecter.doMethod(connect, "getAdInfo");
        if (info == null){
            return null;
        }
        return doAdInfoToAdCustom(info);
    }

    public void setCrashReport(boolean b) {
//        connect.setCrashReport(b);
        AfReflecter.doMethod(connect, "setCrashReport", b);
    }

    public void setWeixinAppId(String s, Context context) {
//        connect.setWeixinAppId(s, context);
        AfReflecter.doMethod(connect, "setWeixinAppId", s, context);
    }

//    public void getConfig(String s, String s1, AppListener appListener) {
////        connect.getConfig(s, s1, appListener);
//        AfReflecter.doMethod(connect,"getConfig",s,s1,appListener);
//    }

    public void getPoints() {
//        connect.getPoints();
        AfReflecter.doMethod(connect, "getPoints");
    }

    public void initPopAd(Context context) {
//        connect.initPopAd(context);
        AfReflecter.doMethod(connect, "initPopAd", context);
    }

    public void initAdInfo() {
//        connect.initAdInfo();
        AfReflecter.doMethod(connect, "initAdInfo");
    }

//    public void awardPoints(int i, UpdatePointsNotifier updatePointsNotifier) {
////        connect.awardPoints(i, updatePointsNotifier);
//        AfReflecter.doMethod(connect,"awardPoints",i,updatePointsNotifier);
//    }

    public void releaseUninstallAd(Context context) {
//        connect.releaseUninstallAd(context);
        AfReflecter.doMethod(connect, "releaseUninstallAd", context);
    }

    public void spendPoints(int i) {
//        connect.spendPoints(i);
        AfReflecter.doMethod(connect, "spendPoints", i);
    }

    public void checkUpdate(Context context) {
//        connect.checkUpdate(context);
        AfReflecter.doMethod(connect, "checkUpdate", context);
    }

    public List getAdInfoList() {
//        return connect.getAdInfoList();
        List<AdCustom> customs = new ArrayList<AdCustom>();
        List<Object> list = AfReflecter.doMethod(connect, "getAdInfoList", List.class);
        if (list != null){
            for (Object info : list) {
                customs.add(doAdInfoToAdCustom(info));
            }
        }
        return customs;
    }

    public Map getConfigMap() {
//        return connect.getConfigMap();
        return AfReflecter.doMethod(connect, "getConfigMap", Map.class);
    }

    public void setPointsCache(boolean b) {
//        connect.setPointsCache(b);
        AfReflecter.doMethod(connect, "setPointsCache", b);
    }

    public void showBrowser(Context context, String s) {
//        connect.showBrowser(context, s);
        AfReflecter.doMethod(connect, "showBrowser", context, s);
    }

    public void showFunAd(Context context, String s, String s1) {
//        connect.showFunAd(context, s, s1);
        AfReflecter.doMethod(connect, "showFunAd", context, s, s1);
    }

    public void showPlayer(Context context, String s) {
//        connect.showPlayer(context, s);
        AfReflecter.doMethod(connect, "showPlayer", context, s);
    }

    public void setAdBackColor(int i) {
//        connect.setAdBackColor(i);
        AfReflecter.doMethod(connect, "setAdBackColor", i);
    }

    public void setRunnableMap(HashMap hashMap) {
//        connect.setRunnableMap(hashMap);
        AfReflecter.doMethod(connect, "setRunnableMap", hashMap);
    }

    public Dialog getPopAdDialog() {
//        return connect.getPopAdDialog();
        return AfReflecter.doMethod(connect, "getPopAdDialog", Dialog.class);
    }

    public String getParamsUn(Context context, String s) {
//        return connect.getParamsUn(context, s);
        return AfReflecter.doMethod(connect, "getParamsUn", String.class, context, s);
    }

    public String getConfig(String s) {
//        return connect.getConfig(s);
        return AfReflecter.doMethod(connect, "getConfig", String.class, s);
    }

    public void showAppOffers(Context context) {
//        connect.showAppOffers(context);
        AfReflecter.doMethod(connect, "showAppOffers", context);
    }

    public void setPopAdBack(boolean b) {
//        connect.setPopAdBack(b);
        AfReflecter.doMethod(connect, "setPopAdBack", b);
    }

    public void clickAd(Context context, String s) {
//        connect.clickAd(context, s);
        AfReflecter.doMethod(connect, "clickAd", context, s);
    }

    public void showPlayer(Context context, String s, boolean b) {
//        connect.showPlayer(context, s, b);
        AfReflecter.doMethod(connect, "showPlayer", context, s, b);
    }

    public void showGameOffers(Context context, String s) {
//        connect.showGameOffers(context, s);
        AfReflecter.doMethod(connect, "showGameOffers", context, s);
    }

    public LinearLayout getPopAdView(Context context, int i, int i1) {
//        return connect.getPopAdView(context, i, i1);
        return AfReflecter.doMethod(connect, "getPopAdView", LinearLayout.class, context, i, i1);
    }

    public void close() {
//        connect.close();
        AfReflecter.doMethod(connect, "close");
    }

    public void showFeedback() {
//        connect.showFeedback();
        AfReflecter.doMethod(connect, "showFeedback");
    }

    public void showBrowser(Context context, String s, boolean b) {
//        connect.showBrowser(context, s, b);
        AfReflecter.doMethod(connect, "showBrowser", context, s, b);
    }

    public String getConfig(String s, String s1) {
//        return connect.getConfig(s, s1);
        return AfReflecter.doMethod(connect, "getConfig", String.class, s, s1);
    }

//    public void getPoints(UpdatePointsNotifier updatePointsNotifier) {
//        connect.getPoints(updatePointsNotifier);
//        AfReflecter.doMethod(connect,"getPoints",updatePointsNotifier);
//    }

    public void initFunAd(Context context) {
//        connect.initFunAd(context);
        AfReflecter.doMethod(connect, "initFunAd", context);
    }

    public String getPointsFailedData() {
//        return connect.getPointsFailedData();
        return AfReflecter.doMethod(connect, "getPointsFailedData", String.class);
    }

    public void setAdForeColor(int i) {
//        connect.setAdForeColor(i);
        AfReflecter.doMethod(connect, "setAdForeColor", i);
    }

    public void showShareOffers(Context context, String s) {
//        connect.showShareOffers(context, s);
        AfReflecter.doMethod(connect, "showShareOffers", context, s);
    }

    public void downloadAd(Context context, String s) {
//        connect.downloadAd(context, s);
        AfReflecter.doMethod(connect, "downloadAd", context, s);
    }

    public void initUninstallAd(Context context) {
//        connect.initUninstallAd(context);
        AfReflecter.doMethod(connect, "initUninstallAd", context);
    }

    public void showPopAd(Context context) {
//        connect.showPopAd(context);
        AfReflecter.doMethod(connect, "showPopAd", context);
    }

    public void showTuanOffers(Context context, String s) {
//        connect.showTuanOffers(context, s);
        AfReflecter.doMethod(connect, "showTuanOffers", context, s);
    }

    public LinearLayout getPopAdView(Context context) {
//        return connect.getPopAdView(context);
        return AfReflecter.doMethod(connect, "getPopAdView", LinearLayout.class, context);
    }

    private AdCustom doAdInfoToAdCustom(Object info) {
        AdCustom custom = new AdCustom();
        custom.Action = AfReflecter.doMethod(info, "getAction", String.class);
        custom.Icon = AfReflecter.doMethod(info, "getAdIcon", Bitmap.class);
        custom.Id = AfReflecter.doMethod(info, "getAdId", String.class);
        custom.Name = AfReflecter.doMethod(info, "getAdName", String.class);
        custom.Package = AfReflecter.doMethod(info, "getAdPackage", String.class);
        custom.Points = AfReflecter.doMethod(info, "getAdPoints", Integer.class);
        custom.Text = AfReflecter.doMethod(info, "getAdText", String.class);
        custom.Description = AfReflecter.doMethod(info, "getDescription", String.class);
        custom.ImageUrls = AfReflecter.doMethod(info, "getImageUrls", String[].class);
        custom.Filesize = AfReflecter.doMethod(info, "getFilesize", String.class) + "MB";
        custom.Provider = AfReflecter.doMethod(info, "getProvider", String.class);
        custom.Version = AfReflecter.doMethod(info, "getVersion", String.class);
        return  custom;
    }
}
