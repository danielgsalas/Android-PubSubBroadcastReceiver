package com.appstoremarketresearch.pubsubbroadcastreceiver.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.appstoremarketresearch.pubsubbroadcastreceiver.R;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.SignInTask;
import com.appstoremarketresearch.pubsubbroadcastreceiver.model.UserCredentials;

/**
 * MainFragment
 */
public class MainFragment extends Fragment
{
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        
        View topLevelView = inflater.inflate(R.layout.fragment_main, container, false);
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
                }
            }
        });
        
        return topLevelView;
    }
}
