package com.example.autocompletecontactlist;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;


public class MainActivity extends ActionBarActivity {

	private String[] columns=new String[]{Contacts._ID,Contacts.DISPLAY_NAME};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver resolver=getContentResolver();
        Cursor cursor=resolver.query(Contacts.CONTENT_URI, columns, null, null, null);
        ContactListAdapter adapter=new ContactListAdapter(this,cursor);
        AutoCompleteTextView tv=(AutoCompleteTextView)findViewById(R.id.edit);
        tv.setAdapter(adapter);
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

