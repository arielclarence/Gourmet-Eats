package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.MessageUseCase;
import fontys.sem3.school.business.UserValidator;
import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.domain.CreateMessageRequest;
import fontys.sem3.school.domain.CreateMessageResponse;
import fontys.sem3.school.domain.GetMessagesResponse;
import fontys.sem3.school.domain.Message;
import fontys.sem3.school.persistence.MessageRepository;
import fontys.sem3.school.persistence.entity.ChatEntity;
import fontys.sem3.school.persistence.entity.MessageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageUseCaseImpl implements MessageUseCase {

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
        List<Message> messages = messageRepository.findByChat_Id(chatId)
                .stream()
                .map(MessageConverter::convert)
                .collect(Collectors.toList());

        return GetMessagesResponse.builder()
                .messages(messages)
                .build();
    }

    private MessageEntity saveNewMessage(CreateMessageRequest request) {
        MessageEntity newMessage = MessageEntity.builder()
                .senderid(request.getSenderid())
                .content(request.getContent())
                .chatid(request.getChatid())
                .build();

        return messageRepository.save(newMessage);
    }

}
