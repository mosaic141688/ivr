package com.example.sihle.myapplication;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;


public class UssdService extends AccessibilityService  {

    public static String TAG = "USSDSERVICE";

    public UssdService(){
        super();
        Log.e("USSD SERVICE","Constructor");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, "onAccessibilityEvent");
        String text = event.getText().get(0).toString();

        if (event.getClassName().equals("android.app.AlertDialog")) {
           // performGlobalAction(GLOBAL_ACTION_BACK);
            Log.d(TAG, text);
            Intent intent = new Intent("com.times.ussd.action.REFRESH");
            intent.putExtra("message", text);
            // write a broad cast receiver and call sendbroadcast() from here, if you want to parse the message for balance, date
        }

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Service Start");
        return super.onStartCommand(intent,flags,startId);

    }

    @Override
    public void onInterrupt() {
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.e(TAG, "onServiceConnected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.packageNames = new String[]{"com.android.phone"};
        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
    }


}


