package sia.tacocloud;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class TacoOrder {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date placedAt = new Date();
    
    @ManyToOne
    private User user;

    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @NotBlank(message="Delivery street is required")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    private String deliveryCity;

    @NotBlank(message="State is required")
    private String deliveryState;

    @NotBlank(message="Zip Code is required")
    private String deliveryZip;

    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Pattern(regexp = "^[0-9]{3,4}$", message="Invalid CVV")
    private String ccCVV;
    
    // One to Many relationship here shows that many tacos can be in a order
    // CascadeType.ALL indicates that all related tacos will be deleted from
    // database if order is deleted.
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>(); 

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
