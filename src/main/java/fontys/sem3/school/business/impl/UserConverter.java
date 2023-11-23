package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.Cuisine;
import fontys.sem3.school.domain.User;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

final class UserConverter {
    private UserConverter() {
    }

    public static User convert(UserEntity usere) {
        return User.builder()
                .id(usere.getId())
                .name(usere.getName())
                .username(usere.getUsername())
                .passwordhash(usere.getPasswordhash())
                .phonenumber(usere.getPhonenumber())
                .address(usere.getAddress())
                .gender(usere.getGender())
                .birthdate(usere.getBirthdate())
                .role(usere.getRole())
                .balance(usere.getBalance())
                .build();


    }
}
