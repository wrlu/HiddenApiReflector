package com.wrlus.hiddenapi.android.app;

import java.lang.reflect.Method;

public class ActivityManager {
    /**
     * @hide
     */
    public static IActivityManager getService() {
        try {
            Method method = android.app.ActivityManager.class
                    .getDeclaredMethod("getService");
            return (IActivityManager) method.invoke(null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
