package com.example.qqlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends ActionBarActivity  {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		Button submit=(Button)findViewById(R.id.btn);
		submit.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent(loginActivity.this,MainActivity.class);
				Bundle bundle=new Bundle();
				String nickName=((EditText)findViewById(R.id.user)).getText().toString();
				bundle.putString("uset", nickName);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		Button logout=(Button)findViewById(R.id.ex);
		logout.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				finish();
			}
		});
	}
}
