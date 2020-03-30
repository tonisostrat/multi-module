package org.example.core;

import org.example.data.models.Message;
import org.example.data.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoreService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final MessageRepository messages;

    public CoreService(MessageRepository messages) {
        log.info(getClass() + " initialized");

        this.messages = messages;
    }

    public List<Message> getAllMessages() {
        log.info("Returning all messages");

        return this.messages.findAll();
    }

    public Optional<Message> getMessage(Long id) {
        log.info("Returning message with ID {}", id);

        return this.messages.findById(id);
    }

    public Message createMessage(String content) {
        log.info("Creating new message with content [{}]", content);

        final Message message = new Message();

        message.setContent(content);

        this.messages.save(message);

        return message;
    }
}
