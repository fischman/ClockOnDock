package org.fischman.clockondock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PowerConnectionReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    String[] packageNames = {
        "com.google.android.deskclock", // JB on GN
        "com.android.deskclock", // Emulator, possibly pre-Froyo
        "com.htc.android.worldclock", // HTC
        "com.motorola.blur.alarmclock", // Moto Blur
        "com.sec.android.app.clockpackage", // Samsung Galaxy
    };
    Intent clockIntent = null;
    for (String packageName : packageNames) {
      clockIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
      if (clockIntent != null)
        break;
    }
    if (clockIntent != null) {
      clockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      context.startActivity(clockIntent);
    } else {
      Log.w("ClockOnDock", "Couldn't find a launchable intent for any package name!");
    }
  }
}
