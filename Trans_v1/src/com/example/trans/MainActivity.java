package com.example.trans;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
	
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    
    
    //Database
    private static SQLiteDatabase database;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        
        DBHelper dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        
 //=============================================       
     // Reading all contacts
        Log.d("Reading: ", "Citeste toate traseele..");
        List<Trasee> trasee = dbHelper.getTrasee();    
        
        for (Trasee tr : trasee) {
            String log = "Numar traseu: "+tr.getNrt()+" , Durata traseu: " + tr.getDurata() +
            		" , Statie start: " + tr.getNrStStart() + " , Statie end: "
            		+ tr.getNrStEnd() + " , nrc: "+ tr.getNrc();
                // Writing trasee to log
        Log.d("Name: ", log);
//===============================================
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment fragmentSection = null;
        FragmentTransaction fragmentnTransaction = null;
        
    	// update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
        
        switch(position){
        	// load section1_home_fragment
            case 0:
            	System.out.println("===0===");
            	fragmentSection = new Section1HomeFragment();
                fragmentnTransaction = fragmentManager.beginTransaction();
                fragmentnTransaction.replace(R.id.container, fragmentSection);
                fragmentnTransaction.commit();
                break;
            
             // load section2    
            case 1:
            	System.out.println("===1===");
            	fragmentSection = new Section2TraseeFragment();
                fragmentnTransaction = fragmentManager.beginTransaction();
                fragmentnTransaction.replace(R.id.container, fragmentSection);
                fragmentnTransaction.commit();
                break;
                
            // load section3
            case 2:
            	System.out.println("===2===");
            	fragmentSection = new Section3OrarFragment();
                fragmentnTransaction = fragmentManager.beginTransaction();
                fragmentnTransaction.replace(R.id.container, fragmentSection);
                fragmentnTransaction.commit();
                break;
                
            // load section4                
            case 3:
            	System.out.println("===3===");
            	fragmentSection = new Section4SearchFragment();
                fragmentnTransaction = fragmentManager.beginTransaction();
                fragmentnTransaction.replace(R.id.container, fragmentSection);
                fragmentnTransaction.commit();
                break;            
            
            // load section5
            case 4:
            	System.out.println("===4===");
            	fragmentSection = new Section5ContactFragment();
                fragmentnTransaction = fragmentManager.beginTransaction();
                fragmentnTransaction.replace(R.id.container, fragmentSection);
                fragmentnTransaction.commit();
                break;
        }
        
    }

    
    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.section1_home);
                break;
            case 2:
                mTitle = getString(R.string.section2_trasee);
                break;
            case 3:
                mTitle = getString(R.string.section3_orar);
                break;
            case 4:
                mTitle = getString(R.string.section4_search);
                break;
            case 5:
                mTitle = getString(R.string.section5_contact);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu); 
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            return rootView;
//        }
//
//        @Override
//        public void onAttach(Activity activity) {
//            super.onAttach(activity);
//            ((MainActivity) activity).onSectionAttached(
//                    getArguments().getInt(ARG_SECTION_NUMBER));
//        }
//    }
//
}
