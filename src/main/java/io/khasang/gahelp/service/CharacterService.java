package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Character;

import java.util.List;

public interface CharacterService {
    /**
     * Service to add character
     *
     * @param character - character to add
     * @return character that been added
     */
    Character add(Character character);

    /**
     * Service to get character by id
     *
     * @param id - id of character to get
     * @return specific character by id
     */
    Character getById(long id);

    /**
     * Service to delete character
     *
     * @param id - id of character to be deleted
     * @return deleted character
     */
    Character deleteById(long id);

    /**
     * Service to update character
     *
     * @param id        - id of character to be updated
     * @param character - data to update in character
     * @return updated character
     */
    Character updateById(Character character, long id);

    /**
     * Service to get all characters
     *
     * @return List of all characters
     */
    List<Character> getAll();
}
