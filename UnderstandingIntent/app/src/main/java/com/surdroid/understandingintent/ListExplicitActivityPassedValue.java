package com.surdroid.understandingintent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Showcase value can be passed on using Intent from one Activty to another
 * Here value is passed from {@link ListExplicitActivity} to {@link ListExplicitActivityPassedValue}
 */
public class ListExplicitActivityPassedValue extends AppCompatActivity {

    private String userName = "";
    private String password = "";
    private boolean forResult = false;

    TextView txtvwPassedValue;
    Button btnPassValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_explicit_two);
        btnPassValue = (Button) findViewById(R.id.btn_pass_value);

        txtvwPassedValue = (TextView) findViewById(R.id.txtvw_passed_value);
        Intent intent = getIntent();
        if (intent != null) {
            userName = intent.getStringExtra(Constants.VALUE_ONE);
            password = intent.getStringExtra(Constants.VALUE_TWO);

            txtvwPassedValue.setText("This is the passed on value " + userName + " " + password);

            forResult = intent.getBooleanExtra(Constants.FOR_ACTIVITY_RESULT, false);
            if (forResult) {
                btnPassValue.setVisibility(View.VISIBLE);
                txtvwPassedValue.setVisibility(View.GONE);
            }
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, ListExplicitActivity.class));
        finish();

    }

    /**
     * Return an value to {@link ListExplicitActivity}
     */
    public void passValueParentActivity(View v) {
        Intent intent = new Intent();
        intent.putExtra(Constants.VALUE_ONE, "Passed from called Activity for startActivityforResult");
        setResult(ListExplicitActivity.RESULT_CODE, intent);
        finish();
    }
}
