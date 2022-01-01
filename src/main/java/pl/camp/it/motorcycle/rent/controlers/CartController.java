package pl.camp.it.motorcycle.rent.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.motorcycle.rent.services.ICartService;
import pl.camp.it.motorcycle.rent.sesion.SessionObject;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    ICartService cartService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/add/{vin}", method = RequestMethod.GET)
    public String addToCart(@PathVariable String vin) {

        if (!this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        this.cartService.addToCart(vin);
        return "redirect:/main";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String cart(Model model) {

        if (!this.sessionObject.isLogged()) {
            return "redirect:/main";
        }

        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("cart", this.sessionObject.getCart());
        model.addAttribute("sum", this.sessionObject.getCart().calculateSum());
        return "cart";
    }
}
