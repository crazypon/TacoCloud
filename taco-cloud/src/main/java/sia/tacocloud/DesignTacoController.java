package sia.tacocloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import sia.tacocloud.Ingredient.Type;
import sia.tacocloud.data.IngredientRepository;


 
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
  
  @Autowired
  IngredientRepository ingredientRepository;


  @ModelAttribute
  public void addIngredientsToModel(Model model) {
    Type[] types = Ingredient.Type.values();
    for(Type type : types) {
      model.addAttribute(type.toString().toLowerCase(), ingredientRepository.findByType(type));
    }
  }
 
  @ModelAttribute(name = "tacoOrder")
  public TacoOrder order() {
    return new TacoOrder();
  }
  
  @ModelAttribute(name = "taco")
  public Taco taco() {
    return new Taco();
  }
 
  @GetMapping
  public String showDesignForm() {
    System.out.println("DESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIGN");
    return "design";
  }

  //PostMapping handles POST HTTP request
  @PostMapping
  public String ProcessTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
    
    System.out.println("I have been engaged!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    if(errors.hasErrors()) {
      return "design";
    }

    tacoOrder.addTaco(taco);
    log.info("Processing Taco: {}", taco);
    return "redirect:/orders";
  }
  
 
}