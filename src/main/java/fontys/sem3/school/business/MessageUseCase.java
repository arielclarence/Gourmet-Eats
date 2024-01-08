package fontys.sem3.school.business;

import fontys.sem3.school.domain.*;

import java.util.Optional;

public interface MessageUseCase {
    CreateMessageResponse createMessage(CreateMessageRequest request);

    GetMessagesResponse getMessagesbyChatid(long ChatId);

}
