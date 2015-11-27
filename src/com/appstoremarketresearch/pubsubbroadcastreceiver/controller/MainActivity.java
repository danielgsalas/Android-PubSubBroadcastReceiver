package com.appstoremarketresearch.pubsubbroadcastreceiver.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.appstoremarketresearch.pubsubbroadcastreceiver.R;
import com.appstoremarketresearch.pubsubbroadcastreceiver.event.AppEventNotifier;
import com.appstoremarketresearch.pubsubbroadcastreceiver.event.UserEventListener;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.GetUsersRolesTask;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignInTask;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.UserCredentials;

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
        AppEventNotifier.register(this);
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
        AppEventNotifier.unregister(this);
    }
    
    /**
     * Handle sign-in request from fragment_main.xml
     */
    public void signIn(View view)
    {
        EditText editText = (EditText)this.findViewById(R.id.username);
        String username = editText.getText().toString();
        
        if (username != null && !username.isEmpty())
        {
            UserCredentials credentials = new UserCredentials();
            credentials.setUsername(username);

            SignInTask task = new SignInTask(this, credentials);
            task.execute();
            
            // clear the sign in greeting
            int id = R.id.sign_in_greeting;
            TextView signInGreetingView = (TextView) this.findViewById(id);
            signInGreetingView.setText("");
            
            // clear the user role message
            id = R.id.user_role_message;
            TextView userRoleMessageView = (TextView) this.findViewById(id);
            userRoleMessageView.setText("");
        }
    }
    
    @Override
    public void onSignedIn(SignedInUser user)
    {
        if (user != null && user.getAccessToken() != null)
        {
            GetUsersRolesTask task = new GetUsersRolesTask(this, user);
            task.execute();
        }
    }
    
    @Override
    public void onReceivedUserRoles(SignedInUser user)
    {
        // do nothing        
    }
}
