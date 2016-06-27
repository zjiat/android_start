package com.example.filepersistecetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends Activity {

	private EditText edit;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText)findViewById(R.id.edit);
        String inputText = load();
        if (!TextUtils.isEmpty(inputText)) {
			edit.setText(inputText);
			
		}
    }
    
    public String load()
    {
    	FileInputStream in = null;
    	BufferedReader reader = null;
    	StringBuilder contentBuilder = new StringBuilder();
    	try {
			in = openFileInput("data");
			reader = new BufferedReader(new InputStreamReader(in));
			String lineString  = "";
			while ( (lineString = reader.readLine()) != null )
			{
				contentBuilder.append(lineString);
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
			
		}
    	
    	return contentBuilder.toString();
    }

    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	String inputText = edit.getText().toString();
    	save(inputText);
    }
    
    public void save(String inputText)
    {
    	FileOutputStream outputStream = null;
    	BufferedWriter writer = null;
    	try {
			outputStream = openFileOutput("data", Context.MODE_PRIVATE);
			writer = new BufferedWriter(new OutputStreamWriter(outputStream));
			writer.write(inputText);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
