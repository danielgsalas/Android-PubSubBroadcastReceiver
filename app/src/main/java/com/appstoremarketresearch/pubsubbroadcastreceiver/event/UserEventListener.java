package com.appstoremarketresearch.pubsubbroadcastreceiver.event;

import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;

/**
 * UserEventListener
 */
public interface UserEventListener
{
    /**
     * onSignedIn
     */
    void onSignedIn(SignedInUser user);
    
    /**
     * onReceivedUserRoles
     */
    void onReceivedUserRoles(SignedInUser user);
}
