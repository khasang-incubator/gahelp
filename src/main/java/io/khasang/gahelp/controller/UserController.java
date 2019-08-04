package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.User;
import io.khasang.gahelp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.add(user);
    }

    @RequestMapping(value = "/get/{login}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByLogin(@PathVariable("login") String login) {
        return userService.getByLogin(login);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id") long id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllByName(@PathVariable("name") String name) {
        return userService.getByName(name);
    }

    @RequestMapping(value = "/get/blocked", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getBlocked() {
        return userService.getBlocked();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/delete/{login}", method = RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(@PathVariable("login") String login) {
        return userService.delete(login);
    }

    @RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public User deleteUserById(@PathVariable("id") long id) {
        return userService.deleteById(id);
    }

    @PutMapping(value = "/update/{login}")
    @ResponseBody
    public User updateUser(@RequestBody User user, @PathVariable("login") String login){
        return userService.updateByLogin(login, user);
    }

    @RequestMapping(value = "/update/id/{id}")
    @ResponseBody
    public User updateUserById(@RequestBody User user, @PathVariable("id") long id){
        return userService.updateById(id, user);
    }
}
