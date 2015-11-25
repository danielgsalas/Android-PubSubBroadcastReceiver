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
        intent.setAction(UserEventType.SIGNED_IN.name());
        
        String key = SignedInUser.class.getSimpleName();
        intent.putExtra(key, user);
        
        context.sendBroadcast(intent);
    }
    
    /**
     * notifyReceivedUserRoles
     */
    public static void notifyReceivedUserRoles(
        Context context, 
        SignedInUser user)
    {
        Intent intent = new Intent();
        intent.setAction(UserEventType.RECEIVED_USER_ROLES.name());
        
        String key = SignedInUser.class.getSimpleName();
        intent.putExtra(key, user);
        
        context.sendBroadcast(intent);
    }
}
