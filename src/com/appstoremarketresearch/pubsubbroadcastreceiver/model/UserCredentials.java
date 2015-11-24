package com.appstoremarketresearch.pubsubbroadcastreceiver.model;

import java.io.Serializable;

/**
 * UserCredentials
 */
public class UserCredentials implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String username;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
