package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

/**
 * UserEventListener
 */
public interface UserEventListener
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
