package com.nautilus.dao;

import com.nautilus.model.User;
import com.nautilus.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }
    public Long findIdByLogin(String login) {
        return (Long) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("select id from User u where u.login=:login")
                .setParameter("login",login)
                .getResultList().get(0);
    }

    public Long finIdByPassword(String password) {
        return (Long) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("select id from User u where u.password=:password")
                .setParameter("password",password).getResultList().get(0);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From User").list();

        return users;
    }
}