package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Horse;

import java.util.List;

public interface HorseService {

    /**
     * service for adding horse
     *
     * @param horse for adding
     * @return added horse
     */
    Horse add(Horse horse);

    /**
     * service for getting horse by id
     *
     * @param id - horse's id
     * @return specific horse by id
     */
    Horse getById(long id);

    /**
     * service for getting all horse
     *
     * @return all horses
     */
    List<Horse> getAll();

    /**
     * service for deletion horse
     *
     * @param id - horse's id for delete
     * @return deleted horse
     */
    Horse delete(long id);

    /**
     * service for getting all horse by specific name
     *
     * @return all horses by specific name
     */
    List<Horse> getByname(String name);
}
