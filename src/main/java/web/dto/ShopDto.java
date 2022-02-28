package web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name", "email", "phone"})
@EqualsAndHashCode(of = {"id", "name"})
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShopDto {

    private Long id;
    private String name;
    private String description;
    private String email;
    private String phone;
    private int count;

//    private double rating;
//    private List<ItemDto> items;
//    private List<ReviewDto> reviews;
//    private ImageDto logo;
//    private List<DiscountDto> discounts;
//    private CityDto location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
