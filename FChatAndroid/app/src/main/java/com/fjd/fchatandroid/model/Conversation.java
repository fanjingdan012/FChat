package com.fjd.fchatandroid.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class Conversation implements Parcelable {
    private String id;
    private String name;
    private String avatarName;

    public Conversation() {
    }

    public Conversation(String name) {
        this.name = name;
    }

    public Conversation(String id, String name,String avatarName) {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        this.id = id;
        this.name = name;
        this.avatarName=avatarName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.avatarName);
    }

    protected Conversation(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.avatarName = in.readString();
    }

    public static final Parcelable.Creator<Conversation> CREATOR = new Parcelable.Creator<Conversation>() {
        @Override
        public Conversation createFromParcel(Parcel source) {
            return new Conversation(source);
        }

        @Override
        public Conversation[] newArray(int size) {
            return new Conversation[size];
        }
    };
}
