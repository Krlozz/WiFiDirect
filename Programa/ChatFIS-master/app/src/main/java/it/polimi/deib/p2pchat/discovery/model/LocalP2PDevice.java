package it.polimi.deib.p2pchat.discovery.model;

import android.net.wifi.p2p.WifiP2pDevice;

import lombok.Getter;
import lombok.Setter;

public class LocalP2PDevice {

    @Getter @Setter private WifiP2pDevice localDevice;

    private static final LocalP2PDevice instance = new LocalP2PDevice();

    public static LocalP2PDevice getInstance() {
        return instance;
    }

    private LocalP2PDevice(){
        localDevice = new WifiP2pDevice();
    }

}
