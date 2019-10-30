package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.RoleDao;
import io.khasang.gahelp.entity.Role;

public class RoleDaoImpl extends BasicDaoImpl<Role> implements RoleDao {
    public RoleDaoImpl(Class<Role> entityClass) {
        super(entityClass);
    }
}
