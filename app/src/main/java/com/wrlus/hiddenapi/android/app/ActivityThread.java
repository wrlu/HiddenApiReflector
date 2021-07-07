package com.wrlus.hiddenapi.android.app;

import java.lang.reflect.Method;

/**
 * This manages the execution of the main thread in an
 * application process, scheduling and executing activities,
 * broadcasts, and other operations on it as the activity
 * manager requests.
 *
 * {@hide}
 */
public class ActivityThread {
    public static Object systemMain() {
        try {
            Method method = Class.forName("android.app.ActivityThread")
                    .getDeclaredMethod("systemMain");
            return method.invoke(null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object currentActivityThread() {
        try {
            Method method = Class.forName("android.app.ActivityThread")
                    .getDeclaredMethod("currentActivityThread");
            return method.invoke(null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
