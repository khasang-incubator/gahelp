package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.MonsterDao;
import io.khasang.gahelp.entity.Monster;

public class MonsterDaoImpl extends BasicDaoImpl<Monster> implements MonsterDao {
    public MonsterDaoImpl(Class<Monster> entityClass) {
        super(entityClass);
    }
}
