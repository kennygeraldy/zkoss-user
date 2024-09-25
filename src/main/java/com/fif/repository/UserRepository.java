package com.fif.repository;

import com.fif.entity.Log;
import com.fif.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<User> queryAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        List<User> result = query.getResultList();
        return result;
    }

    @Transactional(readOnly = true)
    public User get(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public User save(User user) {
        em.persist(user);
        em.flush();
        return user;
    }

    @Transactional
    public void delete(User user) {
        User r = get(user.getId());
        if(r != null) {
            em.remove(r);
        }
    }

    @Transactional
    public void update(User user) {
        User existingUser = get(user.getId());
            existingUser.setUsername(user.getUsername());
            existingUser.setGender(user.getGender());
            existingUser.setBirthday(user.getBirthday());
            existingUser.setAge(user.getAge());
            existingUser.setRole(user.getRole());

            em.merge(existingUser);
            em.flush();
    }

    @Transactional(readOnly = true)
    public List<User> searchByKeyword(String keyword) {
        String searchQuery = "SELECT u FROM User u WHERE u.username LIKE :keyword";
        Query query = em.createQuery(searchQuery);
        query.setParameter("keyword", "%" + keyword + "%");
        List<User> res = query.getResultList();
        return res;}

//    public static List<User> users = new ArrayList<User>();
//
//    static {
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            users.add(new User(1L, "Kenny Geraldy", "male", sdf.parse("2020-1-8"), 22, "Front-End Developer"));
//            users.add(new User(2L, "Jona Kentyck", "male", sdf.parse("2020-1-8"), 23, "Back-End Developer"));
//            users.add(new User(3L, "Kezia Amelia", "female", sdf.parse("2000-11-2"), 25, "Front-End Developer"));
//            users.add(new User(4L, "Unlocki Dharma", "male", sdf.parse("2010-02-2"), 26, "Front-End Developer"));
//            users.add(new User(5L, "Nathania Coa", "female", sdf.parse("2010-02-2"), 27, "Full-Stack Developer"));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        };
//    }
//
//    public List<User> findAll() {
//        return users;
//    }
//
//    public void addUser(User user) {
//        users.add(user);
//    }
}
