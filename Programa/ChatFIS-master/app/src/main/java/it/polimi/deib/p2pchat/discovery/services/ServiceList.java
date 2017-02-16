package it.polimi.deib.p2pchat.discovery.services;

import android.net.wifi.p2p.WifiP2pDevice;

import java.util.ArrayList;
import java.util.List;

import it.polimi.deib.p2pchat.discovery.utilities.UseOnlyPrivateHere;

public class ServiceList {

    @UseOnlyPrivateHere private final List<WiFiP2pService> serviceList;

    private static final ServiceList instance = new ServiceList();

    public static ServiceList getInstance() {
        return instance;
    }

    private ServiceList() {
        serviceList = new ArrayList<>();
    }

    public void addServiceIfNotPresent(WiFiP2pService service) {
        if(service==null) {
            return;
        }

        boolean add = true;
        for (WiFiP2pService element : serviceList) {
            if (element.getDevice().equals(service.getDevice())
                    && element.getInstanceName().equals(service.getInstanceName())) {
                add = false; 
            }
        }

        if(add) {
            serviceList.add(service);
        }
    }

    public WiFiP2pService getServiceByDevice(WifiP2pDevice device) {
        if(device==null) {
            return null;
        }

        for (WiFiP2pService element : serviceList) {
            if (element.getDevice().deviceAddress.equals(device.deviceAddress) ) {
                return element;
            }
        }
        return null;
    }

    public int getSize() {
        return serviceList.size();
    }

    public void clear() {
        serviceList.clear();
    }

    public WiFiP2pService getElementByPosition(int position) {
        return serviceList.get(position);
    }
}
