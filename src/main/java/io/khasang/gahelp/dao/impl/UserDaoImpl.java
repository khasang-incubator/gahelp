package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.UserDao;
import io.khasang.gahelp.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public List<User> getByName(String name) {
        return getSession().createQuery("from User where name = ?1")
                .setParameter(1, name).list();
    }

    @Override
    public List<User> getIsBlocked() {
        return getSession().createQuery("from User where isBlocked = true").list();
    }

    @Override
    public User getByLogin(String login) {
//        return getSession().byNaturalId(User.class).using("login", login).load();
        return (User) getSession().createQuery("from User where login = ?1")
                .setParameter(1, login).list().get(0);
    }
}
