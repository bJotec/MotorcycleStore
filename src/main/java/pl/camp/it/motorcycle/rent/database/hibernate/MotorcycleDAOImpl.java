package pl.camp.it.motorcycle.rent.database.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.motorcycle.rent.database.IMotorcycleDAO;
import pl.camp.it.motorcycle.rent.model.Motorcycle;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class MotorcycleDAOImpl implements IMotorcycleDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Motorcycle> getMotorcycles() {
        Session session = this.sessionFactory.openSession();
        Query<Motorcycle> query = session.createQuery("FROM pl.camp.it.motorcycle.rent.model.Motorcycle ");
        List<Motorcycle> motorcycles = query.getResultList();
        session.close();
        return motorcycles;
    }

    @Override
    public Optional<Motorcycle> getMotorcycleByVin(String vin) {
        Session session = this.sessionFactory.openSession();
        Query<Motorcycle> query = session.createQuery("FROM pl.camp.it.motorcycle.rent.model.Motorcycle WHERE vin = :vin");
        query.setParameter("vin", vin);
        try {
            Motorcycle motorcycle = query.getSingleResult();
            session.close();
            return Optional.of(motorcycle);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Motorcycle> getMotorcycleById(int motorcycleId) {
            Session session = this.sessionFactory.openSession();
            Query<Motorcycle> query = session.createQuery("FROM pl.camp.it.motorcycle.rent.model.Motorcycle WHERE id = :id");
            query.setParameter("id", motorcycleId);
            try {
                Motorcycle motorcycle = query.getSingleResult();
                session.close();
                return Optional.of(motorcycle);
            } catch (NoResultException e) {
                session.close();
                return  Optional.empty();
            }
    }

    @Override
    public void updateMotorcycle(Motorcycle motorcycle) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(motorcycle);
            tx.commit();

        } catch (Exception e) {
            if (tx !=null)
                tx.rollback();
        } finally {
            session.close();
        }
    }
}
