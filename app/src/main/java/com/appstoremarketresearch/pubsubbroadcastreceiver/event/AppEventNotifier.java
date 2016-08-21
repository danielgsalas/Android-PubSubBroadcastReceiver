package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

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
    private static AbstractSet<UserEventListener> userEventListeners = 
        new CopyOnWriteArraySet<UserEventListener>();
    
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
     * Subscribe for event notification
     */
    public static void subscribe(UserEventListener listener)
    {
        if (listener != null)
        {
            userEventListeners.add(listener);
        }
    }
    
    /**
     * Unsubscribe from event notification
     */
    public static void unsubscribe(UserEventListener listener)
    {
        if (listener != null)
        {
            userEventListeners.remove(listener);
        }
    }
    
    /**
     * Unsubscribe all listeners of the input subclass type
     */
    public static void unsubscribeByType(UserEventListener listener)
    {
        if (listener != null)
        {
            Set<UserEventListener> listenersToRemove = new HashSet<UserEventListener>();
            Class c = listener.getClass();
            
            for (UserEventListener subscribedListener : userEventListeners) 
            {
                if (c.equals(subscribedListener.getClass()))
                {
                    listenersToRemove.add(subscribedListener);
                }
            }

            userEventListeners.removeAll(listenersToRemove);
        }
    }
}
