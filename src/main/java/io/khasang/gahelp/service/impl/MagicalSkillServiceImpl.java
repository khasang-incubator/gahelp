package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.MagicalSkillDao;
import io.khasang.gahelp.entity.MagicalSkill;
import io.khasang.gahelp.service.MagicalSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagicalSkillServiceImpl implements MagicalSkillService {
    private MagicalSkillDao magicalSkillDao;

    public MagicalSkillServiceImpl(MagicalSkillDao magicalSkillDao) {
        this.magicalSkillDao = magicalSkillDao;
    }

    @Override
    public MagicalSkill add(MagicalSkill magicalSkill) {
        return magicalSkillDao.add(magicalSkill);
    }

    @Override
    public MagicalSkill getById(long id) {
        return magicalSkillDao.getById(id);
    }

    @Override
    public List<MagicalSkill> getAll() {
        return magicalSkillDao.getAll();
    }

    @Override
    public MagicalSkill delete(long id) {
        return magicalSkillDao.delete(getById(id));
    }

    @Override
    public MagicalSkill update(long id, MagicalSkill magicalSkill) {
        magicalSkill.setId(id);
        return magicalSkillDao.update(magicalSkill);
    }
}
