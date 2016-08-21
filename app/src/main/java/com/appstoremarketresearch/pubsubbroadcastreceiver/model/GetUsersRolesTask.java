package com.appstoremarketresearch.pubsubbroadcastreceiver.model;

import android.content.Context;
import android.os.AsyncTask;

import com.appstoremarketresearch.pubsubbroadcastreceiver.event.AppEventPublisher;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser.UserRole;

/**
 * GetUsersRolesTask
 */
public class GetUsersRolesTask extends AsyncTask<Void, Void, SignedInUser>
{
    private Context context;
    private SignedInUser user;
    
    /**
     * GetUsersRolesTask
     */
    public GetUsersRolesTask(
        Context context,
        SignedInUser user)
    {
        this.context = context;
        this.user = user;
    }
    
    @Override
    protected SignedInUser doInBackground(Void... arg0)
    {
        int random = (int)Math.round(Math.random() * 3);
        
        switch (random)
        {
        case 0:
            user.addUserRole(UserRole.ADMIN);
            break;
            
        case 1:
            user.addUserRole(UserRole.EDITOR);
            break;
            
        case 2:
            user.addUserRole(UserRole.READER);
            break;
            
        default:
            user.addUserRole(UserRole.EDITOR);
            user.addUserRole(UserRole.READER);
            break;
        }
        
        return this.user;
    }
    
    /**
     * onPostExecute
     */
    protected void onPostExecute(SignedInUser user) 
    {
        AppEventPublisher.notifyReceivedUserRoles(context, user);
    }
}
