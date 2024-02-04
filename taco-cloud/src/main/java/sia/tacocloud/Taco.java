package sia.tacocloud;

import lombok.Data;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;




@Data
public class Taco {
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min=1, message="Choose at least one ingredient")
    private List<Ingredient> ingredients;
}