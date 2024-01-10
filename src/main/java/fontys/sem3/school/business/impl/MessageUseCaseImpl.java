package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.MessageUseCase;
import fontys.sem3.school.business.UserValidator;
import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.business.exception.UserNotFoundException;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.persistence.ChatRepository;
import fontys.sem3.school.persistence.MessageRepository;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.entity.ChatEntity;
import fontys.sem3.school.persistence.entity.MessageEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageUseCaseImpl implements MessageUseCase {
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    private final MessageRepository messageRepository;
    private final UserValidator messageValidator;

    @Override
    public CreateMessageResponse createMessage(CreateMessageRequest request) {
        MessageEntity savedMessage = saveNewMessage(request);

        return CreateMessageResponse.builder()
                .Id(savedMessage.getId())
                .build();
    }

    @Override
    public GetMessagesResponse getMessagesbyChatid(long chatId) {
        List<Message> messages = messageRepository.findByChatid_Id(chatId)
                .stream()
                .map(MessageConverter::convert)
                .collect(Collectors.toList());

        return GetMessagesResponse.builder()
                .messages(messages)
                .build();
    }

    private MessageEntity saveNewMessage(CreateMessageRequest request) {
        UserEntity sender=getUser(request.getSenderid());
        ChatEntity chat=getChat(request.getChatid());
        MessageEntity newMessage = MessageEntity.builder()
                .senderid(sender)
                .content(request.getContent())
                .timestamp(LocalDateTime.now())
                .chatid(chat)
                .build();

        return messageRepository.save(newMessage);
    }
    private UserEntity getUser(long userId) {
        Optional<UserEntity> user=userRepository.findById(userId);
        if (user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user.get();
    }
    private ChatEntity getChat(long chatId) {
        Optional<ChatEntity> chat=chatRepository.findById(chatId);
        if (chat.isEmpty()){
            throw new UserNotFoundException();
        }
        return chat.get();
    }
}
