package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.CharacterDao;
import io.khasang.gahelp.entity.Character;
import io.khasang.gahelp.service.CharacterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("characterService")
public class CharacterServiceImpl implements CharacterService {
    private CharacterDao characterDao;

    public CharacterServiceImpl(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @Override
    public Character add(Character character) {
        return characterDao.add(character);
    }

    @Override
    public Character getById(long id) {
        return characterDao.getById(id);
    }

    @Override
    public Character deleteById(long id) {
        return characterDao.delete(getById(id));
    }

    @Override
    public Character updateById(Character character, long id) {
        character.setId(id);
        return characterDao.update(character);
    }

    @Override
    public List<Character> getAll() {
        return characterDao.getAll();
    }
}
