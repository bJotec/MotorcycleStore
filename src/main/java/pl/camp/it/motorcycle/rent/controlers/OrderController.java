package pl.camp.it.motorcycle.rent.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.motorcycle.rent.excepions.ValidationException;
import pl.camp.it.motorcycle.rent.model.Address;
import pl.camp.it.motorcycle.rent.services.IOrderService;
import pl.camp.it.motorcycle.rent.sesion.SessionObject;
import pl.camp.it.motorcycle.rent.validators.AddressValidator;
import pl.camp.it.motorcycle.rent.validators.Validator;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmOrder(Model model) {
        model.addAttribute("logged", sessionObject.isLogged());
        model.addAttribute("address", new Address());
        return "postform";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirmOrder(@ModelAttribute Address address) {
        try {
            Validator.validateName(address.getName());
            Validator.validateSurname(address.getSurname());
            AddressValidator.validateAddress(address.getAddress());
            AddressValidator.validatePostalCode(address.getPostalCode());
            AddressValidator.validateCity(address.getCity());
            AddressValidator.validatePhone(address.getPhone());
        } catch (ValidationException e) {
            return "redirect:/order/confirm";
        }
        this.orderService.confirmOrder(address);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allOrders(Model model) {
        model.addAttribute("logged", sessionObject.isLogged());
        model.addAttribute("orders", this.orderService.getOrdersForCurrentUsers());
        return "orders";
    }

    @RequestMapping(value = "/return", method = RequestMethod.GET)
    public String returnOrder(Model model) {
        model.addAttribute("logged", sessionObject.isLogged());
        model.addAttribute("orders", this.orderService.getOrdersForCurrentUsers());

        this.orderService.returnOrder();

        /*this.orderService.returnOrderPositionByUserId();*/

        return "redirect:/order/all";
    }
}
