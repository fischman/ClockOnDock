// Copyright 2012 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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
