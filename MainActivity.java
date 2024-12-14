package com.example.wallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Drawable drawable;
    WallpaperManager wallpaperManager;
    Timer timer;
    int id=1;
    Bitmap wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.btn_change);
        timer=new Timer();
        wallpaperManager=WallpaperManager.getInstance(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changewallpaper();
            }
        });
    }
    public void changewallpaper()
    {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(id==1){
                    drawable=getResources().getDrawable(R.drawable.one);
                    id=2;
                }
                else if(id==2){
                    drawable=getResources().getDrawable(R.drawable.two);
                    id=3;
                }
                else if(id==3){
                    drawable=getResources().getDrawable(R.drawable.three);
                    id=4;
                }
                else if(id==4){
                    drawable=getResources().getDrawable(R.drawable.four);
                    id=5;
                }
                else if(id==5){
                    drawable=getResources().getDrawable(R.drawable.five);
                    id=1;
                }
                wallpaper = ((BitmapDrawable)drawable).getBitmap();
                try{
                    wallpaperManager.setBitmap(wallpaper);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        },0,5000);
    }
}