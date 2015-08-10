package com.dynamicjar;

import android.content.Context;

import java.net.URL;
import java.net.URLClassLoader;


/**
 * Created by SCWANG on 2015-07-26.
 */
public class DynnamicJar {

    private static final String JAR_NAME = "2.4.3.txt";
    private static URLClassLoader mURLClassLoader;
    private static String mJarPath = "";

    public static boolean initize(String jarpath) {
        mJarPath = jarpath;
        return true;
    }

    public static URLClassLoader getURLClassLoader() {
        if (mURLClassLoader == null){
            try {
                return mURLClassLoader = new URLClassLoader(new URL[] { new URL(mJarPath) },
                        Thread.currentThread().getContextClassLoader());
            } catch (Throwable e) {

            }
        }
        return mURLClassLoader;
    }

    public static Class<?> loadClass(Context context,String classname) {
        URLClassLoader cl = getURLClassLoader();
        if (cl != null){
            try {
                return cl.loadClass(classname);
            } catch (Throwable e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Object newInstance(Context context,String classname) {
        URLClassLoader cl = getURLClassLoader();
        if (cl != null){
            try {
                final Class<?> aClass = cl.loadClass(classname);
                return aClass.newInstance();
            } catch (Throwable e){
            }
        }
        return null;
    }
}
