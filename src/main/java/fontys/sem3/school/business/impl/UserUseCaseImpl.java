package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.UserValidator;
import fontys.sem3.school.business.UserUseCase;
import fontys.sem3.school.business.exception.IdAlreadyExistsException;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserUseCaseImpl implements UserUseCase {
    private final UserRepository userRepository;
    private final UserValidator userIdValidator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void deleteUser(long UserId) {

        this.userRepository.deleteById(UserId);
    }
    @Override
    public GetAllUsersResponse getUsers() {
        List<User> Users = userRepository.findAll()
                .stream()
                .map(UserConverter::convert)
                .toList();

        return GetAllUsersResponse.builder()
                .Users(Users)
                .build();
    }
    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {

        UserEntity savedUser = saveNewUser(request);

        return CreateUserResponse.builder()
                .Id(savedUser.getId())
                .build();
    }
    @Override
    public Optional<User> getUser(long UserId) {
        return userRepository.findById(UserId).map(UserConverter::convert);

    }
    private UserEntity saveNewUser(CreateUserRequest request) {

        String encodedPassword = passwordEncoder.encode(request.getPasswordhash());
        UserEntity newUser = UserEntity.builder()
                .name(request.getName())
                .username(request.getUsername())
                .passwordhash(encodedPassword)
                .phonenumber(request.getPhonenumber())
                .address(request.getAddress())
                .gender(request.getGender())
                .birthdate(request.getBirthdate())
                .role(request.getRole())
                .balance(0L)
                .build();
        return userRepository.save(newUser);
    }
    @Override
    public void updateUser(UpdateUserRequest request) {
        Optional<UserEntity> UserOptional = userRepository.findById(request.getId());


        userIdValidator.validateId(request.getId());

        UserEntity User = UserOptional.get();
        updateFieldsProfile(request, User);
    }


    private void updateFieldsProfile(UpdateUserRequest request, UserEntity User) {
        User.setName(request.getName());
        User.setId(request.getId());
        User.setUsername(request.getUsername());
        String encodedPassword = passwordEncoder.encode(request.getPasswordhash());

        User.setPasswordhash(encodedPassword);
        User.setPhonenumber(request.getPhonenumber());
        if (request.getImage()!=null){
            User.setImage(request.getImage());
        }
        User.setGender(request.getGender());
        User.setBirthdate(request.getBirthdate());
        userRepository.save(User);
    }
    @Override
    public void updateUserBalance(UpdateUserBalanceRequest request) {
        Optional<UserEntity> UserOptional = userRepository.findById(request.getId());


        userIdValidator.validateId(request.getId());

        UserEntity User = UserOptional.get();
        updatebalance(request, User);
    }
    private void updatebalance(UpdateUserBalanceRequest request, UserEntity User) {
        if (request.isUpdate()){
            User.setBalance(User.getBalance()+request.getAmount());
        } else if (request.isUpdate()==false) {
            userIdValidator.validateBalance(User.getBalance(),request.getAmount());
            User.setBalance(request.getAmount()+User.getBalance());
        }
        userRepository.save(User);

    }
}
