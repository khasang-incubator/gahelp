package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Role;
import io.khasang.gahelp.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Role getRoleById(@PathVariable("id") long id) {
        return roleService.getRoleById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Role deleteRoleById(@PathVariable("id") long id) {
        return roleService.deleteRole(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Role updateRoleById(@PathVariable("id") long id, @RequestBody Role role) {
        return roleService.updateRoleById(role, id);
    }
}
