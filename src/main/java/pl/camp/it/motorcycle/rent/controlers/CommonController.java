package pl.camp.it.motorcycle.rent.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.motorcycle.rent.services.IMotorcycleService;
import pl.camp.it.motorcycle.rent.sesion.SessionObject;

import javax.annotation.Resource;


@Controller
public class CommonController {

    @Autowired
    IMotorcycleService motorcycleService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return ("redirect:/main");
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("motorcycles", this.motorcycleService.getAllMotorcycles());
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "/main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "/contact";
    }
}
