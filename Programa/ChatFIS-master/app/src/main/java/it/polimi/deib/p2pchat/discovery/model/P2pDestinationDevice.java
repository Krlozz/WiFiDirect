package it.polimi.deib.p2pchat.discovery.model;

import android.net.wifi.p2p.WifiP2pDevice;

import lombok.Getter;
import lombok.Setter;

public class P2pDestinationDevice {

    @Getter private WifiP2pDevice p2pDevice;
    @Getter @Setter private String destinationIpAddress; 

    public P2pDestinationDevice(WifiP2pDevice p2pDevice) {
        this.p2pDevice = p2pDevice;
    }

    public P2pDestinationDevice() {}

    @Override
    public String toString() {
        return this.p2pDevice.deviceName + ", " + this.p2pDevice.deviceAddress + ", " + this.p2pDevice.status;
    }
}
