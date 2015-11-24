package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * AppEventBroker
 */
public class AppEventBroker 
    extends BroadcastReceiver
    implements AppEventListener
{
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
        else if (AppEvent.SIGN_IN.name().equals(action))
        {
            signIn((SignedInUser)user);
        }
        else if (AppEvent.USER_ROLE_RECEIVED.name().equals(action))
        {
            userRoleReceived((SignedInUser)user);
        }
    }
    
    @Override
    public void signIn(SignedInUser user)
    {
        
    }
    
    @Override
    public void userRoleReceived(SignedInUser user)
    {
        
    }
}
