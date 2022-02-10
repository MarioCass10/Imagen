package institute.immune.imagen;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);



    }

    public void onClickVideo(View view){
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.si));
        videoView.start();
        message(getString(R.string.empieza));
    }

    private void message(String texto){
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }

    private void empieza(){
        message(getString(R.string.empieza));

    }


}