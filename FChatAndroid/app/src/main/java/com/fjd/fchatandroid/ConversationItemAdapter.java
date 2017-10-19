package com.fjd.fchatandroid;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.fjd.fchatandroid.model.Conversation;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ConversationItemAdapter extends RecyclerView.Adapter<ConversationItemAdapter.ViewHolder> {

    public static final String CONVERSATION_ID_KEY = "conversation_id_key";
    public static final String CONVERSATION_KEY = "conversation_key";
    private List<Conversation> conversations;
    private Context mContext;

    public ConversationItemAdapter(Context context, List<Conversation> conversations) {
        this.mContext = context;
        this.conversations = conversations;
    }

    @Override
    public ConversationItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.conversation_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ConversationItemAdapter.ViewHolder holder, int position) {
        final Conversation conversation = conversations.get(position);

        try {
            holder.tvName.setText(conversation.getName());
            String imageFile = conversation.getAvatarName();
            InputStream inputStream = mContext.getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(mContext, "You selected " + conversation.getName(), Toast.LENGTH_SHORT).show();
               // String conversationId = conversation.getId();
                Intent intent = new Intent(mContext,ConversationActivity.class);
                intent.putExtra(CONVERSATION_KEY,conversation);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return conversations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public ImageView imageView;
    public View mView;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.conversationNameText);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            mView=itemView;
        }
    }
}