package com.wrlus.hiddenapi.android.content;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;

import java.lang.reflect.Method;

public class IContentProvider {

    public static Uri insert(Object provider, String callingPkg,
                             String attributionTag, Uri uri,
                             ContentValues initialValues, Bundle extras) {
        try {
            Method method = Class.forName("android.content.IContentProvider")
                    .getDeclaredMethod("insert",
                            String.class, String.class, Uri.class,
                            ContentValues.class, Bundle.class);
            return (Uri) method.invoke(provider, callingPkg, attributionTag,
                    uri, initialValues, extras);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int delete(Object provider, String callingPkg,
                             Uri uri, String selection, String[] selectionArgs) {
        try {
            Method method = Class.forName("android.content.IContentProvider")
                    .getDeclaredMethod("delete",
                            String.class, Uri.class, String.class, String[].class);
            return (int) method.invoke(provider, callingPkg, uri, selection, selectionArgs);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int update(Object provider, String callingPkg, Uri uri, ContentValues values,
                             String selection, String[] selectionArgs) {
        try {
            Method method = Class.forName("android.content.IContentProvider")
                    .getDeclaredMethod("update",
                            String.class, Uri.class, ContentValues.class,
                            String.class, String[].class);
            return (int) method.invoke(provider, callingPkg, uri, values,
                    selection, selectionArgs);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public static Cursor query(Object provider, String callingPkg,
                               String attributionTag, Uri uri, String[] projection,
                               Bundle queryArgs, Object cancellationSignal) {
        try {
            Method method = Class.forName("android.content.IContentProvider")
                    .getDeclaredMethod("query",
                            String.class, String.class, Uri.class, String[].class,
                            Bundle.class, Class.forName("android.os.ICancellationSignal"));
            return (Cursor) method.invoke(provider, callingPkg, attributionTag, uri, projection,
                    queryArgs, cancellationSignal);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
