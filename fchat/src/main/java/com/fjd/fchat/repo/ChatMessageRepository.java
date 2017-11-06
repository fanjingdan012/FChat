package com.fjd.fchat.repo;

import com.fjd.fchat.bo.ChatMessage;
import com.fjd.fchat.bo.User;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

}