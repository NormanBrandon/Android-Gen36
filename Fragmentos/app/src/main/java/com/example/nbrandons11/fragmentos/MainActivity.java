package com.example.nbrandons11.fragmentos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Frac2.OnFragmentInteractionListener,frac1.OnFragmentInteractionListener,View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frac1 fragmento1 = new frac1();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();

        transition.replace(R.id.contenedor,fragmento1);
        transition.commit();
        Button America =(Button)findViewById(R.id.btn1);
        Button Europa =(Button)findViewById(R.id.btn2);//botoncitos del main
        Button Africa =(Button)findViewById(R.id.btn3);
        Button Asia =(Button)findViewById(R.id.btn4);
        Button Oceania =(Button)findViewById(R.id.btn5);

        America.setOnClickListener(this);
        Europa.setOnClickListener(this);
        Africa.setOnClickListener(this);
        Asia.setOnClickListener(this);
        Oceania.setOnClickListener(this);




    }

    @Override
    public void onClick(View v){
        Frac2 fragmento2 = new Frac2();


        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        TextView tv =(TextView)findViewById(R.id.tv);
        transition.replace(R.id.contenedor,fragmento2);//remplaza el framelayout por el fragmento de shit
        transition.commit();

        switch (v.getId())
        {
            case R.id.btn1:
               tv.setText("America");

               // fragmento2.cambiarTexto("America");en estos truena alv,oceania no truena porque no lo puse

                break;
            case R.id.btn2:
                tv.setText("Europa");
              //  fragmento2.cambiarTexto("America");
                break;
            case R.id.btn3:
                tv.setText("Africa");
               // fragmento2.cambiarTexto("America");
                break;
            case R.id.btn4:
                tv.setText("Asia");
               // fragmento2.cambiarTexto("America");
                break;


        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



}
