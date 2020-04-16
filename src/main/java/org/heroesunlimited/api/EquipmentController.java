package org.heroesunlimited.api;

import org.heroesunlimited.business.EquipmentService;
import org.heroesunlimited.core.player.Equipment;
import org.heroesunlimited.core.player.EquipmentType;
import org.heroesunlimited.core.player.PlayableCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService service;

    @GetMapping("/kinds")
    private @ResponseBody
    List<EquipmentType> kinds() {
        return service.getKinds();
    }

    @GetMapping("/kinds/{kind}")
    private @ResponseBody
    List<Equipment> equipmentByKind(@PathVariable("kind") String kind) {
        return service.ofKind(kind);
    }

    @GetMapping("/player/{playerId}/weapon/{weaponId}")
    private @ResponseBody
    PlayableCharacter equipWeapon(@PathVariable("playerId") String playerId, @PathVariable("weaponId") int weaponId) {
        return service.equipWeapon(playerId, weaponId);
    }

    @GetMapping("/player/{playerId}/shield/{shieldId}")
    private @ResponseBody
    PlayableCharacter equipShield(@PathVariable("playerId") String playerId, @PathVariable("shieldId") int shieldId) {
        return service.equipShield(playerId, shieldId);
    }

    @GetMapping("/player/{playerId}/armor/{armorId}")
    private @ResponseBody
    PlayableCharacter equipArmor(@PathVariable("playerId") String playerId, @PathVariable("armorId") int armorId) {
        return service.equipArmor(playerId, armorId);
    }

    @GetMapping("/player/{playerId}/boot/{bootId}")
    private @ResponseBody
    PlayableCharacter equipBoots(@PathVariable("playerId") String playerId, @PathVariable("bootId") int bootId) {
        return service.equipBoots(playerId, bootId);
    }

    @GetMapping("/player/{playerId}/helmet/{helmetId}")
    private @ResponseBody
    PlayableCharacter equipHelmet(@PathVariable("playerId") String playerId, @PathVariable("helmetId") int helmetId) {
        return service.equipHelmet(playerId, helmetId);
    }

    @GetMapping("/player/{playerId}/accessory/{accessoryId}")
    private @ResponseBody
    PlayableCharacter equipAccessory(@PathVariable("playerId") String playerId, @PathVariable("accessoryId") int accessoryId) {
        return service.equipAccessory(playerId, accessoryId);
    }

}
