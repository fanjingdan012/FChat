package com.fjd.fchat.api.v1.service;

import com.fjd.fchat.bo.Conversation;
import com.fjd.fchat.bo.User;
import com.fjd.fchat.repo.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Conversations")
public class ConversationController {
    @Autowired
    private ConversationRepository conversationRepository;


}
