// doesn't matter but the most important one is to write code inside the tacocloud package
package sia.tacocloud;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;


// @Controller
// public class HomeController {
    
//     @GetMapping("/")
//     public String home() {
//         return "home";
//     }
// }


// You better use this kind of controller when it only redirects to one page
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HomeController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}