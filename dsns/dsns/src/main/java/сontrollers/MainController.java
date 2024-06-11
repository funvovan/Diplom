package сontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MainController {

    @GetMapping("/")
    public String showForm() {
        return "searchForm";
    }

    @PostMapping("/search")
    public String search(@RequestParam String startLocation, @RequestParam String endLocation, Model model) {
        // Тут ви можете обробити дані, які були введені в форму пошуку
        // І передати їх до сторінки результатів
        model.addAttribute("startLocation", startLocation);
        model.addAttribute("endLocation", endLocation);
        return "results";
    }
}

