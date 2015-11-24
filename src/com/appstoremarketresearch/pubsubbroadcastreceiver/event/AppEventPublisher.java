package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import android.content.Context;
import android.content.Intent;

import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

/**
 * AppEventPublisher
 */
public class AppEventPublisher
{
    /**
     * notifySignIn
     */
    public static void notifySignIn(
        Context context, 
        SignedInUser user)
    {
        Intent intent = new Intent();
        intent.setAction(AppEvent.SIGN_IN.name());
        
        String key = SignedInUser.class.getSimpleName();
        intent.putExtra(key, user);
        
        context.sendBroadcast(intent);
    }
    
    /**
     * notifyUserRoleReceived
     */
    public static void notifyUserRoleReceived(
        Context context, 
        SignedInUser user)
    {
        Intent intent = new Intent();
        intent.setAction(AppEvent.USER_ROLE_RECEIVED.name());
        
        String key = SignedInUser.class.getSimpleName();
        intent.putExtra(key, user);
        
        context.sendBroadcast(intent);
    }
}
