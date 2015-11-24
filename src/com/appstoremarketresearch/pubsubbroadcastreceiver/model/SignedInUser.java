package com.appstoremarketresearch.pubsubbroadcastreceiver.model;

/**
 * SignedInUser
 */
public class SignedInUser
{
    private UserCredentials credentials;

    public UserCredentials getCredentials()
    {
        return credentials;
    }

    public void setCredentials(UserCredentials credentials)
    {
        this.credentials = credentials;
    }
}
