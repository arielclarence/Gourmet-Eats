package fontys.sem3.school.configuration.db;

import fontys.sem3.school.domain.Enum.Role;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.FoodRepository;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseDataInitializer {

    private CuisineRepository cuisineRepository;

    private UserRepository userRepository;

    private FoodRepository foodRepository;
    private final PasswordEncoder passwordEncoder;

    private String generateFoodCode(String foodName) {
        // Take the first three letters of the item name
        String prefix = foodName.substring(0, Math.min(foodName.length(), 3)).toUpperCase();

        // Get the count of existing items in the database
        long foodCount = foodRepository.count();

        // Generate the 5-digit sequence
        String sequenceValue = String.format("%05d", foodCount + 1);

        // Concatenate the parts to form the item code
        return prefix + "_" + sequenceValue;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabaseInitialDummyData() {
        List<CuisineEntity> cuisines = Arrays.asList(
                CuisineEntity.builder().name("Dutch").pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fcuisine%2Fdutchcuisine.jpg?alt=media&token=d1a20686-90d0-409f-a61c-867fa59afb80").build(),
                CuisineEntity.builder().name("Turkish").pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fcuisine%2Fturkishcuisine.jpg?alt=media&token=6054ccee-2845-41bf-82f8-ae3f64534396").build(),
                CuisineEntity.builder().name("Indonesian").pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fcuisine%2Findonesiancuisine.jpg?alt=media&token=d797aa14-9d8c-4753-af60-e08c71744439").build(),
                CuisineEntity.builder().name("Chinese").pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fcuisine%2Fchinesecuisine.jpg?alt=media&token=384bd56e-fbe8-4c77-886b-8ebc1b6dfcf0").build(),
                CuisineEntity.builder().name("Brazillian").pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fcuisine%2Fbrazilliancuisine.jpg?alt=media&token=319e3812-e150-4d91-943e-c019c8f00413").build()
        );
        List<UserEntity> users = Arrays.asList(
                UserEntity.builder()
                        .name("johndoe")
                        .username("johndoe")
                        .passwordhash(passwordEncoder.encode("johndoe"))
                        .phonenumber("+312345678")
                        .email("john.doe@example.com")
                        .address("123 Main St")
                        .gender("Male")
                        .profilePictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fuser%2Fjohndoe?alt=media&token=8615b91d-e8b4-49cf-92aa-a8b3a49cd798")
                        .role(Role.Seller)
                        .birthdate(LocalDate.of(1990, 1, 1))
                        .balance(0L)
                        .build(),
                UserEntity.builder()
                        .name("johndoe1")
                        .username("johndoe1")
                        .passwordhash(passwordEncoder.encode("johndoe1"))
                        .phonenumber("+3123456781")
                        .email("john.doe1@example.com")
                        .address("1231 Main St")
                        .gender("Male")
                        .profilePictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fuser%2Fjohndoe1.jpg?alt=media&token=75c89139-3982-4781-a557-0ff42452fa28")
                        .role(Role.Seller)
                        .birthdate(LocalDate.of(1995, 1, 1))
                        .balance(0L)
                        .build(),
                UserEntity.builder()
                        .name("arielclarence")
                        .username("arielclarence")
                        .passwordhash(passwordEncoder.encode("@aCT190902"))
                        .phonenumber("+310684318401")
                        .email("ariel.clarence@example.com")
                        .address("grave")
                        .gender("Male")
                        .profilePictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fuser%2Fjohndoe?alt=media&token=8615b91d-e8b4-49cf-92aa-a8b3a49cd798")
                        .role(Role.Customer)
                        .birthdate(LocalDate.of(2002, 9, 19))
                        .balance(0L)
                        .build(),
                UserEntity.builder()
                        .name("admin")
                        .username("admin")
                        .passwordhash(passwordEncoder.encode("admin"))
                        .phonenumber("+310684318401")
                        .email("admin@example.com")
                        .address("grave")
                        .gender("Female")
                        .profilePictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Fuser%2Fadmin.png?alt=media&token=dba9b8e9-6ce0-4289-a922-f455583bfc90")
                        .role(Role.Admin)
                        .birthdate(LocalDate.of(2002, 9, 19))
                        .balance(0L)
                        .build()
        );

        List<FoodEntity> foods = Arrays.asList(
                // Dutch Cuisine
                FoodEntity.builder()
                        .seller(users.get(0))
                        .name("Erwtensoep")
                        .code(generateFoodCode("Erwtensoep"))
                        .description("Traditional Dutch pea soup, thick and hearty")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Ferwtensoep.jpg?alt=media&token=62498a87-06c9-4f4e-b5ca-63a1139327fc")
                        .totalsales(0L)
                        .price(7)
                        .status(true)
                        .cuisine(cuisines.get(0))
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(0)) // Replace with the actual UserEntity for the seller
                        .name("Bitterballen")
                        .code(generateFoodCode("Bitterballen"))
                        .description("Deep-fried Dutch meat-based snack")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fbitterballen.jpg?alt=media&token=2211ff4f-8d67-40e4-bd58-3d88b3543f4d")
                        .totalsales(0L)
                        .status(true)
                        .price(4)
                        .cuisine(cuisines.get(0)) // Replace with the actual CuisineEntity for Dutch cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(0)) // Replace with the actual UserEntity for the seller
                        .name("Poffertjes")
                        .code(generateFoodCode("Poffertjes"))
                        .description("Mini Dutch pancakes")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fpoffertjes.jpg?alt=media&token=3f682e6b-36ab-4dac-bbc4-626ee1c9c69c")
                        .totalsales(0L)
                        .status(true)
                        .price(5)
                        .cuisine(cuisines.get(0)) // Replace with the actual CuisineEntity for Dutch cuisine
                        .build(),

                // Turkish Cuisine
                FoodEntity.builder()
                        .seller(users.get(0)) // Replace with the actual UserEntity for the seller
                        .name("Kebab")
                        .code(generateFoodCode("Kebab"))
                        .description("Grilled meat on skewers")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fkebab.jpg?alt=media&token=5c1a7faa-2cf9-4a07-b0f8-0d8b030802ad")
                        .totalsales(0L)
                        .status(true)
                        .price(7.5)
                        .cuisine(cuisines.get(1)) // Replace with the actual CuisineEntity for Turkish cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(0)) // Replace with the actual UserEntity for the seller
                        .name("Baklava")
                        .code(generateFoodCode("Baklava"))
                        .description("Sweet pastry with layers of filo and nuts")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fbaklava.jpg?alt=media&token=2f7bd941-bad5-49f7-a75d-68c0017c1eca")
                        .totalsales(0L)
                        .status(true)
                        .price(5)
                        .cuisine(cuisines.get(1)) // Replace with the actual CuisineEntity for Turkish cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(0)) // Replace with the actual UserEntity for the seller
                        .name("Manti")
                        .code(generateFoodCode("Manti"))
                        .description("Turkish dumplings")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fmanti.jpg?alt=media&token=4fbc820e-8c77-4496-8b80-db2b3e2f75be")
                        .totalsales(0L)
                        .status(true)
                        .price(8)
                        .cuisine(cuisines.get(1)) // Replace with the actual CuisineEntity for Turkish cuisine
                        .build(),

                // Indonesian Cuisine
                FoodEntity.builder()
                        .seller(users.get(0)) // Replace with the actual UserEntity for the seller
                        .name("Nasi Goreng")
                        .code(generateFoodCode("Nasi Goreng"))
                        .description("Indonesian fried rice")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fnasigoreng.jpg?alt=media&token=72189fae-bc56-4063-aac1-1f8f46a4fa93")
                        .totalsales(0L)
                        .status(true)
                        .price(8.5)
                        .cuisine(cuisines.get(2)) // Replace with the actual CuisineEntity for Indonesian cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(1)) // Replace with the actual UserEntity for the seller
                        .name("Satay")
                        .code(generateFoodCode("Satay"))
                        .description("Skewered and grilled meat")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fsatay.jpg?alt=media&token=9bd4c13a-6e81-4610-b136-ce5c7664b100")
                        .totalsales(0L)
                        .status(true)
                        .price(6.5)
                        .cuisine(cuisines.get(2)) // Replace with the actual CuisineEntity for Indonesian cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(1)) // Replace with the actual UserEntity for the seller
                        .name("Rendang")
                        .code(generateFoodCode("Rendang"))
                        .description("Spicy beef stew")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Frendang.jpg?alt=media&token=8ced9bad-b914-4d07-8276-ee91fc387f76")
                        .totalsales(0L)
                        .status(true)
                        .price(9)
                        .cuisine(cuisines.get(2)) // Replace with the actual CuisineEntity for Indonesian cuisine
                        .build(),

                // Chinese Cuisine
                FoodEntity.builder()
                        .seller(users.get(1)) // Replace with the actual UserEntity for the seller
                        .name("Dim Sum")
                        .code(generateFoodCode("Dim Sum"))
                        .description("Assorted Chinese appetizers")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fdimsum.jpg?alt=media&token=8b37dedd-edd5-4272-a261-9566037c83b6")
                        .totalsales(0L)
                        .status(true)
                        .price(6)
                        .cuisine(cuisines.get(3)) // Replace with the actual CuisineEntity for Chinese cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(1)) // Replace with the actual UserEntity for the seller
                        .name("Peking Duck")
                        .code(generateFoodCode("Peking Duck"))
                        .description("Roast duck dish from Beijing")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fpekingduck.jpg?alt=media&token=e0243ea5-4ea2-40e2-9586-b72341c097fd")
                        .totalsales(0L)
                        .status(true)
                        .price(10)
                        .cuisine(cuisines.get(3)) // Replace with the actual CuisineEntity for Chinese cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(1)) // Replace with the actual UserEntity for the seller
                        .name("Hot Pot")
                        .code(generateFoodCode("Hot Pot"))
                        .description("Chinese stew served at the table")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fhotpot.jpg?alt=media&token=0720d3a1-b7b4-4056-b8d6-3b73e5cf8213")
                        .totalsales(0L)
                        .status(true)
                        .price(15)
                        .cuisine(cuisines.get(3)) // Replace with the actual CuisineEntity for Chinese cuisine
                        .build(),

                // Brazilian Cuisine
                FoodEntity.builder()
                        .seller(users.get(1)) // Replace with the actual UserEntity for the seller
                        .name("Feijoada")
                        .code(generateFoodCode("Feijoada"))
                        .description("Brazilian black bean stew with pork")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Ffeijoada.jpg?alt=media&token=7e7b88aa-8049-4974-865a-bbc242b6a727")
                        .totalsales(0L)
                        .status(true)
                        .price(8.5)
                        .cuisine(cuisines.get(4)) // Replace with the actual CuisineEntity for Brazilian cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(1)) // Replace with the actual UserEntity for the seller
                        .name("Pão de Queijo")
                        .code(generateFoodCode("Pão de Queijo"))
                        .description("Brazilian cheese bread")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fp%C3%A3odequeijo.jpg?alt=media&token=d1bd93b4-8064-442e-b576-3bd032cafcba")
                        .totalsales(0L)
                        .status(true)
                        .price(4)
                        .cuisine(cuisines.get(4)) // Replace with the actual CuisineEntity for Brazilian cuisine
                        .build(),
                FoodEntity.builder()
                        .seller(users.get(1)) // Replace with the actual UserEntity for the seller
                        .name("Brigadeiro")
                        .code(generateFoodCode("Brigadeiro"))
                        .description("Brazilian chocolate truffle")
                        .pictureUrl("https://firebasestorage.googleapis.com/v0/b/gourmet-eats.appspot.com/o/images%2Ffood%2Fbrigadeiro.jpg?alt=media&token=7c420b1d-63a7-45a7-a0c7-0151fc0f78b3")
                        .totalsales(0L)
                        .status(true)
                        .price(3)
                        .cuisine(cuisines.get(4)) // Replace with the actual CuisineEntity for Brazilian cuisine
                        .build()
        );
// Save all FoodEntity instances
        if (userRepository.count() == 0) {
            userRepository.saveAll(users);
        }
        if (cuisineRepository.count() == 0) {
            cuisineRepository.saveAll(cuisines);
            foodRepository.saveAll(foods);
        }


    }
}
