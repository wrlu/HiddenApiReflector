package com.wrlus.hiddenapi.android.content.pm;

import android.annotation.SuppressLint;

import java.lang.reflect.Method;

/**
 * Information you can retrieve about a particular application.  This
 * corresponds to information collected from the AndroidManifest.xml's
 * &lt;application&gt; tag.
 */
public class ApplicationInfo {

    /** @hide */
    public static boolean isPrivilegedApp(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            Method method = android.content.pm.ApplicationInfo.class
                    .getDeclaredMethod("isPrivilegedApp");
            return (boolean) method.invoke(applicationInfo);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return false;
    }

    /** @hide */
    @SuppressLint("SoonBlockedPrivateApi")
    public boolean isSignedWithPlatformKey(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            Method method = android.content.pm.ApplicationInfo.class
                    .getDeclaredMethod("isSignedWithPlatformKey");
            return (boolean) method.invoke(applicationInfo);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return false;
    }

    /** @hide */
    public boolean isSystemApp(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            Method method = android.content.pm.ApplicationInfo.class
                    .getDeclaredMethod("isSystemApp");
            return (boolean) method.invoke(applicationInfo);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return false;
    }

    /** @hide */
    @SuppressLint("SoonBlockedPrivateApi")
    public boolean isUpdatedSystemApp(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            Method method = android.content.pm.ApplicationInfo.class
                    .getDeclaredMethod("isUpdatedSystemApp");
            return (boolean) method.invoke(applicationInfo);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return false;
    }
}
