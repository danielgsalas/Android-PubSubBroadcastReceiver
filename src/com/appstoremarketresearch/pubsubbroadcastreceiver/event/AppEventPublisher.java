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
     * notifySignedIn
     */
    public static void notifySignedIn(
        Context context, 
        SignedInUser user)
    {
        Intent intent = new Intent();
        intent.setAction(AppEvent.SIGNED_IN.name());
        
        String key = SignedInUser.class.getSimpleName();
        intent.putExtra(key, user);
        
        context.sendBroadcast(intent);
    }
    
    /**
     * notifyReceivedUserRole
     */
    public static void notifyReceivedUserRole(
        Context context, 
        SignedInUser user)
    {
        Intent intent = new Intent();
        intent.setAction(AppEvent.RECEIVED_USER_ROLE.name());
        
        String key = SignedInUser.class.getSimpleName();
        intent.putExtra(key, user);
        
        context.sendBroadcast(intent);
    }
}
