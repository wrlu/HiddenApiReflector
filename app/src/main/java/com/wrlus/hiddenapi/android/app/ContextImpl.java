package com.wrlus.hiddenapi.android.app;

import android.content.Context;

import java.lang.reflect.Method;

public class ContextImpl {

    public static Context createSystemContext(Object mainThread) {
        try {
            Method method = Class.forName("android.app.ContextImpl")
                    .getDeclaredMethod("createSystemContext",
                            Class.forName("android.app.ActivityThread"));
            method.setAccessible(true);
            return (Context) method.invoke(null, mainThread);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Context createPackageContext(Object contextImpl,
                                               String packageName) {
        try {
            Method method = Class.forName("android.app.ContextImpl")
                    .getDeclaredMethod("createPackageContext",
                            String.class, int.class);
            method.setAccessible(true);
            return (Context) method.invoke(contextImpl, packageName, 0);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
