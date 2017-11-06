package com.fjd.fchat.api.v1.service;

import com.fjd.fchat.repo.ChatMessageRepository;
import com.fjd.fchat.repo.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/ChatMessages")
public class ChatMessageController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

}
