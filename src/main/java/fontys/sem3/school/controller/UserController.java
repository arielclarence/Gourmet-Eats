package fontys.sem3.school.controller;

import fontys.sem3.school.business.UserUseCase;
import fontys.sem3.school.business.UserUseCase;
import fontys.sem3.school.domain.*;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;
//b

    @GetMapping
    @RolesAllowed({"Admin"})
    public ResponseEntity<GetAllUsersResponse> getUsers() {
        return ResponseEntity.ok(userUseCase.getUsers());
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") final long UserId) {
        final Optional<User> UserOptional = userUseCase.getUser(UserId);
        if (UserOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(UserOptional.get());
    }
    @DeleteMapping("{UserId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int UserId) {
        userUseCase.deleteUser(UserId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping()
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request) {
        CreateUserResponse response = userUseCase.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateUserRequest request) {
        request.setId(id);
        userUseCase.updateUser(request);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/balance/{id}")
    public ResponseEntity<Void> updateBalance(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateUserBalanceRequest request) {
        request.setId(id);
        userUseCase.updateUserBalance(request);
        return ResponseEntity.noContent().build();
    }
}
