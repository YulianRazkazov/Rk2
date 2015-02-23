package com.example.tester;


	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStreamWriter;

	import android.app.Activity;
	import android.os.Bundle;
	import android.view.View;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.TextView;
	import android.widget.Toast;

	public class Wronganswer  extends Activity {
		Button save, menu;
		EditText name;
		Toast saveToast;
		
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_wrong_answer);
			
			save = (Button) findViewById (R.id.save);
			menu = (Button) findViewById (R.id.menu);
			name = (EditText) findViewById(R.id.name);
			saveToast = Toast.makeText(getBaseContext(), "Result saved", Toast.LENGTH_SHORT);	
		}
		
		private void writeToFile(String data) {
		    try {
		    	FileOutputStream fOut = openFileOutput("Scores.txt", MODE_APPEND);
		        OutputStreamWriter osw = new OutputStreamWriter(fOut);
		        osw.write(data);
		        osw.append("\n");
		        osw.flush();
		        osw.close();
		    }
		    catch (IOException e) {
		    	e.printStackTrace();
		    } 
		}
		
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.save:
				if (name.getText().toString().matches("")){
					saveToast.setText("Can't save without name!");
					saveToast.show();
				}else{
					saveToast.setText("Result saved");
					saveToast.show();
					finish();
				}
				break;
			case R.id.menu:
				finish();
				break;
			}
		}
	}


