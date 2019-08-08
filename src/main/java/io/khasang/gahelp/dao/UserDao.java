package io.khasang.gahelp.dao;

import io.khasang.gahelp.entity.User;

import java.util.List;

public interface UserDao extends BasicDao<User> {
    /**
     * service for getting users with specific name
     * @param name - specific name
     * @return - list of user's with specific name
     */
    List<User> getByName(String name);

    /**
     * service for getting blocked users
     * @return - list of blocked users
     */
    List<User> getIsBlocked();

    /**
     * service for getting user by login-name
     * @param login - login-name
     * @return user with specific login-name
     */
    User getByLogin(String login);


}
