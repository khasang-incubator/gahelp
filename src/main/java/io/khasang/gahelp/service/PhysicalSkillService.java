package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.PhysicalSkill;

import java.util.List;

public interface PhysicalSkillService {
    /**
     * service for adding physicalSkill
     *
     * @param physicalSkill for adding
     * @return added physicalSkill
     */
    PhysicalSkill add(PhysicalSkill physicalSkill);

    /**
     * service for getting physicalSkill by id
     *
     * @param id - physicalSkill's id
     * @return specific physicalSkill by id
     */
    PhysicalSkill getById(long id);

    /**
     * service for getting all physicalSkills
     *
     * @return all physicalSkills
     */
    List<PhysicalSkill> getAll();

    /**
     * service for deletion physicalSkill
     *
     * @param id - physicalSkill's id for delete
     * @return deleted physicalSkill
     */
    PhysicalSkill delete(long id);

    /**
     * service for updating physicalSkill
     *
     * @param id            - physicalSkill's id for update
     * @param physicalSkill - new skill's data for update
     * @return updated physicalSkill
     */
    PhysicalSkill update(long id, PhysicalSkill physicalSkill);
}
