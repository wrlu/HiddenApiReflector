package com.wrlus.hiddenapi.android.os;

import android.os.IBinder;

import java.lang.reflect.Method;

public class ServiceManager {

    /**
     * frameworks/base/core/java/android/os/ServiceManager.java
     * public static IBinder getService(String name);
     *
     * Returns a reference to a service with the given name.
     *
     * @param name the name of the service to get
     * @return a reference to the service, or <code>null</code> if the service doesn't exist
     */
    public static IBinder getService(String name) {
        try {
            Method method = Class.forName("android.os.ServiceManager")
                    .getDeclaredMethod("getService", String.class);
            return (IBinder) method.invoke(null, name);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Return a list of all currently running services.
     * @return an array of all currently running services, or <code>null</code> in
     * case of an exception
     */
    public static String[] listServices() {
        try {
            Method method = Class.forName("android.os.ServiceManager")
                    .getDeclaredMethod("listServices");
            return (String[]) method.invoke(null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}