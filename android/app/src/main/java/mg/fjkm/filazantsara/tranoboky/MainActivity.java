package mg.fjkm.filazantsara.tranoboky;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Splash screen
        registerPlugin(com.getcapacitor.plugin.splash.SplashScreenPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
