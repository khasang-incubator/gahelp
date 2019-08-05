package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.UserDao;
import io.khasang.gahelp.entity.User;
import io.khasang.gahelp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    @Override
    public List<User> getBlocked() {
        return userDao.getBlocked();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User delete(String login) {
        return userDao.delete(getByLogin(login));
    }

    @Override
    public User deleteById(long id) {
        return userDao.delete(getById(id));
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }
}
