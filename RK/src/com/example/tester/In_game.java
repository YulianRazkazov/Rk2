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
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.BaseBundle;
import android.os.Bundle; 
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
	public class In_game extends ActionBarActivity {
		ImageButton Paper, Metal, Special, Plastic,Glass;
		TextView Score, Hint;
		AssetManager filequestions;
		ArrayList<String> questions = new ArrayList<String>();
		ImageView Center;
		AssetManager aset;
		private int[] answers = new int[5];
		ArrayList<ImageButton> aButtons = new ArrayList<ImageButton>();
		
		
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_in_game);
			aButtons.add((ImageButton)findViewById(R.id.Paper));
			aButtons.add((ImageButton)findViewById(R.id.Metal));
			aButtons.add((ImageButton)findViewById(R.id.Special));
			aButtons.add((ImageButton)findViewById(R.id.Plastic));
			aButtons.add((ImageButton)findViewById(R.id.Glass));
	        Center=(ImageView) findViewById(R.id.MainPicture);
	        
			try {
				questionMaker(fileReader());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assetpic();
		}
		
		
				public ArrayList<String> fileReader() throws IOException {
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
				for(int i=0; i<lines.size();i++){
					questions.add(lines.get(i));
					Collections.shuffle(questions, new Random(System.nanoTime()));
				}
				
				
			}
				public void assetpic(){
					AssetManager assetManager = getAssets();
			        InputStream istr;
			        try {
			        	istr = assetManager.open(questions.get(0).split(" ")[0]);
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
		    
		    public void onClick(View v){
	            switch (v.getId()) {
	                case R.id.Paper:
	                    selectButton(0);
	                    break;
	                case R.id.Metal:
	                	selectButton(1);
	                    break;
	                case R.id.Special:
	                	selectButton(2);
	                    break;
	                case R.id.Plastic:
	                	selectButton(3);
	                    break;
	                case R.id.Glass:
	                	selectButton(4);
	                    break;
	                case R.id.Submit:
	                	doShit();
	                	break;
	            }
		    }
		    
		    void selectButton(int position){
		    	if (answers[position] == 0){
		    		aButtons.get(position).setBackgroundResource(selectBackground(position));
		    		answers[position] = 1;
		    	}else {
		    		aButtons.get(position).setBackgroundResource(selectBackground(position + 6));
		    		answers[position] = 0;
		    	}
		    }
		    
		    int selectBackground(int position){
		    	switch (position){
		    	case 0:
		    		return R.drawable.paper_push;
		    	case 1:
		    		return R.drawable.metal_push;
		    	case 2:
		    		return R.drawable.special_push;
		    	case 3:
		    		return R.drawable.plastic_push;
		    	case 4:
		    		return R.drawable.glass_push;
		    	case 5:
		    		return R.drawable.paper_push;
		    	case 6:
		    		return R.drawable.paper;
		    	case 7:
		    		return R.drawable.metal;
		    	case 8:
		    		return R.drawable.special;
		    	case 9:
		    		return R.drawable.plastic;
		    	case 10:
		    		return R.drawable.glass;
		    	case 11:
		    		return R.drawable.paper;
		    	default:
		    			return 0;
		    	}
		    }
		    
		    void goToAnsweredWrong(){
				Intent myAnsweredWrongIntent = new Intent(In_game.this, Highscore.class);
				In_game.this.startActivity(myAnsweredWrongIntent);
				finish();
			}
		    void doShit(){
		    	String[] realAnswers = questions.get(0).split(" ")[1].split(",");
		    	for (int i= 0; i < 5; i++){
		    		if (answers[i] == 1){
		    			for (String ans : realAnswers) {
				    		if (Integer.parseInt(ans) == i){
				    			System.out.println("evala produljavash");
							}else {
								goToAnsweredWrong();
							}
		    			}
		    		}
		    		
		    		
		    	}
		    }
	}
	