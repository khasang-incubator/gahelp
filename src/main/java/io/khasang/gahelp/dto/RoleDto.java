package io.khasang.gahelp.dto;

import io.khasang.gahelp.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleDto {
    private long id;
    private String name;
    private String type;
    private String description;

    public RoleDto getRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());
        roleDto.setDescription(role.getDescription());
        roleDto.setType(role.getType());
        return roleDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
