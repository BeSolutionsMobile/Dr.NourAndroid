package com.besolutions.drnour.Scenarios.ScenarioHome.Controller;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.besolutions.drnour.Scenarios.ScenarioAboutDrNour.Controller.About_DrNour;
import com.besolutions.drnour.Scenarios.ScenarioBookingReferralMe.Controller.Booking_Referral;
import com.besolutions.drnour.Scenarios.ScenarioContactUs.Controller.Contact_Us;
import com.besolutions.drnour.Scenarios.ScenarioFAQ.Controller.FAQ;
import com.besolutions.drnour.Scenarios.ScenarioGallery.Controller.Gallery;
import com.besolutions.drnour.Scenarios.ScenarioHome.Pattrens.NavigationDrawerCallbacks;
import com.besolutions.drnour.Scenarios.ScenarioHome.Pattrens.NavigationDrawerFragment;
import com.besolutions.drnour.R;
import com.besolutions.drnour.Scenarios.ScenarioMyBalance.Controller.My_Balance;
import com.besolutions.drnour.Scenarios.ScenarioPersonalInfo.Controller.Personal_Fragment;
import com.besolutions.drnour.Scenarios.ScenarioReferral.Controller.My_Referral;
import com.besolutions.drnour.Scenarios.ScenarioResevation.Controller.My_Reservation;
import com.besolutions.drnour.Scenarios.ScenarioReviews.Controller.Reviews;
import com.besolutions.drnour.Scenarios.ScenarioViewAllReservations.Controller.View_All_Reservation;


public class MainActivity extends AppCompatActivity
        implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    static private Toolbar mToolbar;
    static String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title="Dr Noor";
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.container,new View_All_Reservation());
        fr.commit();


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        if (position == 0) {
            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new Personal_Fragment());
            fr.commit();
        } else if (position == 1) {

            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new My_Reservation());
            fr.commit();

        } else if (position == 2) {

            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new My_Referral());
            fr.commit();

        } else if (position == 3) {
            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new Booking_Referral());
            fr.commit();

        } else if (position == 4) {

            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new My_Balance());
            fr.commit();

        } else if (position == 5) {

            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new About_DrNour());
            fr.commit();

        } else if (position == 6) {

            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new FAQ());
            fr.commit();

        } else if (position == 7) {
            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new Reviews());
            fr.commit();

        } else if (position == 8) {
            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new Gallery());
            fr.commit();

        } else {
            FragmentTransaction fr = this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.container,new Contact_Us());
            fr.commit();

        }
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
