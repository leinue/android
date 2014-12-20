package com.example.transferdatatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class info extends ActionBarActivity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		final Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		TextView user=(TextView)findViewById(R.id.textView1);
		user.setText(bundle.getString("user"));
		
		Button back=(Button)findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				setResult(0x717,intent);
				finish();
			}
		});
	}
}
