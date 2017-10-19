package com.fjd.fchatandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fjd.fchatandroid.data.DataProvider;
import com.fjd.fchatandroid.model.Conversation;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

@SuppressWarnings("FieldCanBeLocal")
public class ConversationActivity extends AppCompatActivity {

    private TextView tvName, tvDescription, tvPrice;
    private ImageView itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        //String conversationId = getIntent().getExtras().getString(ConversationItemAdapter.CONVERSATION_ID_KEY);
        //Conversation conversation = DataProvider.conversationMap.get(conversationId);
       // Toast.makeText(this,"Received item"+conversation.getName(),Toast.LENGTH_SHORT).show();

        Conversation item = getIntent().getExtras().getParcelable(ConversationItemAdapter.CONVERSATION_KEY);
        if (item == null) {
            throw new AssertionError("Null data item received!");
        }

        tvName = (TextView) findViewById(R.id.tvItemName);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        itemImage = (ImageView) findViewById(R.id.itemImage);

        tvName.setText(item.getName());
        tvDescription.setText(item.getName());

        //NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        //tvPrice.setText(nf.format(item.getId()));

        InputStream inputStream = null;
        try {
            String imageFile = item.getAvatarName();
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            itemImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}