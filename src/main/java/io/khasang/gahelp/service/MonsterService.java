package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Monster;

import java.util.List;

public interface MonsterService {

    /**
     * service for adding monster
     *
     * @param monster for adding
     * @return added monster
     */
    Monster add(Monster monster);

    /**
     * service for getting all monster
     *
     * @return all monster
     */
    List<Monster> getAll();

    /**
     * service for getting monster by id
     *
     * @param id - monster's id
     * @return specific monster by id
     */
    Monster getById(long id);

    /**
     * service for deletion monster
     *
     * @param id - monster's id for delete
     * @return deleted monster
     */
    Monster delete(long id);

    /**
     * service for update monster by id
     *
     * @param id - monster's id for update
     * @return update monster
     */
    Monster updateMonsterById(long id, Monster monster);
}
