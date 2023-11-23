package fontys.sem3.school.business;

import fontys.sem3.school.domain.*;

import java.util.Optional;

public interface UserUseCase {
    void deleteUser(long UserId);

    GetAllUsersResponse getUsers();

    CreateUserResponse createUser(CreateUserRequest request);

    Optional<User> getUser(long UserId);

    void updateUser(UpdateUserRequest request);

    void updateUserBalance(UpdateUserBalanceRequest request);
}
