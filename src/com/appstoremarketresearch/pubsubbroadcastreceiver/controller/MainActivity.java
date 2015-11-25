package com.appstoremarketresearch.pubsubbroadcastreceiver.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.appstoremarketresearch.pubsubbroadcastreceiver.R;
import com.appstoremarketresearch.pubsubbroadcastreceiver.event.AppEventBroker;
import com.appstoremarketresearch.pubsubbroadcastreceiver.event.UserEventListener;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.GetUsersRolesTask;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

/**
 * MainActivity
 */
public class MainActivity 
    extends Activity
    implements UserEventListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // register for event notification
        AppEventBroker.register(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        
        // unregister from event notification
        AppEventBroker.unregister(this);
    }
    
    @Override
    public void signedIn(SignedInUser user)
    {
        if (user != null && user.getAccessToken() != null)
        {
            GetUsersRolesTask task = new GetUsersRolesTask(this, user);
            task.execute();
        }
    }
    
    @Override
    public void receivedUserRoles(SignedInUser user)
    {
        // do nothing
    }
}
