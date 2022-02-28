package web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "shop")
@Data
@Builder
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String description;
//    private City location;
//    private List<Item> items;
//    private List<Review> reviews;
//    private Image logo;
    @Column
    private int count;
//    @Column
//    private double rating;
//    private User user;
//    private List<Discount> discounts;
//    @Column
//    private boolean isModerated = false;
//    @Column
//    private boolean isModerateAccept = false;
//    @Column
//    private String moderatedRejectReason;
//    @Column
//    private boolean isPretendentToBeDeleted = false;
    @OneToMany(mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Item> items;

    public Shop() {

    }
    public void addComment(Item item) {
        items.add(item);
        item.setItem(this);
    }

    public void removeComment(Item item) {
        items.remove(item);
        item.setShop(null);
    }

    public Shop(Long id, String name, String email, String phone, String description, int count, List<Item> items) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.count = count;
//        this.rating = rating;
//        this.isModerated = isModerated;
//        this.isModerateAccept = isModerateAccept;
//        this.moderatedRejectReason = moderatedRejectReason;
//        this.isPretendentToBeDeleted = isPretendentToBeDeleted;
        this.items = items;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

//    public double getRating() {
//        return rating;
//    }
//
//    public void setRating(double rating) {
//        this.rating = rating;
//    }
//
//    public boolean isModerated() {
//        return isModerated;
//    }
//
//    public void setModerated(boolean moderated) {
//        isModerated = moderated;
//    }
//
//    public boolean isModerateAccept() {
//        return isModerateAccept;
//    }
//
//    public void setModerateAccept(boolean moderateAccept) {
//        isModerateAccept = moderateAccept;
//    }
//
//    public String getModeratedRejectReason() {
//        return moderatedRejectReason;
//    }
//
//    public void setModeratedRejectReason(String moderatedRejectReason) {
//        this.moderatedRejectReason = moderatedRejectReason;
//    }
//
//    public boolean isPretendentToBeDeleted() {
//        return isPretendentToBeDeleted;
//    }
//
//    public void setPretendentToBeDeleted(boolean pretendentToBeDeleted) {
//        isPretendentToBeDeleted = pretendentToBeDeleted;
//    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
