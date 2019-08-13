package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.MagicalSkillDao;
import io.khasang.gahelp.entity.MagicalSkill;

public class MagicalSkillDaoImpl extends BasicDaoImpl<MagicalSkill> implements MagicalSkillDao {
    public MagicalSkillDaoImpl(Class<MagicalSkill> entityClass) {
        super(entityClass);
    }
}
