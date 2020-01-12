package id.pearhulayarkertas.profilp2skpbulu;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by andhika on 05/25/2017.
 */

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    Log.d("Exception", "Exception" + e);
                } finally {
                    startActivity(new Intent(SplashScreen.this, MenuUtama2.class));
                }
                finish();
            }
        };
        logoTimer.start();


    }
}
