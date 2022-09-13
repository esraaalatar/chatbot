package it.davidenastri.chat.mapper;

import it.davidenastri.chat.model.ChatMessage;
import it.davidenastri.chat.model.IntentMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IntentMessageMapper {
    @Select("SELECT * FROM INTENT_MESSAGE  WHERE msgId = #{msgId}")
    IntentMessage getIntentByMessageId(@Param("msgId") int msgId);

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage chatMessage);
}