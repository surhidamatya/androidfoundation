package com.surdroid.androidlinkifyexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_layout);

        TextView myWebSite = new TextView(this);
        myWebSite.setText("http://www.youtube.com");
        Linkify.addLinks(myWebSite, Linkify.WEB_URLS);
        mainLayout.addView(myWebSite);

        TextView myPhone = new TextView(this);
        myPhone.setText("5554567891");
        Linkify.addLinks(myPhone, Linkify.PHONE_NUMBERS);
        mainLayout.addView(myPhone);

        TextView myEmail = new TextView(this);
        myEmail.setText("abc@gmail.com");
        Linkify.addLinks(myEmail, Linkify.EMAIL_ADDRESSES);
        mainLayout.addView(myEmail);

        TextView myLocation = new TextView(this);
        myLocation.setText("436 Mayfield Ave, Stanford, CA");
        Linkify.addLinks(myLocation, Linkify.MAP_ADDRESSES);
        mainLayout.addView(myLocation);


        TextView myCustomLink = new TextView(this);
        Pattern pattern = Pattern.compile("[a-zA-Z]+&");
        myCustomLink.setText("press Linkify$ or on Android& to search it on google");
        Linkify.addLinks(myCustomLink, pattern, "http://www.google.ie/search?q=");
        mainLayout.addView(myCustomLink);

        Linkify.MatchFilter myMatchFilter = new Linkify.MatchFilter() {

            @Override
            public boolean acceptMatch(CharSequence cs, int start, int end) {
                return start > 42;
            }
        };

        TextView myCustomLink2 = new TextView(this);
        Pattern pattern2 = Pattern.compile("[a-zA-Z]+");
        myCustomLink2.setText("press one of these words to search it on google: Android Linkify");
        Linkify.addLinks(myCustomLink2, pattern2, "http://www.google.ie/search?q=", myMatchFilter, null);
        mainLayout.addView(myCustomLink2);

        Linkify.TransformFilter myTransformFilter = new Linkify.TransformFilter() {

            @Override
            public String transformUrl(Matcher match, String url) {
                return url.substring(1); //remove the $ sign
            }
        };

        TextView myCustomLink3 = new TextView(this);
        Pattern pattern3 = Pattern.compile("\\$[a-zA-Z]+");
        myCustomLink3.setText("press $Linkify or on $Android to search it on google");
        Linkify.addLinks(myCustomLink3, pattern3, "http://www.google.ie/search?q=", null, myTransformFilter);
        mainLayout.addView(myCustomLink3);


    }
}
