package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.PhysicalSkillDao;
import io.khasang.gahelp.entity.PhysicalSkill;

public class PhysicalSkillDaoImpl extends BasicDaoImpl<PhysicalSkill> implements PhysicalSkillDao {
    public PhysicalSkillDaoImpl(Class<PhysicalSkill> entityClass) {
        super(entityClass);
    }
}
