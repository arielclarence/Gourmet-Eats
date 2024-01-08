package fontys.sem3.school.domain;


import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//asd
public class Food {
    private Long id;
    private UserEntity seller;
    private String name;
    private String code;
    private String description;
    private String pictureUrl;
    private Long totalSales;
    private double price;
    private boolean status;
    private CuisineEntity cuisine;
}
