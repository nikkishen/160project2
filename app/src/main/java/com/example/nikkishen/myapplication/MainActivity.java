package com.example.nikkishen.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

public class MainActivity extends AppCompatActivity {


    public Button button2;

    public void init2() {
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, location.class);
                startActivity(next);
            }
        });

    }

    public Button button3;

    public void init3() {
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, random.class);
                startActivity(next);
            }
        });
    }

    public EditText editText5;

    public void init5() {
        editText5 = (EditText) findViewById(R.id.editText5);
        editText5.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String code = editText5.getText().toString().trim();

                if (code.length() == 5) {

                    if (actionId == EditorInfo.IME_ACTION_DONE) {

                        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                        Intent next = new Intent(MainActivity.this, zipcode.class);
                        next.putExtra("code", code);
                        startActivity(next);
                    }

                } else {

                    Toast.makeText(MainActivity.this, "Invalid Zipcode", Toast.LENGTH_SHORT).show();
                }


                return false;
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init2();
        init3();
        init5();

        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE, Permission.Group.LOCATION)
                .start();
    }
}
