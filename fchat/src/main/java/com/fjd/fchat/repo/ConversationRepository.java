package com.fjd.fchat.repo;

import com.fjd.fchat.bo.Conversation;
import org.springframework.data.repository.CrudRepository;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {

}