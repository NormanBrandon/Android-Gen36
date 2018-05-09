package com.example.nbrandons11.urlimagen;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
    ProgressBar simpleProgressBar;

    android.widget.Button boton;
    int miProgreso = 0;
    public static final String URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQw2bZVN4s7WW-j3GYPSQjgT4g6C1WUHODcXjH2nTY9e5mrp1bqg";
    private ImageView imgImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgImagen = (ImageView) findViewById(R.id.imageView);
        simpleProgressBar=(ProgressBar)findViewById(R.id.simpleProgressBar);

        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                 // initiate the progress bar
                simpleProgressBar.setIndeterminate(true);
                CargaImagenes nuevaTarea = new CargaImagenes();
                nuevaTarea.execute(URL);

            }
        });
    }


    public class CargaImagenes extends AsyncTask<String, Void, Bitmap> {
        ProgressBar simpleProgressBar=(ProgressBar) findViewById(R.id.simpleProgressBar);



        @Override
        protected Bitmap doInBackground(String... params) {
            Log.i("doInBackground", "Entra en doInBackground");
            String url = params[0];
            Bitmap imagen = descargarImagen(url);
            return imagen;
        }

        @Override
        protected void onPostExecute(Bitmap result) {

            super.onPostExecute(result);

            imgImagen.setImageBitmap(result);
            simpleProgressBar.setIndeterminate(false);
        }

        private Bitmap descargarImagen(String imageHttpAddress) {
            URL imageUrl = null;
            Bitmap imagen = null;
            try {
                imageUrl = new URL(imageHttpAddress);
                HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
                conn.connect();
                imagen = BitmapFactory.decodeStream(conn.getInputStream());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return imagen;
        }

    }
}


