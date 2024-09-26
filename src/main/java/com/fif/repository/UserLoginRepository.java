package com.fif.repository;

import com.fif.entity.UserLogin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserLoginRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public UserLogin get(String username) throws NoResultException {
        Query query = em.createQuery("SELECT u FROM user_login u WHERE u.username = :username", UserLogin.class);
        query.setParameter("username", username);
        return (UserLogin) query.getSingleResult();
    }
}
