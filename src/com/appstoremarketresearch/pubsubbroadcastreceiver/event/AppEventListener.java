package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

/**
 * AppEventListener
 */
public interface AppEventListener
{
    /**
     * signedIn
     */
    void signedIn(SignedInUser user);
    
    /**
     * receivedUserRole
     */
    void receivedUserRole(SignedInUser user);
}
