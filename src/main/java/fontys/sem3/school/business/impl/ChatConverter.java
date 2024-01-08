package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.Chat;
import fontys.sem3.school.persistence.entity.ChatEntity;

public class ChatConverter {

    public static Chat convert(ChatEntity chatEntity) {
        return Chat.builder()
                .id(chatEntity.getId())
                .customerid(chatEntity.getCustomerid())  // Assuming UserEntity has a 'getName()' method
                .sellerid(chatEntity.getSellerid())      // Assuming UserEntity has a 'getName()' method
                .updatedAt(chatEntity.getUpdatedAt())
                .customername(chatEntity.getCustomerName())
                .sellername(chatEntity.getSellerName())
                .build();
    }


}


