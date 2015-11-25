package com.appstoremarketresearch.pubsubbroadcastreceiver.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * SignedInUser
 */
public class SignedInUser implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String accessToken;
    private UserCredentials credentials;
    
    public enum UserRole { ADMIN, EDITOR, READER };
    
    private Set<UserRole> userRoles = new HashSet<UserRole>();

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

    public Set<UserRole> getUserRoles()
    {
        if (userRoles == null)
        {
            userRoles = new HashSet<UserRole>();
        }
        
        return userRoles;
    }

    public void addUserRole(UserRole userRole)
    {
        if (userRoles == null)
        {
            userRoles = new HashSet<UserRole>();
        }
        
        userRoles.add(userRole);
    }
}
