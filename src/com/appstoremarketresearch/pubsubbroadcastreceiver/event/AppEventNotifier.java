package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import java.util.HashSet;
import java.util.Set;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

/**
 * AppEventNotifier
 */
public class AppEventNotifier 
    extends BroadcastReceiver
    implements UserEventListener
{
    private static Set<UserEventListener> userEventListeners = 
        new HashSet<UserEventListener>();
    
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        
        String key = SignedInUser.class.getSimpleName();
        Object user = extras.getSerializable(key);

        if (user == null)
        {
            // ignore null SignedInUser
        }
        else if (UserEventType.SIGNED_IN.name().equals(action))
        {
            onSignedIn((SignedInUser)user);
        }
        else if (UserEventType.RECEIVED_USER_ROLES.name().equals(action))
        {
            onReceivedUserRoles((SignedInUser)user);
        }
    }
    
    @Override
    public void onSignedIn(SignedInUser user)
    {
        for (UserEventListener listener : userEventListeners)
        {
            listener.onSignedIn(user);
        }
    }
    
    @Override
    public void onReceivedUserRoles(SignedInUser user)
    {
        for (UserEventListener listener : userEventListeners)
        {
            listener.onReceivedUserRoles(user);
        }
    }    
    
    /**
     * Register for event notification
     */
    public static void register(UserEventListener listener)
    {
        if (listener != null)
        {
            userEventListeners.add(listener);
        }
    }
    
    /**
     * Unregister from event notification
     */
    public static void unregister(UserEventListener listener)
    {
        if (listener != null)
        {
            userEventListeners.remove(listener);
        }
    }
}
