package com.slidenerd.exmples.five.cards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by bharat.sumanth on 3/30/2015.
 */
public class NavigationDrawerFragment extends Fragment {
    private ActionBarDrawerToggle drawerToggle;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }


    public void setSync(DrawerLayout drawerLayout,Toolbar toolbar) {

        //create a drawer toggle to maintain sync btw toolbar and navigation drawer and also to use it as drawer listener.

        drawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
                Toast.makeText(getActivity(),"drawer opened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
                Toast.makeText(getActivity(),"drawer closed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

            }
        };
        //pass drawer toggle obj as listener
        drawerLayout.setDrawerListener(drawerToggle);
        //setting menu icon and its animation
        drawerToggle.syncState();

    }
}
