package com.appstoremarketresearch.pubsubbroadcastreceiver.model;

import android.os.AsyncTask;

/**
 * SignInTask
 */
public class SignInTask extends AsyncTask<Void, Void, SignedInUser>
{
    private UserCredentials credentials;
    
    /**
     * SignInTask
     */
    public SignInTask(UserCredentials credentials)
    {
        this.credentials = credentials;
    }

    @Override
    protected SignedInUser doInBackground(Void... arg0)
    {
        try
        {
            // simulate the time to query a database or API
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        SignedInUser user = new SignedInUser();
        user.setCredentials(credentials);
        return user;
    }
    
    /**
     * onPostExecute
     */
    protected void onPostExecute(SignedInUser user) 
    {
        
    }
}
