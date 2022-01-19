package pl.camp.it.motorcycle.rent.database.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.motorcycle.rent.database.IOrderDAO;
import pl.camp.it.motorcycle.rent.database.IUserDAO;
import pl.camp.it.motorcycle.rent.model.Order;
import pl.camp.it.motorcycle.rent.model.User;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDAOImpl implements IOrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    IUserDAO userDAO;

    @Override
    public void addOrder(Order order) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        } catch (Exception e) {
            if ( tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Order> getOrdersByUsersLogin(String login) {
        Optional<User> userBox = this.userDAO.getUserByLogin(login);
            if (!userBox.isPresent()) {
                return new ArrayList<>();
            }

            Session session = this.sessionFactory.openSession();
        Query<Order> query = session.createQuery("FROM pl.camp.it.motorcycle.rent.model.Order WHERE user_id = :user_id");
        query.setParameter("user_id" , userBox.get().getId() );
        List<Order> orders = query.getResultList();
        session.close();
        return orders;
    }

    @Override
    public void returnOrderById(Order order) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
        } catch (Exception e) {
            if ( tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Order> getOrdersById(int id) {
    /*    Optional<Order> orderBox = this.orderDAO.getUserByLogin(login);
        if (!userBox.isPresent()) {
            return new ArrayList<>();
        }
*/
        Session session = this.sessionFactory.openSession();
        Query<Order> query = session.createQuery("FROM pl.camp.it.motorcycle.rent.model.Order WHERE id = :id");
        query.setParameter("id" , id );
        try {
            Order orderById = query.getSingleResult();
            session.close();
            return Optional.of(orderById);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }

    }
}
