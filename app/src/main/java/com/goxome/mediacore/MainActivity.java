package com.goxome.mediacore;
 
import android.app.Activity;
import android.os.Bundle;
import com.goxome.media.core;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.view.View;
import android.content.Context;
import android.os.Build;

public class MainActivity extends Activity { 
    private TextView text;
  //private static final boolean AUTO_HIDE = true;
    private int currentApiVersion;//Navigation Bar Hide at Login Screen
    

    //              >>>>>>>>>>> Navigation Bar Hide <<<<<<<<<

      @Override
      protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    currentApiVersion = android.os.Build.VERSION.SDK_INT;
    final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
    View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    if (currentApiVersion >= Build.VERSION_CODES.N) {
        getWindow().getDecorView().setSystemUiVisibility(flags);
        final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                }
            });
    }
}
    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
               
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
              | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
              | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_FULLSCREEN 
              | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
   // }}
//             >>>>>>>>>>> Navigation Bar Hide <<<<<<<<<
   
/*
   /*@Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);*/

        setContentView(core.getLayout(getApplicationContext(),"activity_main"));
        //add custom toast
		core.getToastCustom(getApplicationContext(),"Started");
		core.getToastCustom(getApplicationContext(),";)");
		//add Music Background
		//add file "assets"
		
		core.openAssetMusics(getApplicationContext(),"music.mp3"); 
		text = findViewById(core.getId(getApplicationContext(),"text"));
		text.setText("Goxome Music");
    } 
//always write getApplicationContext so you don't crash your app or compile
}
