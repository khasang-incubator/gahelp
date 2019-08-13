package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.MagicalSkill;

import java.util.List;

public interface MagicalSkillService {
    /**
     * service for adding MagicalSkill
     *
     * @param magicalSkill for adding
     * @return added MagicalSkill
     */
    MagicalSkill add(MagicalSkill magicalSkill);

    /**
     * service for getting MagicalSkill by id
     *
     * @param id - MagicalSkill's id
     * @return specific MagicalSkill by id
     */
    MagicalSkill getById(long id);

    /**
     * service for getting all MagicalSkills
     *
     * @return all MagicalSkills
     */
    List<MagicalSkill> getAll();

    /**
     * service for deletion MagicalSkill
     *
     * @param id - MagicalSkill's id for delete
     * @return deleted MagicalSkill
     */
    MagicalSkill delete(long id);

    /**
     * service for updating MagicalSkill
     *
     * @param id - MagicalSkill's id for update
     * @param magicalSkill - new skill's data for update
     * @return updated MagicalSkill
     */
    MagicalSkill update(long id, MagicalSkill magicalSkill);
}
