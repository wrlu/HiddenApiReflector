package com.wrlus.hiddenapi.android.bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Represents a remote Bluetooth device. A {@link BluetoothDevice} lets you
 * create a connection with the respective device or query information about
 * it, such as the name, address, class, and bonding state.
 *
 * <p>This class is really just a thin wrapper for a Bluetooth hardware
 * address. Objects of this class are immutable. Operations on this class
 * are performed on the remote Bluetooth hardware address, using the
 * {@link BluetoothAdapter} that was used to create this {@link
 * BluetoothDevice}.
 *
 * <p>To get a {@link BluetoothDevice}, use
 * BluetoothAdapter#getRemoteDevice(String)
 * BluetoothAdapter.getRemoteDevice(String) to create one representing a device
 * of a known MAC address (which you can get through device discovery with
 * {@link BluetoothAdapter}) or get one from the set of bonded devices
 * returned by BluetoothAdapter#getBondedDevices()
 * BluetoothAdapter.getBondedDevices(). You can then open a
 * {@link BluetoothSocket} for communication with the remote device, using
 * createRfcommSocketToServiceRecord(UUID) over Bluetooth BR/EDR or using
 * createL2capChannel(int) over Bluetooth LE.
 *
 * <p class="note"><strong>Note:</strong>
 * Requires the {@link Manifest.permission#BLUETOOTH} permission.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>
 * For more information about using Bluetooth, read the <a href=
 * "{@docRoot}guide/topics/connectivity/bluetooth.html">Bluetooth</a> developer
 * guide.
 * </p>
 * </div>
 *
 * {@see BluetoothAdapter}
 * {@see BluetoothSocket}
 */
public class BluetoothDevice {

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothDevice.java
     * public BluetoothSocket createInsecureL2capSocket(int channel) throws IOException;
     *
     * Create an L2cap {@link BluetoothSocket} ready to start an insecure
     * outgoing connection to this remote device on given channel.
     * <p>The remote device will be not authenticated and communication on this
     * socket will not be encrypted.
     * <p>Use {@link BluetoothSocket#connect} to initiate the outgoing
     * connection.
     * <p>Valid L2CAP PSM channels are in range 1 to 2^16.
     * <p>Requires {@link Manifest.permission#BLUETOOTH}
     *
     * @param channel L2cap PSM/channel to connect to
     * @return a RFCOMM BluetoothServerSocket ready for an outgoing connection
     * @throws IOException on error, for example Bluetooth not available, or insufficient
     * permissions
     * @hide
     */
    public static BluetoothSocket createInsecureL2capSocket(android.bluetooth.BluetoothDevice device, int channel) throws IOException {
        try {
            Method method = android.bluetooth.BluetoothDevice.class.getMethod("createInsecureL2capSocket", int.class);
            return (BluetoothSocket) method.invoke(device, channel);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothDevice.java
     * public BluetoothSocket createL2capSocket(int channel) throws IOException;
     *
     * Create an L2cap {@link BluetoothSocket} ready to start a secure
     * outgoing connection to this remote device on given channel.
     * <p>The remote device will be authenticated and communication on this
     * socket will be encrypted.
     * <p> Use this socket only if an authenticated socket link is possible.
     * Authentication refers to the authentication of the link key to
     * prevent man-in-the-middle type of attacks.
     * For example, for Bluetooth 2.1 devices, if any of the devices does not
     * have an input and output capability or just has the ability to
     * display a numeric key, a secure socket connection is not possible.
     * In such a case, use createInsecureRfcommSocket.
     * For more details, refer to the Security Model section 5.2 (vol 3) of
     * Bluetooth Core Specification version 2.1 + EDR.
     * <p>Use {@link BluetoothSocket#connect} to initiate the outgoing
     * connection.
     * <p>Valid L2CAP PSM channels are in range 1 to 2^16.
     * <p>Requires {@link Manifest.permission#BLUETOOTH}
     *
     * @param channel L2cap PSM/channel to connect to
     * @return a RFCOMM BluetoothServerSocket ready for an outgoing connection
     * @throws IOException on error, for example Bluetooth not available, or insufficient
     * permissions
     * @hide
     */
    public static BluetoothSocket createL2capSocket(android.bluetooth.BluetoothDevice device, int channel) throws IOException {
        try {
            Method method = android.bluetooth.BluetoothDevice.class.getMethod("createL2capSocket", int.class);
            return (BluetoothSocket) method.invoke(device, channel);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothDevice.java
     * public BluetoothSocket createInsecureRfcommSocket(int port) throws IOException;
     *
     * Construct an insecure RFCOMM socket ready to start an outgoing
     * connection.
     * Call #connect on the returned #BluetoothSocket to begin the connection.
     * The remote device will not be authenticated and communication on this
     * socket will not be encrypted.
     * <p>Requires {@link Manifest.permission#BLUETOOTH_ADMIN}
     *
     * @param port remote port
     * @return An RFCOMM BluetoothSocket
     * @throws IOException On error, for example Bluetooth not available, or insufficient
     * permissions.
     * @hide
     */
    public static BluetoothSocket createInsecureRfcommSocket(android.bluetooth.BluetoothDevice device, int port) throws IOException {
        try {
            Method method = android.bluetooth.BluetoothDevice.class.getMethod("createInsecureRfcommSocket", int.class);
            return (BluetoothSocket) method.invoke(device, port);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * frameworks/base/core/java/android/bluetooth/BluetoothDevice.java
     * public BluetoothSocket createRfcommSocket(int channel) throws IOException;
     *
     * Create an RFCOMM {@link BluetoothSocket} ready to start a secure
     * outgoing connection to this remote device on given channel.
     * <p>The remote device will be authenticated and communication on this
     * socket will be encrypted.
     * <p> Use this socket only if an authenticated socket link is possible.
     * Authentication refers to the authentication of the link key to
     * prevent man-in-the-middle type of attacks.
     * For example, for Bluetooth 2.1 devices, if any of the devices does not
     * have an input and output capability or just has the ability to
     * display a numeric key, a secure socket connection is not possible.
     * In such a case, use createInsecureRfcommSocket.
     * For more details, refer to the Security Model section 5.2 (vol 3) of
     * Bluetooth Core Specification version 2.1 + EDR.
     * <p>Use {@link BluetoothSocket#connect} to initiate the outgoing
     * connection.
     * <p>Valid RFCOMM channels are in range 1 to 30.
     * <p>Requires {@link Manifest.permission#BLUETOOTH}
     *
     * @param channel RFCOMM channel to connect to
     * @return a RFCOMM BluetoothServerSocket ready for an outgoing connection
     * @throws IOException on error, for example Bluetooth not available, or insufficient
     * permissions
     * @hide
     */
    public static BluetoothSocket createRfcommSocket(android.bluetooth.BluetoothDevice device, int channel) throws IOException {
        try {
            Method method = android.bluetooth.BluetoothDevice.class.getMethod("createRfcommSocket", int.class);
            return (BluetoothSocket) method.invoke(device, channel);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

}