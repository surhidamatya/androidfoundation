package com.nagariknews.hawkerapp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.nagariknews.hawkerapp.R;
import com.nagariknews.hawkerapp.utils.GeneralUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    EditText edtFullName;
    EditText edtAddress;
    EditText edtPhoneNumber;
    EditText edtWardNumber;
    EditText edtKnownPlaces;

    TextInputLayout textInputFullName;
    TextInputLayout textInputAddress;
    TextInputLayout textInputPhoneNumber;
    TextInputLayout textInputWardNumber;
    TextInputLayout textInputNearPlaces;
    TextInputLayout textInputSelectedPaper;

    CheckBox checkBoxNagarik, checkBoxRepublica, checkBoxShukrabar;

    Button btnSubmit;

    private String fullName, fullAddress, phoneNumber, wardNumber, knownPlaces;

    private ArrayList<String> selectedPaper = new ArrayList<>();

    ProgressDialog progressDialog;

    boolean sendValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProgressBar();

        edtFullName = (EditText) findViewById(R.id.edt_full_name);
        edtAddress = (EditText) findViewById(R.id.edt_address);
        edtPhoneNumber = (EditText) findViewById(R.id.edt_phone_number);
        edtWardNumber = (EditText) findViewById(R.id.edt_ward_number);
        edtKnownPlaces = (EditText) findViewById(R.id.edt_near_known_place_or_person);

        textInputFullName = (TextInputLayout) findViewById(R.id.text_input_full_name);
        textInputAddress = (TextInputLayout) findViewById(R.id.text_input_address);
        textInputPhoneNumber = (TextInputLayout) findViewById(R.id.text_input_phone_number);
        textInputWardNumber = (TextInputLayout) findViewById(R.id.text_input_ward_number);
        textInputNearPlaces = (TextInputLayout) findViewById(R.id.text_input_near_place);
        textInputSelectedPaper = (TextInputLayout) findViewById(R.id.text_input_selected_paper);

        checkBoxNagarik = (CheckBox) findViewById(R.id.check_box_nagarik);
        checkBoxRepublica = (CheckBox) findViewById(R.id.check_box_republica);
        checkBoxShukrabar = (CheckBox) findViewById(R.id.check_box_shhukrabar);

        if (selectedPaper.size() >= 3) {
            selectedPaper.clear();
        }

        checkBoxNagarik.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                selectedPaper.add("Nagarik");
            }
        });

        checkBoxRepublica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                selectedPaper.add("Republica");
            }
        });


        checkBoxRepublica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                selectedPaper.add("Shukrabar");
            }
        });


        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkData()) {
                    if (GeneralUtils.isNetworkAvailable(MainActivity.this)) {
                        submitData();
                    } else {
                        Toast.makeText(MainActivity.this, R.string.no_internet, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initProgressBar() {
        progressDialog = new ProgressDialog(MainActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Submitting Data...");
    }

    private boolean checkData() {
        Log.i(TAG, "checkData: ");
        fullName = edtFullName.getText().toString().trim();
        fullAddress = edtAddress.getText().toString().trim();
        phoneNumber = edtPhoneNumber.getText().toString().trim();
        wardNumber = edtWardNumber.getText().toString().trim();
        knownPlaces = edtKnownPlaces.getText().toString().trim();

        if (TextUtils.isEmpty(fullName)) {
            sendValue = false;
            setError(textInputFullName, "Full name cannot be empty");
        } else {
            sendValue = true;
            textInputFullName.setError(null);
        }
        if (TextUtils.isEmpty(fullAddress)) {
            sendValue = false;
            setError(textInputAddress, "Full address cannot be empty");
        } else {
            sendValue = true;
            textInputAddress.setError(null);
        }

        if (TextUtils.isEmpty(phoneNumber)) {
            sendValue = false;
            setError(textInputPhoneNumber, "Phone number cannot be empty");
        } else {
            if (phoneNumber.startsWith("9")) {
                sendValue = true;
                textInputPhoneNumber.setError(null);
            } else {
                sendValue = false;
                setError(textInputPhoneNumber, "Mobile number should start with 9");
            }
        }

        if (TextUtils.isEmpty(wardNumber)) {
            sendValue = false;
            setError(textInputWardNumber, "Ward number cannot be empty");
        } else {
            sendValue = true;
            textInputWardNumber.setError(null);
        }

        if (TextUtils.isEmpty(knownPlaces)) {
            sendValue = false;
            setError(textInputNearPlaces, "Known places cannot be empty");
        } else {
            sendValue = true;
            textInputNearPlaces.setError(null);
        }

        if (selectedPaper.size() <= 0) {
            sendValue = false;
            setError(textInputSelectedPaper, "Please select at-least one paper");
        } else {
            sendValue = true;
            textInputSelectedPaper.setError(null);
        }
        return sendValue;

    }

    private void submitData() {
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // onLoginFailed();
                        progressDialog.dismiss();

                        setEmptyValue();
                    }
                }, 3000);
    }

    private void setEmptyValue() {
        edtFullName.setText("");
        edtAddress.setText("");
        edtPhoneNumber.setText("");
        edtWardNumber.setText("");
        edtKnownPlaces.setText("");
    }

    private void setError(TextInputLayout textInputLayout, String message) {
        if (!TextUtils.isEmpty(message)) {
            textInputLayout.setError(message);
        }
    }
}
