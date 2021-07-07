package com.wrlus.hiddenapi.android.bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothServerSocket;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Represents the local device Bluetooth adapter. The {@link BluetoothAdapter}
 * lets you perform fundamental Bluetooth tasks, such as initiate
 * device discovery, query a list of bonded (paired) devices,
 * instantiate a {@link BluetoothDevice} using a known MAC address, and create
 * a {@link BluetoothServerSocket} to listen for connection requests from other
 * devices, and start a scan for Bluetooth LE devices.
 *
 * <p>To get a {@link BluetoothAdapter} representing the local Bluetooth
 * adapter, call the BluetoothManager#getAdapter function on BluetoothManager.
 * On JELLY_BEAN_MR1 and below you will need to use the static getDefaultAdapter
 * method instead.
 * </p><p>
 * Fundamentally, this is your starting point for all
 * Bluetooth actions. Once you have the local adapter, you can get a set of
 * {@link BluetoothDevice} objects representing all paired devices with
 * getBondedDevices(); start device discovery with
 * startDiscovery(); or create a {@link BluetoothServerSocket} to
 * listen for incoming RFComm connection requests with
 * listenUsingRfcommWithServiceRecord(String, UUID); listen for incoming L2CAP Connection-oriented
 * Channels (CoC) connection requests with listenUsingL2capChannel(); or start a scan for
 * Bluetooth LE devices with startLeScan(LeScanCallback callback).
 * </p>
 * <p>This class is thread safe.</p>
 * <p class="note"><strong>Note:</strong>
 * Most methods require the {@link Manifest.permission#BLUETOOTH}
 * permission and some also require the
 * {@link Manifest.permission#BLUETOOTH_ADMIN} permission.
 * </p>
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>
 * For more information about using Bluetooth, read the <a href=
 * "{@docRoot}guide/topics/connectivity/bluetooth.html">Bluetooth</a> developer
 * guide.
 * </p>
 * </div>
 *
 * {@see BluetoothDevice}
 * {@see BluetoothServerSocket}
 */
public class BluetoothAdapter {

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothAdapter.java
     * public boolean setScanMode(int mode);
     *
     * @hide
     */
    public static boolean setScanMode(android.bluetooth.BluetoothAdapter adapter, int mode) {
        try {
            Method method = android.bluetooth.BluetoothAdapter.class.getMethod("setScanMode", int.class);
            return (boolean) method.invoke(adapter, mode);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothAdapter.java
     * public void setDiscoverableTimeout(int timeout);
     *
     * @hide
     */
    public static void setDiscoverableTimeout(android.bluetooth.BluetoothAdapter adapter, int timeout) {
        try {
            Method method = android.bluetooth.BluetoothAdapter.class.getMethod("setDiscoverableTimeout", int.class);
            method.invoke(adapter, timeout);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothAdapter.java
     * public BluetoothServerSocket listenUsingInsecureL2capOn(int port) throws IOException;
     *
     * Construct an insecure L2CAP server socket.
     * Call #accept to retrieve connections to this socket.
     * <p>To auto assign a port without creating a SDP record use
     * SOCKET_CHANNEL_AUTO_STATIC_NO_SDP as port number.
     *
     * @param port the PSM to listen on
     * @return An L2CAP BluetoothServerSocket
     * @throws IOException On error, for example Bluetooth not available, or insufficient
     * permissions.
     * @hide
     */
    public static BluetoothServerSocket listenUsingInsecureL2capOn(android.bluetooth.BluetoothAdapter adapter, int port) throws IOException {
        try {
            Method method = android.bluetooth.BluetoothAdapter.class.getMethod("listenUsingInsecureL2capOn", int.class);
            return (BluetoothServerSocket) method.invoke(adapter, port);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothAdapter.java
     * public BluetoothServerSocket listenUsingL2capOn(int port) throws IOException;
     *
     * Construct an encrypted, authenticated, L2CAP server socket.
     * Call #accept to retrieve connections to this socket.
     * <p>To auto assign a port without creating a SDP record use
     * SOCKET_CHANNEL_AUTO_STATIC_NO_SDP as port number.
     *
     * @param port the PSM to listen on
     * @return An L2CAP BluetoothServerSocket
     * @throws IOException On error, for example Bluetooth not available, or insufficient
     * permissions.
     * @hide
     */
    public static BluetoothServerSocket listenUsingL2capOn(android.bluetooth.BluetoothAdapter adapter, int port) throws IOException {
        try {
            Method method = android.bluetooth.BluetoothAdapter.class.getMethod("listenUsingL2capOn", int.class);
            return (BluetoothServerSocket) method.invoke(adapter, port);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothAdapter.java
     * public BluetoothServerSocket listenUsingInsecureRfcommOn(int port) throws IOException;
     *
     * Construct an unencrypted, unauthenticated, RFCOMM server socket.
     * Call #accept to retrieve connections to this socket.
     *
     * @return An RFCOMM BluetoothServerSocket
     * @throws IOException On error, for example Bluetooth not available, or insufficient
     * permissions.
     * @hide
     */
    public static BluetoothServerSocket listenUsingInsecureRfcommOn(android.bluetooth.BluetoothAdapter adapter, int port) throws IOException {
        try {
            Method method = android.bluetooth.BluetoothAdapter.class.getMethod("listenUsingInsecureRfcommOn", int.class);
            return (BluetoothServerSocket) method.invoke(adapter, port);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothAdapter.java
     * public BluetoothServerSocket listenUsingRfcommOn(int channel) throws IOException;
     *
     * Create a listening, secure RFCOMM Bluetooth socket.
     * <p>A remote device connecting to this socket will be authenticated and
     * communication on this socket will be encrypted.
     * <p>Use {@link BluetoothServerSocket#accept} to retrieve incoming
     * connections from a listening {@link BluetoothServerSocket}.
     * <p>Valid RFCOMM channels are in range 1 to 30.
     * <p>Requires {@link Manifest.permission#BLUETOOTH_ADMIN}
     *
     * @param channel RFCOMM channel to listen on
     * @return a listening RFCOMM BluetoothServerSocket
     * @throws IOException on error, for example Bluetooth not available, or insufficient
     * permissions, or channel in use.
     * @hide
     */
    public static BluetoothServerSocket listenUsingRfcommOn(android.bluetooth.BluetoothAdapter adapter, int channel) throws IOException {
        try {
            Method method = android.bluetooth.BluetoothAdapter.class.getMethod("listenUsingRfcommOn", int.class);
            return (BluetoothServerSocket) method.invoke(adapter, channel);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}