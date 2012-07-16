package org.fischman.clockondock;

import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class PowerConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) { 
    	Intent clockIntent = context.getPackageManager().getLaunchIntentForPackage("com.google.android.deskclock");  // JB on GN.
    	if (clockIntent == null)
    		clockIntent = context.getPackageManager().getLaunchIntentForPackage("com.android.deskclock");  // Pre-JB?  Definitely for emulator.
    	clockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	context.startActivity(clockIntent);
    }
}