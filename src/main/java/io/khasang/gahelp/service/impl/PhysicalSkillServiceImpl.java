package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.PhysicalSkillDao;
import io.khasang.gahelp.entity.PhysicalSkill;
import io.khasang.gahelp.service.PhysicalSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicalSkillServiceImpl implements PhysicalSkillService {
    private PhysicalSkillDao physicalSkillDao;

    public PhysicalSkillServiceImpl(PhysicalSkillDao physicalSkillDao) {
        this.physicalSkillDao = physicalSkillDao;
    }

    @Override
    public PhysicalSkill add(PhysicalSkill physicalSkill) {
        return physicalSkillDao.add(physicalSkill);
    }

    @Override
    public PhysicalSkill getById(long id) {
        return physicalSkillDao.getById(id);
    }

    @Override
    public List<PhysicalSkill> getAll() {
        return physicalSkillDao.getAll();
    }

    @Override
    public PhysicalSkill delete(long id) {
        return physicalSkillDao.delete(getById(id));
    }

    @Override
    public PhysicalSkill update(long id, PhysicalSkill physicalSkill) {
        physicalSkill.setId(id);
        return physicalSkillDao.update(physicalSkill);
    }
}
