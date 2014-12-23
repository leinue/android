package com.example.querycontact;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	private String[] columns={Contacts._ID,Contacts.DISPLAY_NAME,Phone.NUMBER,Phone.CONTACT_ID};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView tv=(TextView)findViewById(R.id.result);
        tv.setText(getQueryData());
    }
    
    private String getQueryData(){
    	StringBuilder sb=new StringBuilder();//ÓÃÓÚ±£´æ×Ö·û´®
    	ContentResolver cr=getContentResolver();
    	Cursor cursor=cr.query(Contacts.CONTENT_URI, null, null, null, null);
    	while(cursor.moveToNext()){
    		int idIndex=cursor.getColumnIndex(columns[0]);
    		int displayNameIndex=cursor.getColumnIndex(columns[1]);
    		int id=cursor.getInt(idIndex);
    		String displayName=cursor.getString(displayNameIndex);
    		Cursor phone=cr.query(Phone.CONTENT_URI,null,columns[3]+"="+id,null,null);
    		while(phone.moveToNext()){
    			int phoneNumIndex=phone.getColumnIndex(columns[2]);
    			String phoneNum=phone.getString(phoneNumIndex);
    			sb.append(displayName+":"+phoneNum+"\r\n");
    		}
    	}
    	cursor.close();
    	return sb.toString();
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
