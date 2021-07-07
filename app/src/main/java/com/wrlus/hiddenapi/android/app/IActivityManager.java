package com.wrlus.hiddenapi.android.app;

import android.annotation.SuppressLint;
import android.os.IBinder;

import java.lang.reflect.Method;

public class IActivityManager {

    @SuppressLint("BlockedPrivateApi")
    public static Object getContentProviderExternal(Object am, String name, int userId,
                                                    IBinder token, String tag) {
        try {
            Method method = Class.forName("android.app.IActivityManager")
                    .getDeclaredMethod("getContentProviderExternal",
                            String.class, int.class, IBinder.class, String.class);
            return method.invoke(am, name, userId, token, tag);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressLint("BlockedPrivateApi")
    public static void removeContentProviderExternalAsUser(Object am, String name, IBinder token,
                                                           int userId) {
        try {
            Method method = Class.forName("android.app.IActivityManager")
                    .getDeclaredMethod("removeContentProviderExternalAsUser",
                            String.class, IBinder.class, int.class);
            method.invoke(am, name, token, userId);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
