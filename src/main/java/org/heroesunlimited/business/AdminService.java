package org.heroesunlimited.business;

import org.heroesunlimited.core.database.HeroesDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class AdminService {

    @Autowired
    private HeroesDatabase database;

    @Autowired
    private Environment environment;

    public void clearDatabase(@NotNull String password) throws Exception {
        if(password.equals(environment.getProperty("HEROES_UNLIMITED_PASSWORD"))) {
            database.clearDatabase();
        } else {
            throw new Exception("Wrong password!");
        }
    }
}
