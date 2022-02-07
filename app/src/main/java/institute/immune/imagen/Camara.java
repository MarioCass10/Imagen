package institute.immune.imagen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Camara extends AppCompatActivity {

    ImageView imageView;
    VideoView videoView;
    Button boton;
    Button boton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        imageView = findViewById(R.id.imangenCamara);
        videoView = findViewById(R.id.Video);

       boton= findViewById(R.id.boton);
       boton2  = findViewById(R.id.boton2);

    }

    public void abrirCamara(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    public void abrirVideo(View view) {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, 2);
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(resultCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imgBitmap);
        }

        if (requestCode == 2 && resultCode == RESULT_OK){
            Uri uri = data.getData();
            MediaController m = new MediaController(this);
            videoView.setMediaController(m);
            videoView.setVideoURI(uri);
            videoView.start();
        }


    }



}