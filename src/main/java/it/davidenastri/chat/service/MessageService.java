package it.davidenastri.chat.service;

import it.davidenastri.chat.mapper.IntentMapper;
import it.davidenastri.chat.mapper.IntentMessageMapper;
import it.davidenastri.chat.mapper.MessageMapper;
import it.davidenastri.chat.mapper.ReplyMapper;
import it.davidenastri.chat.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private MessageMapper messageMapper;
    private ReplyMapper replyMapper;
    private IntentMessageMapper intentMessageMapper;
    private IntentMapper intentMapper;

    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }

    public MessageService(MessageMapper messageMapper, ReplyMapper replyMapper, IntentMessageMapper intentMessageMapper
            , IntentMapper intentMapper) {
        this.messageMapper = messageMapper;
        this.replyMapper = replyMapper;
        this.intentMessageMapper = intentMessageMapper;
        this.intentMapper = intentMapper;
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say": {
                newMessage.setMessageText(chatForm.getMessageText());
            }
            case "Shout": {
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
            }
            case "Whisper": {
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
            }
        }
        messageMapper.insert(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getMessages();
    }

    //TODO:: get the msgId that contains the txtMsg;
    public Integer getMessagesId(String messageText) {
        return 1;
    }

    public Intent getIntentIDByMessageId(int messageId) {
        Intent intent = new Intent();
        IntentMessage intentMessage;
        intentMessage = intentMessageMapper.getIntentByMessageId(messageId);
        if (intentMessage != null)
            intent.setIntentId(intentMessage.getIntentid());
        intent = intentMapper.getIntentById(intent.getIntentId());
        return intent;
    }

    public List<Reply> getChatReplies(int msgId) {
        Intent intent = getIntentIDByMessageId(msgId);
        if (intent != null && intent.getIntentId() != null)
            return replyMapper.getRepliesByIntentId(intent.getIntentId());
        else return new ArrayList<>();
    }
}
