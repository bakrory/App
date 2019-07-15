package com.example.maintance_reg_screen1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;

public class second_reg extends AppCompatActivity {
EditText randomcod,pltnum,pltchar;
Spinner city,car,carpro;
TextView rnd;
Button   btnok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_reg);
        rnd=findViewById(R.id.shop_rand_view);
        randomcod=findViewById(R.id.shop_rand_ans);
       carpro=findViewById(R.id.choose_car_production);
        car=findViewById(R.id.choose_car_type);
        city=findViewById(R.id.choose_city);
        btnok=findViewById(R.id.shop_btnok);
        pltnum=findViewById(R.id.txtplatenum);
        pltchar=findViewById(R.id.txtcharplatnam);

           code_control ms=new code_control();

           rnd.setText(ms.randtxt());





        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=randomcod.getText().toString();
                String l=rnd.getText().toString();
                code_control ms=new code_control();



                   if(!n.equals(l)){
                    randomcod.setError("try again");
                    rnd.setText(ms.randtxt());}
                   else{
                       if(car.getSelectedItem().toString().isEmpty()||carpro.getSelectedItem().toString().isEmpty()){
                           Toast.makeText(second_reg.this,"choose the car and car details",Toast.LENGTH_LONG);}
                           else{
                               if(city.getSelectedItem().toString().isEmpty()){
                                   Toast.makeText(second_reg.this,"choose your city",Toast.LENGTH_LONG); }
                               else{


                                   Database db = new Database();
                                   Connection conn = db.ConnectDB();


                                   if (conn == null) {
                                       Toast.makeText(second_reg.this, "check internet access!!!!", Toast.LENGTH_LONG);
                                   } else {
                                       int carid=1;
                                       String msg = db.RunDML("insert into [Car] values ('"+carid+"','"+carpro.getSelectedItem()+"','"+car.getSelectedItem()+"','"+pltnum.getText()+"','','"+MainActivity.username1+"','"+pltchar.getText()+"')");
                                       if (msg.equals("Ok")) {
                                           startActivity(new Intent(second_reg.this, homepage.class));
                                       } else {
                                           Toast.makeText(second_reg.this, "check code!!!!" + msg, Toast.LENGTH_LONG);
                                       }
                               }
                       }

                   }
                }



            }
        });
    }







}
