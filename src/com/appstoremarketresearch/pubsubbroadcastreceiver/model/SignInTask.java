package com.appstoremarketresearch.pubsubbroadcastreceiver.model;

import android.content.Context;
import android.os.AsyncTask;

import com.appstoremarketresearch.pubsubbroadcastreceiver.event.AppEventPublisher;

/**
 * SignInTask
 */
public class SignInTask extends AsyncTask<Void, Void, SignedInUser>
{
    private Context context;
    private UserCredentials credentials;
    
    /**
     * SignInTask
     */
    public SignInTask(
        Context context,
        UserCredentials credentials)
    {
        this.context = context;
        this.credentials = credentials;
    }

    @Override
    protected SignedInUser doInBackground(Void... arg0)
    {
        try
        {
            // simulate the time to query a remote API
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }
        
        SignedInUser user = new SignedInUser();
        user.setCredentials(credentials);

        if (Math.random() > 0.33)
        {
            // success!
            user.setAccessToken("abc123");
        }

        return user;
    }
    
    /**
     * onPostExecute
     */
    protected void onPostExecute(SignedInUser user) 
    {
        AppEventPublisher.notifySignedIn(context, user);
    }
}
