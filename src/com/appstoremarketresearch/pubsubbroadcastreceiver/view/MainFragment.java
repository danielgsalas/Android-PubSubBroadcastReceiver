package com.appstoremarketresearch.pubsubbroadcastreceiver.view;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.appstoremarketresearch.pubsubbroadcastreceiver.R;
import com.appstoremarketresearch.pubsubbroadcastreceiver.event.AppEventBroker;
import com.appstoremarketresearch.pubsubbroadcastreceiver.event.UserEventListener;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignInTask;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignedInUser;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.UserCredentials;

/**
 * MainFragment
 */
public class MainFragment 
    extends Fragment
    implements UserEventListener
{
    private View topLevelView;
    
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        
        topLevelView = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText editText = (EditText)topLevelView.findViewById(R.id.username);
        
        Button button = (Button)topLevelView.findViewById(R.id.sign_in_button);
        button.setOnClickListener(new View.OnClickListener()
        {            
            @Override
            public void onClick(View view)
            {
                String username = editText.getText().toString();
                
                if (username != null && !username.isEmpty())
                {
                    UserCredentials credentials = new UserCredentials();
                    credentials.setUsername(username);

                    Context context = getActivity();
                    SignInTask task = new SignInTask(context, credentials);
                    task.execute();
                    
                    // clear the sign in greeting
                    int id = R.id.sign_in_greeting;
                    TextView signInGreetingView = (TextView) topLevelView.findViewById(id);
                    signInGreetingView.setText("");
                    
                    // clear the user role message
                    id = R.id.user_role_message;
                    TextView userRoleMessageView = (TextView) topLevelView.findViewById(id);
                    userRoleMessageView.setText("");
                }
            }
        });        
        
        // register for event notification
        AppEventBroker.register(this);
        
        return topLevelView;
    }
    
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        
        // unregister from event notification
        AppEventBroker.unregister(this);
    }
    
    @Override
    public void signedIn(SignedInUser user)
    {
        int id = R.id.sign_in_greeting;
        TextView signInGreetingView = (TextView) topLevelView.findViewById(id);
        
        Resources res = getActivity().getResources();
        String message = null;
                
        if (user != null && user.getAccessToken() != null)
        {
            message = res.getString(R.string.sign_in_success_message);
            message = String.format(message, user.getCredentials().getUsername());
        }
        else
        {
            message = res.getString(R.string.sign_in_failure_message);
        }
        
        signInGreetingView.setText(message);
    }
    
    @Override
    public void receivedUserRoles(SignedInUser user)
    {
        Resources res = getActivity().getResources();
        String message = res.getString(R.string.user_role_message);
        message = String.format(message, user.getUserRoles().toString());        
        message = message.replace("[", "");
        message = message.replace("]", "");
        
        int id = R.id.user_role_message;
        TextView userRoleMessageView = (TextView) topLevelView.findViewById(id);
        userRoleMessageView.setText(message);
    }
}
