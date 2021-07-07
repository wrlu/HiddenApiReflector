package com.wrlus.hiddenapi.dalvik.system;

import java.lang.reflect.Field;

/**
 * Base class for common functionality between various dex-based
 * {@link ClassLoader} implementations.
 */
public class BaseDexClassLoader {
    public static Object getPathList(ClassLoader classLoader) {
        try {
            Field field = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
            field.setAccessible(true);
            return field.get(classLoader);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
