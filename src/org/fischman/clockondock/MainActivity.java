package org.fischman.clockondock;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast t = Toast.makeText(getApplicationContext(), "No UI; plug in power to launch clock!", Toast.LENGTH_SHORT);
        t.show();
        this.finish();
    }
}
