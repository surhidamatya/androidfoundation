package com.surdroid.understandingintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * only few examples are listed here.
 * For more example of Intents.
 * Please visit
 *
 * @see <a href="http://developer.android.com/intl/es/guide/components/intents-common.html">Intent List</>
 */
public class ListImplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_implicit);
    }

    /**
     * Making an call requires permission listed in {@link android.Manifest} file
     */
    public void makeCall(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:0377778888"));
        startActivity(callIntent);

    }

    public void sendEmail(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"some@email.address"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "mail body");
        startActivity(Intent.createChooser(intent, ""));
    }

    public void launchBrowser(View v) {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(browserIntent);

    }
}
