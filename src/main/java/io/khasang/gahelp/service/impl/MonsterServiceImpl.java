package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.dao.MonsterDao;
import io.khasang.gahelp.entity.Monster;
import io.khasang.gahelp.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("monsterService")
public class MonsterServiceImpl implements MonsterService {

    private MonsterDao monsterDao;

    @Override
    public Monster add(Monster monster) {
        return monsterDao.add(monster);
    }

    @Override
    public List<Monster> getAll() {
        return monsterDao.getAll();
    }

    @Override
    public Monster getById(long id) {
        return monsterDao.getById(id);
    }

    @Override
    public Monster delete(long id) {
        return monsterDao.delete(getById(id));
    }

    @Override
    public List<Monster> deleteAll() {
        return monsterDao.deleteAll();
    }

    @Autowired
    public void setMonsterDao(MonsterDao monsterDao) {
        this.monsterDao = monsterDao;
    }
}
