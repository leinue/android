package com.example.accountsoft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.accountsoft.dao.PwdDAO;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnClose=(Button)findViewById(R.id.button2);
		btnClose.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				finish();
			}
		});
		
		final EditText txtlogin=(EditText)findViewById(R.id.editText1);
		Button btnLogin=(Button)findViewById(R.id.button1);
		btnLogin.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent(MainActivity.this,MainMenu.class);
				PwdDAO pwdDAO=new PwdDAO(MainActivity.this);
				if((pwdDAO.getCount()==0 | pwdDAO.find().getPassword().isEmpty()) && txtlogin.getText().toString()){
					startActivity(intent);
				}else{
					if((pwdDAO.find().getPassword().equals(txtlogin.getText().toString()))){
						startActivity(intent);
					}else{
						Toast.makeText(MainActivity.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
		txtlogin.setText("");
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
