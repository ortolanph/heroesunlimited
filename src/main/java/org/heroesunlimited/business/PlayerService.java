package org.heroesunlimited.business;

import org.heroesunlimited.core.player.PlayableCharacter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerService {

    public PlayableCharacter build(String name) {
        return null;
    }

    public PlayableCharacter build(String name, String playerClass) {
        return null;
    }

    public PlayableCharacter build(String name, String playerClass, String playerRace, String gender) {
        return null;
    }

    public PlayableCharacter getById(String id) {
        return null;
    }

    public PlayableCharacter getByName(String name) {
        return null;
    }

    public List<String> getRaces() {
        return null;
    }

    public List<String> getClasses() {
        return null;
    }

}
