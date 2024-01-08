package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.Message;
import fontys.sem3.school.persistence.entity.MessageEntity;

public class MessageConverter {

    public static Message convert(MessageEntity messageEntity) {


        return Message.builder()
                .id(messageEntity.getId())
                .senderid(messageEntity.getSenderid())
                .content(messageEntity.getContent())
                .timestamp(messageEntity.getTimestamp())
                .chatid(messageEntity.getChatid())
                .build();
    }


}