package com.wrlus.hiddenapi.dalvik.system;

import java.lang.reflect.Constructor;

/**
 * A class loader that loads classes from {@code .jar} and {@code .apk} files
 * containing a {@code classes.dex} entry. This can be used to execute code not
 * installed as part of an application.
 *
 * <p>Prior to API level 26, this class loader requires an
 * application-private, writable directory to cache optimized classes.
 * Use {@code Context.getCodeCacheDir()} to create such a directory:
 * <pre>   {@code
 *   File dexOutputDir = context.getCodeCacheDir();
 * }</pre>
 *
 * <p><strong>Do not cache optimized classes on external storage.</strong>
 * External storage does not provide access controls necessary to protect your
 * application from code injection attacks.
 */
public class DexClassLoader {

    /**
     * Creates a {@code DexClassLoader} that finds interpreted and native
     * code.  Interpreted classes are found in a set of DEX files contained
     * in Jar or APK files.
     *
     * <p>The path lists are separated using the character specified by the
     * {@code path.separator} system property, which defaults to {@code :}.
     *
     * @param dexPath the list of jar/apk files containing classes and
     *     resources, delimited by {@code File.pathSeparator}, which
     *     defaults to {@code ":"} on Android
     * @param optimizedDirectory this parameter is deprecated and has no effect since API level 26.
     * @param librarySearchPath the list of directories containing native
     *     libraries, delimited by {@code File.pathSeparator}; may be
     *     {@code null}
     * @param parent the parent class loader
     */
    public static Object newInstance(String dexPath, String optimizedDirectory, String librarySearchPath, ClassLoader parent) {
        try {
            Constructor constructor = Class.forName("dalvik.system.DexClassLoader")
                    .getDeclaredConstructor(String.class, String.class, String.class, ClassLoader.class);
            return constructor.newInstance(dexPath, optimizedDirectory, librarySearchPath, parent);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
