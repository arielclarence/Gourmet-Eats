package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.ChatUseCase;
import fontys.sem3.school.business.UserValidator;
import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.persistence.ChatRepository;
import fontys.sem3.school.persistence.entity.ChatEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatUseCaseImpl implements ChatUseCase {

    private final ChatRepository chatRepository;
    private final UserValidator chatValidator;


    @Override
    public CreateChatResponse createChat(CreateChatRequest request) {

        Optional<Long> existingChatId = chatAlreadyExists(request.getSellerid().getId(), request.getCustomerid().getId());

        if (existingChatId.isPresent()) {
            // Chat already exists, return the existing chat ID
            return CreateChatResponse.builder()
                    .Id(existingChatId.get())
                    .build();
        }

        ChatEntity savedChat = saveNewChat(request);

        return CreateChatResponse.builder()
                .Id(savedChat.getId())
                .build();
    }

    @Override
    public GetChatsResponse getChatsbySellerid(long sellerid) {

        List<Chat> chats = chatRepository.findBySellerid(sellerid)
                .stream()
                .map(ChatConverter::convert)
                .collect(Collectors.toList());

        return GetChatsResponse.builder()
                .chats(chats)
                .build();

    }
    @Override
    public GetChatsResponse getChatsbyCustomerid(long customerid) {
        List<Chat> chats = chatRepository.findByCustomerid(customerid)
                .stream()
                .map(ChatConverter::convert)
                .collect(Collectors.toList());

        return GetChatsResponse.builder()
                .chats(chats)
                .build();
    }



    private ChatEntity saveNewChat(CreateChatRequest request) {
        ChatEntity newChat = ChatEntity.builder()
                .customerid(request.getCustomerid())
                .sellerid(request.getSellerid())
                .build();

        return chatRepository.save(newChat);
    }

    private Optional<Long> chatAlreadyExists(long sellerId, long customerId) {
        Optional<ChatEntity> existingChat = chatRepository.findByCustomeridAndSellerid(sellerId, customerId);
        return existingChat.map(ChatEntity::getId);
    }



}
