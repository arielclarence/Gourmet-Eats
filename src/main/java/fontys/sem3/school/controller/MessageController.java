package fontys.sem3.school.controller;

import fontys.sem3.school.business.MessageUseCase;
import fontys.sem3.school.domain.CreateMessageRequest;
import fontys.sem3.school.domain.CreateMessageResponse;
import fontys.sem3.school.domain.GetMessagesResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("message")
public class MessageController {

    private final MessageUseCase messageUseCase;
    private final SimpMessagingTemplate messagingTemplate;

    @PostMapping
    public CreateMessageResponse createMessage(@RequestBody CreateMessageRequest request) {
        CreateMessageResponse response = messageUseCase.createMessage(request);

        messagingTemplate.convertAndSend("/topic/chat", request.getContent());


        return response;
    }

    @GetMapping("/chat/{chatId}")
    public GetMessagesResponse getMessagesByChatId(@PathVariable long chatId) {
        return messageUseCase.getMessagesbyChatid(chatId);
    }
}
