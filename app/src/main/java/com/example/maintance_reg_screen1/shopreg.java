package com.example.maintance_reg_screen1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class shopreg extends AppCompatActivity {
EditText shop_rnd,shop_rnd_ans;
Button shop_con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopreg);
        shop_con=findViewById(R.id.shop_btnok);
        shop_rnd_ans=findViewById(R.id.shop_rand_ans);
        code_control ms=new code_control();

       shop_rnd.setText(ms.randtxt());
       shop_con.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String n=shop_rnd.getText().toString();
               String l=shop_rnd_ans.getText().toString();
               code_control ms=new code_control();
               if (n.equals(l)){

               }else{
                  shop_rnd_ans.setError("try again");
                  shop_rnd.setText(ms.randtxt());
               }
           }
       });

    }
}
