package ie.wspace.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Capture the layout's TextView and set the string as it's text
        TextView textView = findViewById(R.id.textView);
        textView.setText("Showing search results for: " + message);

        //Load a Webview, and prevent it from automatically redirecting to the chrome app
        final WebView wbView = (WebView) findViewById(R.id.webView1);
        wbView.setWebViewClient(new WebViewClient());
        wbView.getSettings().setJavaScriptEnabled(true);
        wbView.loadUrl("https://google.ie/search?q=" + message);
        wbView.clearView();
        wbView.measure(100, 100);
        wbView.getSettings().setUseWideViewPort(true);
        wbView.getSettings().setLoadWithOverviewMode(true);

    }
}
