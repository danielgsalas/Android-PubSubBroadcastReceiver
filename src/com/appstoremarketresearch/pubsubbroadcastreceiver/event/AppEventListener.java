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
     * receivedUserRoles
     */
    void receivedUserRoles(SignedInUser user);
}
