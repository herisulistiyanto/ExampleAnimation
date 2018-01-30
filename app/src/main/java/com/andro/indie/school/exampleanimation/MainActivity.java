package com.andro.indie.school.exampleanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageIcon;
    private Button btnPlay;
    private AnimUtil animUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animUtil = ((AnimationApp) getApplication()).getAnimUtil();

        imageIcon = findViewById(R.id.iv_icon);
        btnPlay = findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMyAnim(AnimType.ANIM_ZOOM_IN);
            }
        });
    }

    private void setMyAnim(@AnimType int animType) {
        animUtil.setAnim(imageIcon, animType, new AnimUtil.AnimListener() {
            @Override
            public void onAnimStart() {
                Toast.makeText(MainActivity.this, "START", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimEnd() {
                Toast.makeText(MainActivity.this, "END", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimRepeat() {

            }
        });
    }
}
