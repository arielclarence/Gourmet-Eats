package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.ChatUseCase;
import fontys.sem3.school.business.UserValidator;
import fontys.sem3.school.business.exception.UserNotFoundException;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.persistence.ChatRepository;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.entity.ChatEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatUseCaseImpl implements ChatUseCase {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    private final UserValidator chatValidator;


    @Override
    public CreateChatResponse createChat(CreateChatRequest request) {

        Optional<ChatEntity> existingChat = chatAlreadyExists(request.getCustomerid(),request.getSellerid());
        if (existingChat.isPresent()) {

            // Chat already exists, return the existing chat ID
            return CreateChatResponse.builder()
                    .Id(existingChat.get().getId())
                    .Sellerid(existingChat.get().getSellerid().getId())
                    .Customerid(existingChat.get().getCustomerid().getId())
                    .Customername(existingChat.get().getCustomerid().getName())
                    .Sellername(existingChat.get().getSellerid().getName())
                    .build();
        }

        ChatEntity savedChat = saveNewChat(request);

        return CreateChatResponse.builder()
                .Id(savedChat.getId())
                .Sellerid(savedChat.getSellerid().getId())
                .Customerid(savedChat.getCustomerid().getId())
                .build();
    }

    @Override
    public GetChatsResponse getChatsbySellerid(long sellerid) {

        List<Chat> chats = chatRepository.findBySellerid_Id(sellerid)
                .stream()
                .map(ChatConverter::convert)
                .collect(Collectors.toList());

        return GetChatsResponse.builder()
                .chats(chats)
                .build();

    }
    @Override
    public GetChatsResponse getChatsbyCustomerid(long customerid) {
        List<Chat> chats = chatRepository.findByCustomerid_Id(customerid)
                .stream()
                .map(ChatConverter::convert)
                .collect(Collectors.toList());

        return GetChatsResponse.builder()
                .chats(chats)
                .build();
    }



    private ChatEntity saveNewChat(CreateChatRequest request) {
        UserEntity customer=getUser(request.getCustomerid());
        UserEntity seller=getUser(request.getSellerid());
        ChatEntity newChat = ChatEntity.builder()
                .customerid(customer)
                .sellerid(seller)
                .updatedAt(LocalDateTime.now())
                .build();

        return chatRepository.save(newChat);
    }

    private Optional<ChatEntity> chatAlreadyExists( long customerId, long sellerId) {
        Optional<ChatEntity> existingChat = chatRepository.findByCustomerid_IdAndSellerid_Id(customerId,sellerId);
        return existingChat;
    }

    private UserEntity getUser(long userId) {
        Optional<UserEntity>user=userRepository.findById(userId);
        if (user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user.get();
    }

}
