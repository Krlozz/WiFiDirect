package it.polimi.deib.p2pchat.discovery.actionlisteners;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import it.polimi.deib.p2pchat.discovery.Configuration;
import it.polimi.deib.p2pchat.discovery.TabFragment;
import it.polimi.deib.p2pchat.discovery.services.ServiceList;
import it.polimi.deib.p2pchat.discovery.services.WiFiP2pService;
import it.polimi.deib.p2pchat.discovery.services.WiFiP2pServicesFragment;
import it.polimi.deib.p2pchat.discovery.services.WiFiServicesAdapter;

public class CustomDnsServiceResponseListener implements WifiP2pManager.DnsSdServiceResponseListener {

    private static final String TAG = "DnsRespListener";

    @Override
    public void onDnsSdServiceAvailable(String instanceName, String registrationType, WifiP2pDevice srcDevice) {
        if (instanceName.equalsIgnoreCase(Configuration.SERVICE_INSTANCE)) {

            WiFiP2pServicesFragment fragment = TabFragment.getWiFiP2pServicesFragment();
            if (fragment != null) {
                WiFiServicesAdapter adapter = fragment.getMAdapter();
                WiFiP2pService service = new WiFiP2pService();
                service.setDevice(srcDevice);
                service.setInstanceName(instanceName);
                service.setServiceRegistrationType(registrationType);

                ServiceList.getInstance().addServiceIfNotPresent(service);

                if (adapter != null) {
                    adapter.notifyItemInserted(ServiceList.getInstance().getSize() - 1);
                }
                Log.d(TAG, "onDnsSdServiceAvailable " + instanceName);
            }
        }
    }
}
