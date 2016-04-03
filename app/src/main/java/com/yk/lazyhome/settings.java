package com.yk.lazyhome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class settings extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    public static final String savedsettings = "Settings";
    public String ipaddress = "ipaddress";
    public String ipport = "ipport";
    String getIpaddress;
    String getIpport;
    public EditText ipaddress_text;
    public EditText ipport_text;
    public TextView show_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_settings);
        setSupportActionBar(toolbar);

        ipaddress_text = (EditText)findViewById(R.id.ServerIP);
        ipport_text = (EditText)findViewById(R.id.Port);

        sharedPreferences = getSharedPreferences(savedsettings, MODE_PRIVATE);
        getIpaddress = sharedPreferences.getString(ipaddress, "192.168.1.1");
        getIpport = sharedPreferences.getString(ipport, "1111");

        ipaddress_text.setText(getIpaddress);
        ipport_text.setText(getIpport);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void testConnection(View view){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent = new Intent(this, MainActivity.class);
        switch (item.getItemId()){
            case R.id.action_settings_discard:
                finish();
                return true;
            case R.id.action_settings_save:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(ipaddress, ipaddress_text.getText().toString());
                editor.putString(ipport, ipport_text.getText().toString());
                editor.commit();
                Toast.makeText(this, "Settings saved", Toast.LENGTH_LONG).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
