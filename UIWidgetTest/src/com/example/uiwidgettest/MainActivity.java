package com.example.uiwidgettest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{

	private Button button, buttonProButton, 
					buttonProGo, buttonAlertDialog,
					buttonProDialog;
	private EditText editText;
	private ImageView imageView;
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button);
		buttonProButton = (Button) findViewById(R.id.button_progress_vis);
		buttonProGo = (Button) findViewById(R.id.button_progress_go);
		buttonAlertDialog = (Button) findViewById(R.id.button_alertdialog);
		buttonProDialog = (Button) findViewById(R.id.button_prodialog);
		editText = (EditText) findViewById(R.id.edit_Text);
		imageView = (ImageView) findViewById(R.id.image_View);
		progressBar = (ProgressBar) findViewById(R.id.progress_Bar);
		button.setOnClickListener(this); 
		buttonProButton.setOnClickListener(this);
		buttonProGo.setOnClickListener(this);
		buttonAlertDialog.setOnClickListener(this);
		buttonProDialog.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button:
//			String inputTextString = editText.getText().toString();
//			Toast.makeText(MainActivity.this, inputTextString, Toast.LENGTH_SHORT).show();
			
			imageView.setImageResource(R.drawable.music);
			
			break;
			
		case R.id.button_progress_vis:
			//Log.d("ProgressBAR", "Enter");
			if (progressBar.getVisibility() == View.GONE) {
				progressBar.setVisibility(View.VISIBLE);
			}
			else {
				progressBar.setVisibility(View.GONE);
			}
			
			break;
		case R.id.button_progress_go:
			int progress = progressBar.getProgress();
			progress += 10;
			progressBar.setProgress(progress);
			break;
			
		case R.id.button_alertdialog:
			AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
			dialog.setTitle("This is Dialog");
			dialog.setMessage("Something important.");
			dialog.setCancelable(false);
			dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			
			dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			
			dialog.show();
			
			break;
			
		case R.id.button_prodialog:
			ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setTitle("This is ProgressDialog");
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(true);
			progressDialog.show();
			break;

		default:
			break;
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
