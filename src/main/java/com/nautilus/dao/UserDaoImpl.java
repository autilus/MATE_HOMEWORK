package com.nautilus.dao;

import com.nautilus.model.User;
import com.nautilus.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static String FIND_ID_BY_LOGIN_QUERY = "select id from User u where u.login=:login";
    private static String FIND_ID_BY_PASSWORD_QUERY = "select id from User u where u.password=:password";
    private static String FIND_ALL_QUERY = "select * from User";

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public Long findIdByLogin(String login) {
        return (Long) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery(FIND_ID_BY_LOGIN_QUERY)
                .setParameter("login", login)
                .getResultList().get(0);
    }

    public Long findIdByPassword(String password) {
        return (Long) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery(FIND_ID_BY_PASSWORD_QUERY)
                .setParameter("password", password).getResultList().get(0);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery(FIND_ALL_QUERY).list();

        return users;
    }
}
