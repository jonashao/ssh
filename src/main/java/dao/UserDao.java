package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import po.User;

import java.util.List;


public class UserDao{

    private SessionFactory sessionFactory;

    public String addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.flush();
        session.close();
        return "ok";
    }

    public User findUserByID(String ID) {
        sessionFactory.getCurrentSession().beginTransaction();

        List list = sessionFactory.getCurrentSession().
                createQuery("from User where ID = ?").
                setParameter(0, ID).list();

        if (list.size()>0) {
            Object object = list.get(0);
            System.out.println(object);
            return (User) object;
        }

        return null;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}