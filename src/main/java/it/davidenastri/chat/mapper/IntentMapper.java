package it.davidenastri.chat.mapper;

import it.davidenastri.chat.model.ChatMessage;
import it.davidenastri.chat.model.Intent;
import it.davidenastri.chat.model.IntentMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IntentMapper {
    @Select("SELECT * FROM INTENT where intentid = #{id}")
    Intent getIntentById(@Param("id") int id);
}