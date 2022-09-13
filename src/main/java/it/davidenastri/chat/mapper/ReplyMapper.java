package it.davidenastri.chat.mapper;

import it.davidenastri.chat.model.ChatMessage;
import it.davidenastri.chat.model.Reply;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Select("SELECT * FROM REPLY")
    List<Reply> getReplies();
    @Select("SELECT * FROM REPLY where replyid =#{id} ")
    List<Reply> getRepliesByIntentId(@Param("id") int id);
}