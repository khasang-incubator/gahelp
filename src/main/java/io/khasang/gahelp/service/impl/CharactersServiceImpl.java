package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.CharactersDao;
import io.khasang.gahelp.entity.Characters;
import io.khasang.gahelp.service.CharactersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("characterService")
public class CharactersServiceImpl implements CharactersService {
    private CharactersDao charactersDao;

    public CharactersServiceImpl(CharactersDao charactersDao) {
        this.charactersDao = charactersDao;
    }

    @Override
    public Characters add(Characters characters) {
        return charactersDao.add(characters);
    }

    @Override
    public Characters getById(long id) {
        return charactersDao.getById(id);
    }

    @Override
    public Characters deleteById(long id) {
        return charactersDao.delete(getById(id));
    }

    @Override
    public Characters update(Characters characters) {
        return charactersDao.update(characters);
    }

    @Override
    public List<Characters> getAll() {
        return charactersDao.getAll();
    }
}
