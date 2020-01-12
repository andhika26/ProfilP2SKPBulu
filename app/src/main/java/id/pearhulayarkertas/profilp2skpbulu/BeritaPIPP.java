package id.pearhulayarkertas.profilp2skpbulu;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BeritaPIPP extends AppCompatActivity {


    WebView mainWebView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_pipp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


            mainWebView = (WebView) findViewById(R.id.mainWebView);
            mainWebView.getSettings().setJavaScriptEnabled(true);
            mainWebView.getSettings().setAllowFileAccess(true);
            mainWebView.loadUrl("http://pipp.djpt.kkp.go.id/berita");
            mainWebView.setWebViewClient(new MainWebViewClient());
            getWindow().setFeatureInt(Window.PROGRESS_VISIBILITY_ON, Window.FEATURE_PROGRESS);
            mainWebView.setWebChromeClient(new WebChromeClient() {

                public void onProgressChanged(WebView view, int progress) {
                    BeritaPIPP.this.setTitle("Berita PIPP");
                    BeritaPIPP.this.setProgress(progress * 50);
                    if (progress == 50) {
                       BeritaPIPP.this.setTitle(view.getTitle());
                    }
                }
            });


    }


    private class MainWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i("Log", "loading: " + url);
            view.loadUrl(url);
            return true;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_utama, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            kembali();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void kembali() {
        startActivity(new Intent(BeritaPIPP.this, MenuUtama2.class));
        BeritaPIPP.this.finish();
    }

}
