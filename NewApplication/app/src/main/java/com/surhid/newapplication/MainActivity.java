package com.surhid.newapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

//testing
public class MainActivity extends AppCompatActivity {

    private EditText edtFirstName, edtLastName, edtAddress, edtPhoneNumber;
    private Button btnOk, btnCancel;
    private RadioButton rbMale, rbFemale;

    private String firstName, lastName, address, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFirstName = findViewById(R.id.edt_first_name);
        edtLastName = findViewById(R.id.edt_last_name);
        edtAddress = findViewById(R.id.edt_address);
        edtPhoneNumber = findViewById(R.id.edt_phone);
        btnOk = findViewById(R.id.btn_ok);
        btnCancel = findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);


    }

    private void emptyForm() {
        edtFirstName.setText("");
        edtLastName.setText("");
        edtAddress.setText("");
        edtPhoneNumber.setText("");
        rbMale.setChecked(false);
        rbFemale.setChecked(false);
    }

    private void getFormValue() {
        firstName = edtFirstName.getText().toString().trim();
        lastName = edtLastName.getText().toString().trim();
        address = edtAddress.getText().toString().trim();
        phoneNumber = edtPhoneNumber.getText().toString().trim();

    }
}
