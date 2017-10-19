package com.fjd.fchatandroid.data;


import com.fjd.fchatandroid.model.Conversation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    public static List<Conversation> conversations;
    public static Map<String,Conversation> conversationMap;
    static {
        conversations = new ArrayList<>();
        conversationMap = new HashMap<>();


        addConversation(new Conversation(null, "Mixed Berry Tart",  "wbq.jpg"));

        addConversation(new Conversation(null, "Tropical Blue Smoothie",
               "football.jpg"));

        addConversation(new Conversation(null, "Pomegranate Iced Tea",  "mountain.jpg"));

        addConversation(new Conversation(null, "Café Latte", "pen.jpg"));
    }
    private static void addConversation(Conversation conversation){
        conversations.add(conversation);
        conversationMap.put(conversation.getId(),conversation);
    }
}
