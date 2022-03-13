package com.javacourse.course.dao;

import com.javacourse.course.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleted(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserForCredentials(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> lists = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if ( lists.isEmpty()) {
            return null;
        }

        String passwordHashed = lists.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, user.getPassword())) {
            return lists.get(0);
        }

        return null;

//        String query = "FROM User WHERE email = :email AND password = :password";
//        List<User> lists = entityManager.createQuery(query)
//                .setParameter("email", user.getEmail())
//                .setParameter("password", user.getPassword())
//                .getResultList();
//        if (lists.isEmpty()) {
//            return false;
//        } else {
//            return true;
//        }
    }
}
