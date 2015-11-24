package com.appstoremarketresearch.pubsubbroadcastreceiver.model;

import java.io.Serializable;

/**
 * SignedInUser
 */
public class SignedInUser implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String accessToken;
    private UserCredentials credentials;
    private UserRole userRole;
    
    public enum UserRole { ADMIN, EDITOR, READER };    

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public UserCredentials getCredentials()
    {
        return credentials;
    }

    public void setCredentials(UserCredentials credentials)
    {
        this.credentials = credentials;
    }

    public UserRole getUserRole()
    {
        return userRole;
    }

    public void setUserRole(UserRole userRole)
    {
        this.userRole = userRole;
    }
}
