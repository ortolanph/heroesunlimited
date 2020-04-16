package org.heroesunlimited.api;

import org.heroesunlimited.business.PlayerService;
import org.heroesunlimited.core.player.PlayableCharacter;
import org.heroesunlimited.core.player.PlayerClass;
import org.heroesunlimited.core.player.PlayerRace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping("/{id}")
    public @ResponseBody
    PlayableCharacter getById(@PathVariable("id") String playerId) {
        return service.getById(playerId);
    }

    @GetMapping("/{name}")
    public @ResponseBody
    PlayableCharacter getByName(@PathVariable("name") String playerName) {
        return service.getByName(playerName);
    }

    @GetMapping("/races")
    public @ResponseBody
    List<PlayerRace> getRaces() {
        return service.getRaces();
    }

    @GetMapping("/classes")
    public @ResponseBody
    List<PlayerClass> getClasses() {
        return service.getClasses();
    }

    @GetMapping("/name/{name}")
    public @ResponseBody
    PlayableCharacter build(@PathVariable("name") String name) {
        return service.build(name);
    }

    @GetMapping("/name/{name}/class/{playerClass}")
    public @ResponseBody
    PlayableCharacter build(@PathVariable("name") String name, @PathVariable("playerClass") String playerClass) {
        return service.build(name, playerClass);
    }

    @GetMapping("/name/{name}/class/{playerClass}/race/{race}/gender/{gender}")
    public @ResponseBody
    PlayableCharacter build(@PathVariable("name") String name, @PathVariable("playerClass") String playerClass,
                            @PathVariable("race") String race, @PathVariable("gender") String gender) {
        return service.build(name, playerClass, race, gender);
    }
}
