package com.wrlus.hiddenapi.dalvik.system;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Loads DEX files. This class is meant for internal use and should not be used
 * by applications.
 *
 * This class should not be used directly by applications. It will hurt
 *     performance in most cases and will lead to incorrect execution of bytecode in
 *     the worst case. Applications should use one of the standard classloaders such
 *     as {@link dalvik.system.PathClassLoader} instead. <b>This API will be removed
 *     in a future Android release</b>.
 */
public class DexFile {

    /**
     * Opens a DEX file from a given filename.
     *
     * Applications should use one of the standard classloaders such
     *     as {@link dalvik.system.PathClassLoader} instead. <b>This API will be removed
     *     in a future Android release</b>.
     */
    public static Object newInstance(File file) {
        try {
            Constructor constructor = Class.forName("dalvik.system.DexFile")
                    .getDeclaredConstructor(File.class);
            return constructor.newInstance(file);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads a class. Returns the class on success, or a {@code null} reference
     * on failure.
     * <p>
     * If you are not calling this from a class loader, this is most likely not
     * going to do what you want. Use {@link Class#forName(String)} instead.
     * <p>
     * The method does not throw {@link ClassNotFoundException} if the class
     * isn't found because it isn't reasonable to throw exceptions wildly every
     * time a class is not found in the first DEX file we look at.
     *
     * @param name
     *            the class name, which should look like "java/lang/String"
     *
     * @param loader
     *            the class loader that tries to load the class (in most cases
     *            the caller of the method
     *
     * @return the {@link Class} object representing the class, or {@code null}
     *         if the class cannot be loaded
     */
    public static Class<?> loadClass(Object dexFile, String name, ClassLoader loader) {
        try {
            Method method = Class.forName("dalvik.system.DexFile")
                    .getDeclaredMethod("loadClass", String.class, ClassLoader.class);
            return (Class<?>) method.invoke(dexFile, name, loader);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
