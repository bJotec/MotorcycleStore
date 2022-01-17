package pl.camp.it.motorcycle.rent.sesion;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.camp.it.motorcycle.rent.model.Cart;
import pl.camp.it.motorcycle.rent.model.Order;
import pl.camp.it.motorcycle.rent.model.User;

@Component
@SessionScope
public class SessionObject {
    private User user = null ;
    private Order order = null ;
    private Cart cart = new Cart();

    public boolean isLogged() {
        return this.user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order getOrder() {return order;}

    public void setOrder(Order order) {this.order = order;}
}
