package com.example.plugin;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;


public class CheckServices extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        JSONObject jo = new JSONObject();
        if (action.equals("check")) {

            try {

                final String installer = this.cordova.getActivity().getApplicationContext().getPackageManager().getInstallerPackageName(this.cordova.getActivity().getApplicationContext().getPackageName());
                callbackContext.success(jo.put("type", installer));
                return true;
            }

            catch (Exception e) {
                callbackContext.error(jo.put("error", e.getMessage()));
                return false;
            }

        } else {
            
            return false;

        }
    }
}
