package institute.immune.imagen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

public class Grabadora extends AppCompatActivity {

    private MediaRecorder mediaRecorder;
    private MediaController mediaController;
    private MediaPlayer mediaPlayer;
    private Button boton1, boton2, boton3;
    private File fichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabadora);

        bindings();

    }

    public void bindings(){

        boton1 = findViewById(R.id.grabar);
        boton2 = findViewById(R.id.parar);
        boton3 = findViewById(R.id.reproducir);

    }

    private void grabar(){
        mediaRecorder = new MediaRecorder();

        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);


        File path = null;

        try {
            path = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            fichero = File.createTempFile("audioTemporal", ".3gp",path);
            mediaRecorder.setOutputFile(fichero.getAbsolutePath());
            mediaRecorder.prepare();
        }

        catch (IOException e){
            Log.e("IO",e.getMessage());

        }
        mediaRecorder.start();

    }



    public void onClickGrabar(View view){
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 0 );
            }
            else{
                grabar();
                message(getString(R.string.msgGrabando));
            }
        }catch (Exception e){
            message(getString(R.string.error));
            Log.e("Error al grabar", e.getMessage());
        }

    }

    private void parar(){
        mediaRecorder.stop();
        message(getString(R.string.parar));
        mediaRecorder.release();
    }

    public void onClickParar(View view){
        parar();

    }

    private void reproducir() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                message("Audio Reproducido");
            }
        });
        try {
            mediaPlayer.setDataSource(fichero.getAbsolutePath());
            mediaPlayer.prepare();
        } catch (IOException e){
            Log.e("IO",e.getMessage());
        }
        mediaPlayer.start();

    }

    public void onClickReproducir(View view){
        reproducir();

    }

    private void message(String texto){
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();

    }
}