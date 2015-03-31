package com.slidenerd.exmples.five.cards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bharat.sumanth on 3/30/2015.
 */
public class NavigationDrawerFragment extends Fragment {
    private ActionBarDrawerToggle drawerToggle;
    RecyclerView navList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }




    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        RecyclerView navList = (RecyclerView) getActivity().findViewById(R.id.navigationList);
        navList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        navList.setLayoutManager(llm);
        ContactAdapter ca = new ContactAdapter(createList(30));
        navList.setAdapter(ca);


    }

    private List createList(int size) {

        List result = new ArrayList();
        for (int i=1; i <= size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = ContactInfo.NAME_PREFIX + i;
            ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";
            result.add(ci);

        }

        return result;
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

    public class ContactInfo {
        protected String name;
        protected String email;
        protected static final String NAME_PREFIX = "Name_";
        protected static final String EMAIL_PREFIX = "email_";
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vEmail;
        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.textView);
            vEmail = (TextView)  v.findViewById(R.id.textView2);

        }
    }


    public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

        private List<ContactInfo> contactList;

        public ContactAdapter(List<ContactInfo> contactList) {
            this.contactList = contactList;
        }

        @Override
        public int getItemCount() {
            return contactList.size();
        }


        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.card_view, viewGroup, false);

            return new ContactViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(NavigationDrawerFragment.ContactViewHolder contactViewHolder, int i) {
            ContactInfo ci = contactList.get(i);
            contactViewHolder.vName.setText(ci.name);
            contactViewHolder.vEmail.setText(ci.email);

        }


    }

}
