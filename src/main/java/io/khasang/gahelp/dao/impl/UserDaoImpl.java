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
        return getAllByField("name", name);
    }

    @Override
    public User getByLogin(String login) {
        return getAllByField("login", login).get(0);
    }

    @Override
    public List<User> getBlocked() {
        return getAllByField("isBlocked", true);
    }

    @Override
    public List<User> getByRoleId(long id) {
        return getAllByField("roleId", id);
    }
}
