package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Characters;

import java.util.List;

public interface CharactersService {
    /**
     * Service to add character
     *
     * @param characters - character to add
     * @return character that been added
     */
    Characters add(Characters characters);

    /**
     * Service to get character by id
     *
     * @param id - id of character to get
     * @return specific character by id
     */
    Characters getById(long id);

    /**
     * Service to delete character
     *
     * @param id - id of character to be deleted
     * @return deleted character
     */
    Characters deleteById(long id);

    /**
     * Service to update character
     *
     * @param characters - data to update in character
     * @return updated character
     */
    Characters update(Characters characters);

    /**
     * Service to get all characters
     *
     * @return List of all characters
     */
    List<Characters> getAll();
}
