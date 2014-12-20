package com.example.startactivity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class DetailActivity extends ActionBarActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		
		Button e=(Button)findViewById(R.id.button1);
		e.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}
