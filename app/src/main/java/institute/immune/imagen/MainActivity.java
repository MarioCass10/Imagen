package institute.immune.imagen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    MediaPlayer mediaPlayer;


    CharSequence text = "Reproduciendo";
    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        mediaPlayer = MediaPlayer.create(this, R.raw.morad);

    }

    public void onClickPlay(View view) {
        mediaPlayer.start();
        Toast play = Toast.makeText(this, text, duration);
        play.show();

    }

    public void onClickPausa(View view) {
        mediaPlayer.pause();
       /* Toast pausa = Toast.makeText(context, text, duration);
        pausa.show();*/

    }

    public void onClickStop(View view){
       /* Toast stop = Toast.makeText(context, text, duration);
        stop.show();*/
        mediaPlayer.stop();
    }

}
