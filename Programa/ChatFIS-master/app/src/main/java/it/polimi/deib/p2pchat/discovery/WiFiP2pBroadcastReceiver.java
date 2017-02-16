
package it.polimi.deib.p2pchat.discovery;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.util.Log;

import it.polimi.deib.p2pchat.discovery.model.LocalP2PDevice;

public class WiFiP2pBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "P2pBroadcastReceiver";

    private final WifiP2pManager manager;
    private final Channel channel;
    private final Activity activity;

    public WiFiP2pBroadcastReceiver(WifiP2pManager manager, Channel channel, Activity activity) {
        super();
        this.manager = manager;
        this.channel = channel;
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        Log.d(TAG, action);

        if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {

            if (manager == null) {
                return;
            }

            NetworkInfo networkInfo = intent.getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);

            if (networkInfo.isConnected()) {
     
                Log.d(TAG,"Connected to p2p network. Requesting network details");

                manager.requestConnectionInfo(channel,(ConnectionInfoListener) activity);

                ((MainActivity)activity).setConnected(true);

                ((MainActivity)activity).addColorActiveTabs(false);

                ((MainActivity)activity).setTabFragmentToPage(((MainActivity)activity).getTabNum());

            } else {

                Log.d(TAG, "Desconectado. Reinicio de la búsqueda");

                ((MainActivity)activity).addColorActiveTabs(true);

                if(!((MainActivity)activity).isBlockForcedDiscoveryInBroadcastReceiver()) {

                    ((MainActivity) activity).forceDiscoveryStop();
                    ((MainActivity) activity).restartDiscovery();
                }

                ((MainActivity)activity).setDisableAllChatManagers();

                ((MainActivity)activity).setTabFragmentToPage(0);

                ((MainActivity)activity).setConnected(false);

                TabFragment.getWiFiP2pServicesFragment().hideLocalDeviceGoIcon();

                TabFragment.getWiFiP2pServicesFragment().resetLocalDeviceIpAddress();
            }

        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {

            WifiP2pDevice device = intent.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE);
            LocalP2PDevice.getInstance().setLocalDevice(device);
            Log.d(TAG, "Estado del dispositivo local -" + device.status);

        }
    }
}
