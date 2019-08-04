package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Monster;

import java.util.List;

public interface MonsterService {

    Monster add(Monster horse);

    List<Monster> getAll();

    Monster getById(long id);

    Monster delete(long id);

//    Monster update(long id);

//    List<Monster> deleteAll();
}
