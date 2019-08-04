package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Role;

import java.util.List;

public interface RoleService {

    /**
     * Service for adding role
     *
     * @param role - for adding
     * @return added role
     */
    Role addRole(Role role);

    /**
     * Service to getting role by id
     *
     * @param id - role id
     * @return specific role by id
     */
    Role getRoleById(long id);

    /**
     * Service for getting all roles
     *
     * @return all roles
     */
    List<Role> getAll();

    /**
     * Service to delete specific role
     *
     * @param id - role id to delete
     * @return deleted role
     */
    Role deleteRole(long id);

    /**
     * Service to update role
     *
     * @param id   - id of role to update
     * @param role - update data for role
     * @return updated role
     */
    Role updateRoleById(Role role, long id);
}
