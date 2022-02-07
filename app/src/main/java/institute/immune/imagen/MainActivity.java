package institute.immune.imagen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button; Button button2; Button button3;
    MediaPlayer mediaPlayer;
    ArrayList<Cancion> canciones;

    CharSequence text = "Reproduciendo";
    int duration = Toast.LENGTH_SHORT;

    int posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer [4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        button3 = findViewById(R.id.button5);



        mediaPlayer = MediaPlayer.create(this, R.raw.morad);


        vectormp[0] = MediaPlayer.create(this, R.raw.morad);
        vectormp[1] = MediaPlayer.create(this, R.raw.balvin);
        vectormp[2] = MediaPlayer.create(this, R.raw.anuel);
        vectormp[3] = MediaPlayer.create(this, R.raw.bunny);
    }

    public ArrayList<Cancion> obtenerCanciones(){

        canciones = new ArrayList<Cancion>();
        Cancion cancion = new Cancion(R.raw.balvin,R.drawable.balvin);
        // Añade el elemento al ArrayList
        canciones.add(cancion);
        cancion = new Cancion(R.raw.anuel,R.drawable.anuel);
        canciones.add(cancion);
        cancion = new Cancion(R.raw.morad,R.drawable.futbol);
        canciones.add(cancion);
        cancion = new Cancion(R.raw.bunny,R.drawable.bunny);
        canciones.add(cancion);
        // Añade el elemento al ArrayList en la posición 'n'
        return canciones;
    }


    public void onClickPlay(View view) {

        if (vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            button.setBackgroundResource(R.drawable.balvin);
            Toast.makeText(this, "Reproduciendo", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
        }

    }

    public void onClickPausa(View view) {
        if (vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }
    }

        public void onClickStop (View view){
            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
            } else {
                vectormp[posicion].start();
            }
    }



    public void onClickSiguiente(View view) {
        if ( posicion < vectormp.length -1) {

            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
            } else {
                posicion++;
            }
        }else{
            Toast.makeText(this, "Siguiente", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickAnterior(View view) {
        if (vectormp[posicion] != null) {
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.morad);
            vectormp[1] = MediaPlayer.create(this, R.raw.balvin);
            vectormp[2] = MediaPlayer.create(this, R.raw.anuel);
            vectormp[3] = MediaPlayer.create(this, R.raw.bunny);
            posicion = 0;

            Toast.makeText(this, "Cancion Anterior", Toast.LENGTH_SHORT).show();
        }
    }






}
