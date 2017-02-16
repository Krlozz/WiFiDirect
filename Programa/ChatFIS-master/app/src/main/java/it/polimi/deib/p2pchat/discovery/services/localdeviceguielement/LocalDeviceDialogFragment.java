package it.polimi.deib.p2pchat.discovery.services.localdeviceguielement;

import android.support.v4.app.DialogFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import it.polimi.deib.p2pchat.R;

public class LocalDeviceDialogFragment extends DialogFragment {

    private Button confirmButton;
    private EditText deviceNameEditText;

    public interface DialogConfirmListener {
        public void changeLocalDeviceName(String deviceName);
    }

    public static LocalDeviceDialogFragment newInstance() {
        return new LocalDeviceDialogFragment();
    }

    public LocalDeviceDialogFragment() {}


    @Override
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog, container, false);

        getDialog().setTitle(getResources().getString(R.string.choose_device_name));
        deviceNameEditText = (EditText) v.findViewById(R.id.deviceNameEditText);
        confirmButton = (Button) v.findViewById(R.id.confirmButton);

        this.setListener();

        return v;
    }

    private void setListener() {
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ((DialogConfirmListener)getTargetFragment()).changeLocalDeviceName(deviceNameEditText.getText().toString());
                dismiss();
            }
        });
    }
}
