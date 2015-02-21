package com.example.tester;
import java.io.IOException;
import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.media.Image.Plane;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController.MediaPlayerControl;


public class MainActivity extends ActionBarActivity {
	Button start, highscore, about, settings;
	ImageButton Sound;
	MediaPlayer mp;
	private int[] buttonsound = new int[1];
	ArrayList<ImageButton> Soundbutton = new ArrayList<ImageButton>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.First);
        highscore = (Button)findViewById(R.id.Second);
        about =(Button)findViewById(R.id.Third);
        settings=(Button)findViewById(R.id.Settings);
        Sound=(ImageButton)findViewById(R.id.Sound);
        Soundbutton.add((ImageButton)findViewById(R.id.Sound));
        
        
        mp = MediaPlayer.create(this,R.raw.k);
        mp.setLooping(true);
        mp.start();
    }
        public void onClick(View v){
        switch (v.getId()) {
            case R.id.Sound:
                selectButton(0);
                break;
            case R.id.Second:
            	Intent highscore = new Intent(MainActivity.this, Highscore.class);
				MainActivity.this.startActivity(highscore);
				break;
            case R.id.First:
            	Intent start = new Intent(MainActivity.this, In_game.class);
				MainActivity.this.startActivity(start);
            case R.id.Third:
            	Intent about = new Intent(MainActivity.this, About.class);
				MainActivity.this.startActivity(about);
			default:
				finish();
       }
}
        void selectButton(int position){
	    	if (buttonsound[position] == 0){
	    		Soundbutton.get(position).setBackgroundResource(selectBackground(position));
	    		buttonsound[position] = 1;
	    	}else {
	    		Soundbutton.get(position).setBackgroundResource(selectBackground(position) +1);
	    		buttonsound[position] = 0;
	    	}
	    }
        int selectBackground(int position){
	    	switch (position){
	    	case 0:
	    		mp.start();
	    		return R.drawable.soundon;
	    	case 1:
	    		mp.pause();
	    		return R.drawable.soundoff;
        	default:
        		return 0;
	    	}
        }
          
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
   
}
