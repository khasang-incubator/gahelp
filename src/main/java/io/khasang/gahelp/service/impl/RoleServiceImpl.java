package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.RoleDao;
import io.khasang.gahelp.entity.Role;
import io.khasang.gahelp.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getRoleById(long id) {
        return roleDao.getById(id);
    }

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public Role deleteRole(long id) {
        return roleDao.getById(id);
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.update(role);
    }
}
