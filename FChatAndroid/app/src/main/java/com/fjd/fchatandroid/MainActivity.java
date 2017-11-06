package com.fjd.fchatandroid;

import android.app.Instrumentation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fjd.fchatandroid.data.DataProvider;
import com.fjd.fchatandroid.model.Conversation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MY_GLOBAL_PREFS = "my_global_prefs";
    private TextView mTextMessage;

    private List<Conversation> conversations = DataProvider.conversations;
    private List<String> conversationNames = new ArrayList<>();

    private static final Integer SIGNIN_REQUEST = 1002;

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_me:
                    startLoginActivity();
                    mTextMessage.setText(R.string.title_me);
                    return true;
            }
            return false;
        }

    };

    public void startLoginActivity(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivityForResult(intent,SIGNIN_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK &&requestCode == SIGNIN_REQUEST){
            String email = data.getStringExtra(LoginActivity.EMAIL_KEY);
            Toast.makeText(this,"You login as "+email,Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = getSharedPreferences(MY_GLOBAL_PREFS,MODE_PRIVATE).edit();
            editor.putString(LoginActivity.EMAIL_KEY,email);
            editor.apply();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        for(Conversation conversation:conversations){
            conversationNames.add(conversation.getName());
        }

        Collections.sort(conversationNames);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,android.R.layout.simple_list_item_1,conversationNames
//
//        );
        ConversationItemAdapter adapter = new ConversationItemAdapter(this,conversations);
        RecyclerView listView = (RecyclerView)findViewById(R.id.rvConversations);
        listView.setAdapter(adapter);

    }

}
