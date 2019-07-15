package com.example.maintance_reg_screen1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;

public class MainActivity<n> extends AppCompatActivity {
    EditText username, email, fname, password, phone, cpassword;
public static String username1;
    //RadioButton radiotwo,reg_1,reg_2;
    // RadioGroup reg_per;
    Button next1;
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        fname = findViewById(R.id.fname);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        cpassword = findViewById(R.id.cpassword);
        next1 = findViewById(R.id.regest);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String user = username.getText().toString();
                String fullnam = fname.getText().toString();


                if (user.isEmpty()) {
                    username.setError("set user name");
                } else {
                    if (fullnam.isEmpty()) {
                        fname.setError("set your name");
                    } else {
                        if (cpassword.getText().toString().isEmpty()) {
                            cpassword.setError("confirm password");
                        } else {
                            if (password.getText().toString().isEmpty()) {
                                password.setError("set password");
                            } else {

                                if (email.getText().toString().isEmpty()) {
                                    email.setError("set yor mail");
                                } else {
                                    if (phone.getText().toString().isEmpty()) {
                                        phone.setError("set phone");
                                    } else {
                                        if (!password.getText().toString().equals(cpassword.getText().toString())) {
                                            password.setError("set password again");
                                            cpassword.setError("set password again");
                                        } else {
                                            Database db = new Database();
                                            Connection conn = db.ConnectDB();
                                            if (conn == null) {
                                                Toast.makeText(MainActivity.this, "check internet access!!!!", Toast.LENGTH_LONG);
                                            } else {
                                                String msg = db.RunDML("insert into [User] values ('" + username.getText() + "','" + fname.getText() + "','" + email.getText() + "','','" + phone.getText() + "','" + password.getText() + "','','','','','')");
                                                if (msg.equals("Ok")) {
                                                    username1=username.getText().toString();
                                                    startActivity(new Intent(MainActivity.this,homepage.class));
                                                } else {
                                                    Toast.makeText(MainActivity.this, "check code!!!!" + msg, Toast.LENGTH_LONG);
                                                }

                                            }

                                            }
                                        }
                                    }
                                }
                                //8
                            }/*7 */
                        }/*6*/
                    }/*5*/
                }





        });



    }
}
























