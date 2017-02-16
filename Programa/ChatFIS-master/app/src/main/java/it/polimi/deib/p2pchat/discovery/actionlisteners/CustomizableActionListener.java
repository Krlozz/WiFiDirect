package it.polimi.deib.p2pchat.discovery.actionlisteners;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

public class CustomizableActionListener implements WifiP2pManager.ActionListener {

    private final Context context;
    private final String successLog, successToast, failLog, failToast, tag;

    public CustomizableActionListener(@NonNull Context context,
                                      String tag,
                                      String successLog, String successToast,
                                      String failLog, String failToast) {
        this.context = context;
        this.successLog = successLog;
        this.successToast = successToast;
        this.failLog = failLog;
        this.failToast = failToast;

        if(tag==null) {
            this.tag = "ActionListenerTag";
        } else {
            this.tag = tag;
        }
    }

    @Override
    public void onSuccess() {
        if(successLog != null) {
            Log.d(tag, successLog);
        }
        if(context!=null && successToast != null) {
            Toast.makeText(context, successToast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(int reason) {
        if(failLog != null) {
            Log.d(tag, failLog + ", reason: " + reason);
        }
        if(context!=null && failToast != null) {
            Toast.makeText(context, failToast, Toast.LENGTH_SHORT).show();
        }
    }
}
