package com.example.tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.BaseBundle;
import android.os.Bundle; 
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

	public class In_game extends ActionBarActivity {
		ImageButton Zero, One, Two, Three;
		TextView Score, Hint;
		AssetManager filequestions;
		ArrayList<String> questions = new ArrayList<String>();
		ImageView Center;
		AssetManager aset;
		
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_in_game);
			Zero = (ImageButton)findViewById(R.id.None);
	        One = (ImageButton)findViewById(R.id.Metal);
	        Two =(ImageButton)findViewById(R.id.Plastic);
	        Three =(ImageButton)findViewById(R.id.Paper);
	        Score = (TextView) findViewById(R.id.Score);
	        Hint = (TextView) findViewById(R.id.Hint);
	        Center=(ImageView) findViewById(R.id.MainPicture);
			try {
				questionMaker(fileReader());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assetpic();
		}
		
		
				public ArrayList<String> fileReader(BaseBundle lines) throws IOException {
				filequestions=getAssets();
				InputStream is = filequestions.open("Questionindex.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(is);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String line;
				ArrayList<String> list = new ArrayList<String>();
				while ((line=bufferedReader.readLine()) != null){
					list.add(line);
					}
				return list;
			}
			
			public void questionMaker(ArrayList<String> lines){
				for(int i=0; i<=lines.size();i+=2){
					questions.add(lines.get(i)+"\n"+lines.get(i+1));
					}
				for(int i=0; i<lines.size();i++){
					questions.add(lines.get(i));
				}
				
				Collections.shuffle(questions, new Random(System.nanoTime()));
				
			}
				public void assetpic(){
					AssetManager assetManager = getAssets();
			        InputStream istr;
			        try {
			            istr = assetManager.open(questions.get(0));
			            Bitmap bitmap = BitmapFactory.decodeStream(istr);
			            Center.setImageBitmap(bitmap);
			            istr.close();
			        } catch (IOException e) {
			            e.printStackTrace();
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

	