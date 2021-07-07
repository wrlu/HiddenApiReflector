package com.wrlus.hiddenapi.dalvik.system;

import android.annotation.SuppressLint;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * A pair of lists of entries, associated with a {@code ClassLoader}.
 * One of the lists is a dex/resource path &mdash; typically referred
 * to as a "class path" &mdash; list, and the other names directories
 * containing native code libraries. Class path entries may be any of:
 * a {@code .jar} or {@code .zip} file containing an optional
 * top-level {@code classes.dex} file as well as arbitrary resources,
 * or a plain {@code .dex} file (with no possibility of associated
 * resources).
 *
 * <p>This class also contains methods to use these lists to look up
 * classes and resources.</p>
 *
 * @hide
 */
public class DexPathList {

    /**
     * List of dex/resource (class path) elements.
     * Should be called pathElements, but the Facebook app uses reflection
     * to modify 'dexElements' (http://b/7726934).
     */
    public static Object[] getDexElements(Object dexPathList) {
        try {
            Field field = Class.forName("dalvik.system.DexPathList").getDeclaredField("dexElements");
            field.setAccessible(true);
            return (Object[]) field.get(dexPathList);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * List of dex/resource (class path) elements.
     * Should be called pathElements, but the Facebook app uses reflection
     * to modify 'dexElements' (http://b/7726934).
     */
    public static void setDexElements(Object dexPathList, Object dexElementsObj) {
        try {
            Field field = Class.forName("dalvik.system.DexPathList").getDeclaredField("dexElements");
            field.setAccessible(true);
            field.set(dexPathList, dexElementsObj);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SoonBlockedPrivateApi")
    public static Class<?> findClass(Object dexPathList, String name, List<Throwable> suppressed) {
        try {
            Method method = Class.forName("dalvik.system.DexPathList")
                    .getDeclaredMethod("findClass", String.class, List.class);
            return (Class<?>) method.invoke(dexPathList, name, suppressed);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
