package com.yk.lazyhome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public static final String savedsettings = "Settings";
    public String ipaddress = "ipaddress";
    public String ipport = "ipport";
    public String getIpaddress;
    public String getIpport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Typeface bebasBold = Typeface.createFromAsset(getAssets(), "fonts/bebasNeue_Bold.ttf");
        Typeface bebasLight = Typeface.createFromAsset(getAssets(), "fonts/bebasNeue_Light.ttf");
        Typeface bebasRegular = Typeface.createFromAsset(getAssets(), "fonts/bebasNeue_Regular.ttf");

        TextView toolbar_Lazy = (TextView) findViewById(R.id.toolbar_Lazy);
        toolbar_Lazy.setTypeface(bebasBold);
        TextView toolbar_Home = (TextView) findViewById(R.id.toolbar_Home);
        toolbar_Home.setTypeface(bebasLight);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(savedsettings, MODE_PRIVATE);
                getIpaddress = sharedPreferences.getString(ipaddress, "");
                getIpport = sharedPreferences.getString(ipport, "");
                Snackbar.make(view, getIpaddress + ":" + getIpport , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(this, settings.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    Snackbar.make(this.findViewById(R.id.action_settings), "Pressed", Snackbar.LENGTH_SHORT).show();
        //    return true;
        //}


    }
}
