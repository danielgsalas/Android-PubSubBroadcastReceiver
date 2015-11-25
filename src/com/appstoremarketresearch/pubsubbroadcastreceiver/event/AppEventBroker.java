package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import java.util.HashSet;
import java.util.Set;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

/**
 * AppEventBroker
 */
public class AppEventBroker 
    extends BroadcastReceiver
    implements AppEventListener
{
    private static Set<AppEventListener> appEventListeners;
    
    /**
     * initializeCollection
     */
    private static void initializeCollection()
    {
        if (appEventListeners == null)
        {
            appEventListeners = new HashSet<AppEventListener>();
        }
    }
    
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        
        String key = SignedInUser.class.getSimpleName();
        Object user = extras.getSerializable(key);
        
        initializeCollection();
        
        if (user == null)
        {
            // ignore null SignedInUser
        }
        else if (AppEvent.SIGNED_IN.name().equals(action))
        {
            signedIn((SignedInUser)user);
        }
        else if (AppEvent.RECEIVED_USER_ROLES.name().equals(action))
        {
            receivedUserRoles((SignedInUser)user);
        }
    }
    
    /**
     * Register for event notification
     */
    public static void register(AppEventListener listener)
    {
        initializeCollection();
        
        if (listener != null)
        {
            appEventListeners.add(listener);
        }
    }
    
    /**
     * Unregister from event notification
     */
    public static void unregister(AppEventListener listener)
    {
        initializeCollection();
        
        if (listener != null)
        {
            appEventListeners.remove(listener);
        }
    }
    
    @Override
    public void signedIn(SignedInUser user)
    {
        for (AppEventListener listener : appEventListeners)
        {
            listener.signedIn(user);
        }
    }
    
    @Override
    public void receivedUserRoles(SignedInUser user)
    {
        for (AppEventListener listener : appEventListeners)
        {
            listener.receivedUserRoles(user);
        }
    }
}
