package io.khasang.gahelp.config;

import io.khasang.gahelp.dao.CharactersDao;
import io.khasang.gahelp.dao.HorseDao;
import io.khasang.gahelp.dao.impl.CharactersDaoImpl;
import io.khasang.gahelp.dao.impl.HorseDaoImpl;
import io.khasang.gahelp.entity.Characters;
import io.khasang.gahelp.entity.Horse;
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
    public CharactersDao characterDao() {
        return new CharactersDaoImpl(Characters.class);
    }
}
