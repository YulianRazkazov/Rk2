package com.example.tester;
import java.io.IOException;

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
import android.widget.MediaController.MediaPlayerControl;


public class MainActivity extends ActionBarActivity {
	Button start, highscore, about, settings,Soundoff,Soundon;
	MediaPlayer mp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.First);
        highscore = (Button)findViewById(R.id.Second);
        about =(Button)findViewById(R.id.Third);
        settings=(Button)findViewById(R.id.Settings);
        Soundoff =(Button) findViewById(R.id.Soundoff);
        Soundon =(Button) findViewById(R.id.Soundon);
        
        mp = MediaPlayer.create(this,R.raw.k);
        mp.setLooping(true);
        mp.start();
      

        start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, In_game.class);
				MainActivity.this.startActivity(myIntent);
				
			}
		});
        highscore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, Highscore.class);
				MainActivity.this.startActivity(myIntent);
				}
		});
        about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, About.class);
				MainActivity.this.startActivity(myIntent);
				}
		});
        
        Soundoff.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mp.pause();
			}		
        });
        
        Soundon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
		        mp.start();
			}		
		});

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
