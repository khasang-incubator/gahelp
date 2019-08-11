package io.khasang.gahelp.config;

import io.khasang.gahelp.dao.HorseDao;
import io.khasang.gahelp.dao.PhysicalSkillDao;
import io.khasang.gahelp.dao.UserDao;
import io.khasang.gahelp.dao.impl.HorseDaoImpl;
import io.khasang.gahelp.dao.impl.PhysicalSkillDaoImpl;
import io.khasang.gahelp.dao.impl.UserDaoImpl;
import io.khasang.gahelp.entity.Horse;
import io.khasang.gahelp.entity.PhysicalSkill;
import io.khasang.gahelp.entity.User;
import io.khasang.gahelp.model.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public Cat cat(){
        return new Cat("Yukki");
    }

    @Bean
    public HorseDao horseDao() {
        return new HorseDaoImpl(Horse.class);
    }

    @Bean
    public UserDao userDao(){
        return new UserDaoImpl(User.class);
    }

    @Bean
    public PhysicalSkillDao physicalSkillDao(){
        return new PhysicalSkillDaoImpl(PhysicalSkill.class);
    }

    @Bean
    public MonsterDao monsterDao() {
        return new MonsterDaoImpl(Monster.class);
    }
}
