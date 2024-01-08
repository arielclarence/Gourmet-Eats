package fontys.sem3.school.controller;

import fontys.sem3.school.business.ChatUseCase;
import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.domain.CreateChatRequest;
import fontys.sem3.school.domain.CreateChatResponse;
import fontys.sem3.school.domain.GetChatsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {
    private final ChatUseCase chatUseCase;

    @PostMapping
    public ResponseEntity<CreateChatResponse> createChat(@RequestBody CreateChatRequest request) {
        try {
            CreateChatResponse response = chatUseCase.createChat(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (InvalidUserException e) {
            // Handle invalid user exception
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<GetChatsResponse> getChatsBySellerId(@PathVariable long sellerId) {
        GetChatsResponse response = chatUseCase.getChatsbySellerid(sellerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<GetChatsResponse> getChatsByCustomerId(@PathVariable long customerId) {
        GetChatsResponse response = chatUseCase.getChatsbyCustomerid(customerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
