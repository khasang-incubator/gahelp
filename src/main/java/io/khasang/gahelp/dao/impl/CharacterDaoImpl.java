package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.CharacterDao;
import io.khasang.gahelp.entity.Character;

public class CharacterDaoImpl extends BasicDaoImpl<Character> implements CharacterDao {
    public CharacterDaoImpl(Class<Character> entityClass) {
        super(entityClass);
    }
}
