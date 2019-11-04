package io.khasang.gahelp.config;

import io.khasang.gahelp.dao.CharactersDao;
import io.khasang.gahelp.dao.impl.CharactersDaoImpl;
import io.khasang.gahelp.entity.Characters;
import io.khasang.gahelp.dao.EmployeeDao;
import io.khasang.gahelp.dao.HorseDao;
import io.khasang.gahelp.dao.RoleDao;
import io.khasang.gahelp.dao.impl.RoleDaoImpl;
import io.khasang.gahelp.entity.Role;
import io.khasang.gahelp.dao.PhysicalSkillDao;
import io.khasang.gahelp.dao.UserDao;
import io.khasang.gahelp.dao.impl.PhysicalSkillDaoImpl;
import io.khasang.gahelp.dao.impl.UserDaoImpl;
import io.khasang.gahelp.dao.LogSheetDao;
import io.khasang.gahelp.dao.impl.HorseDaoImpl;
import io.khasang.gahelp.dao.impl.LogSheetDaoImpl;
import io.khasang.gahelp.entity.Horse;
import io.khasang.gahelp.entity.LogSheet;
import io.khasang.gahelp.dao.MonsterDao;
import io.khasang.gahelp.dao.impl.EmployeeDaoImpl;
import io.khasang.gahelp.dao.impl.MonsterDaoImpl;
import io.khasang.gahelp.entity.Employee;
import io.khasang.gahelp.entity.Monster;
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
    public Cat cat() {
        return new Cat("Yukki");
    }

    @Bean
    public HorseDao horseDao() {
        return new HorseDaoImpl(Horse.class);
    }

    @Bean
    public CharactersDao characterDao() {
        return new CharactersDaoImpl(Characters.class);
    }

    @Bean
    public RoleDao roleDao() {
        return new RoleDaoImpl(Role.class);
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(User.class);
    }

    @Bean
    public PhysicalSkillDao physicalSkillDao() {
        return new PhysicalSkillDaoImpl(PhysicalSkill.class);
    }

    @Bean
    public LogSheetDao logSheetDao() {
        return new LogSheetDaoImpl(LogSheet.class);
    }

    @Bean
    public MonsterDao monsterDao() {
        return new MonsterDaoImpl(Monster.class);
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }
}