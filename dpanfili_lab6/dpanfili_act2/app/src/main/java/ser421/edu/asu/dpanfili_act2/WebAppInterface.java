package ser421.edu.asu.dpanfili_act2;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
    Context myContext;

    WebAppInterface(Context c) {
        myContext = c;
    }

    @JavascriptInterface
    public String showName(String uname) {
        return uname;
    }
    @JavascriptInterface
    public void goToObtainNameActivity() {
        Intent i = new Intent(myContext.getApplicationContext(), MainActivity.class);
        myContext.startActivity(i);
    }

}