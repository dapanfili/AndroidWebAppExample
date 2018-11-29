package ser421.edu.asu.dpanfili_act3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class WebActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_activity);
        final WebView browser = (WebView)findViewById(R.id.myWebView);
        browser.addJavascriptInterface(new WebAppInterface(this), "Android");
        browser.setWebContentsDebuggingEnabled(true);
        browser.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);


        final Intent goToGamePort = getIntent();



        browser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                String name = goToGamePort.getExtras().getString("username");
                browser.loadUrl("javascript:setUserName('" + name + "')");
            }
        });

        browser.loadUrl("file:///android_asset/clue.html");

    }


}


