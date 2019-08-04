package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.UserDao;
import io.khasang.gahelp.entity.User;

import java.util.List;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public List<User> getByName(String name) {
        // select * from users where name = name;
        // for future
        return getAllByField("name", name);
    }

    @Override
    public User getByLogin(String login) {
        return getAllByField("login", login).get(0);
    }

    // TODO: нужно выбрать метод getByLogin либо выше, либо ниже. Какой?

//    @Override
//    public User getByLogin(String login) {
//        return sessionFactory.getCurrentSession().byNaturalId(User.class)
//                .using("login", login).load();
//    }

    @Override
    public List<User> getBlocked() {
        // select * from users where isBlocked = true;
        // for future
        return getAllByField("isBlocked", false);
    }
}
