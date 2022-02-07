package institute.immune.imagen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickMain(View view) {

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void onClickCamara(View view) {

        Intent intent = new Intent(this,Camara.class);
        startActivity(intent);

    }

    public void onClickGrabadora(View view) {

        Intent intent = new Intent(this,Grabadora.class);
        startActivity(intent);

    }
}