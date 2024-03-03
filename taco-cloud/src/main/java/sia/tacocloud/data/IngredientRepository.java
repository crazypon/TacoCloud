package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;

import sia.tacocloud.Ingredient;
import java.util.List;
import sia.tacocloud.Ingredient.Type;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findByType(Type type);
} 