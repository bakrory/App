package com.example.maintance_reg_screen1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class log extends AppCompatActivity {
    EditText txtusernam, txtpassword;
    TextView forg;

    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        txtusernam = findViewById(R.id.txtusername);
        txtpassword = findViewById(R.id.txtpassword);
        btnok = findViewById(R.id.btnlogin);
        forg = findViewById(R.id.forgetpass);
        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void reg(View view) {

        startActivity(new Intent(log.this, MainActivity.class));

    }

    public void log1(View view) {


        if (txtusernam.getText().toString().isEmpty()) {
            txtusernam.setError("Enter the user name");
            txtusernam.requestFocus();
        } else {
            if (txtpassword.getText().toString().isEmpty()) {
                txtpassword.setError("Enter the password");
                txtusernam.requestFocus();
            } else {
             //   String name = txtusernam.getText().toString();
             //   int password = Integer.parseInt(txtpassword.getText().toString());
                //vervfev

                Database db = new Database();
                Connection conn = db.ConnectDB();
                if (conn == null) {
                    Toast.makeText(log.this, "Check internet access", Toast.LENGTH_SHORT).show();

                } else {

                    ResultSet rs=db.RunSearch("select * from [User] where [User Name]='"+txtusernam.getText()+"' and password='"+txtpassword.getText()+"'");

                    try {
                        if(rs.next())
                         {
                             //   startActivity(new Intent(log.this,MainActivity.class));}}

                             Toast.makeText(log.this, "مفروض دلوقتي تظهر الصفحه الجديده", Toast.LENGTH_LONG).show();
                        }
                    else{

                            AlertDialog.Builder m = new AlertDialog.Builder(log.this)
                                    .setTitle("Login....")
                                    .setMessage("invalid user name or password")
                                    .setIcon(R.drawable.owls)
                                    .setPositiveButton("Try Again", null);
                            m.create().show();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}





