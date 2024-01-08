package fontys.sem3.school.business;

import fontys.sem3.school.domain.*;

public interface ChatUseCase {
    CreateChatResponse createChat(CreateChatRequest request);

    GetChatsResponse getChatsbySellerid(long ChatId);

    GetChatsResponse getChatsbyCustomerid(long ChatId);



}
