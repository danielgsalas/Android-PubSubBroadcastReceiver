package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

/**
 * AppEventListener
 */
public interface AppEventListener
{
    void signIn(SignedInUser user);
    
    void userRoleReceived(SignedInUser user);
}
