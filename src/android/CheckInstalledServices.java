package com.example.plugin;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class CheckServices extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("check")) {
			JSONObject jo = new JSONObject();
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            int val = googleApiAvailability.isGooglePlayServicesAvailable(this.cordova.getActivity().getApplicationContext());
            System.out.println("Value is  :"+ val);
            System.out.println("Value is  :"+ ConnectionResult.SUCCESS);
			callbackContext.success(jo.put("isGooglePlayServicesAvailable", val == ConnectionResult.SUCCESS));
            return true;

        } else {
            
            return false;

        }
    }
}
