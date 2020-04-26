package org.heroesunlimited.business;

import org.heroesunlimited.core.database.HeroesDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

    @Autowired
    private HeroesDatabase database;

    @Autowired
    private Environment environment;

    public void clearDatabase() {
        database.clearDatabase();
    }
}
