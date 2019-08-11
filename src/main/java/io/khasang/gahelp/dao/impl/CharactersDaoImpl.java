package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.CharactersDao;
import io.khasang.gahelp.entity.Characters;

public class CharactersDaoImpl extends BasicDaoImpl<Characters> implements CharactersDao {
    public CharactersDaoImpl(Class<Characters> entityClass) {
        super(entityClass);
    }
}
