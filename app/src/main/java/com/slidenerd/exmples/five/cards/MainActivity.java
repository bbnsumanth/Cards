package com.slidenerd.exmples.five.cards;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment navDF = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        //with this navigation drawer basic setup is done
        //next,we want to set sync btw appbar and navigation drawer
        //this can be done directly here,but if we want to use same navigation drawer for many activities,
        // its better to write that code in navigation drawer fragment
        navDF.setSync(drawerLayout,toolbar);//we are passing toolbar and drawer layout obj from activity to navigation drawer fragment.




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
            Toast.makeText(this,"not yet done",Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.next){

            startActivity(new Intent(this,SubActivity1.class));

        }
        return super.onOptionsItemSelected(item);
    }
}
