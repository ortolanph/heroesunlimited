package org.heroesunlimited.infra;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.heroesunlimited.business.EquipmentService;
import org.heroesunlimited.business.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class CamelBuilder extends RouteBuilder {

    @Autowired
    private Environment environment;

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .contextPath("/api").apiContextPath("/api-doc")
                .apiProperty("api.title", "Heroes Unlimited API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .dataFormatProperty("pretty-print", "true")
                .bindingMode(RestBindingMode.json);

        rest("/players")
                .description("Player Builder")

                .get("/name/{name}")
                .description("Returns a named human warrior male player unequipped.")
                .route()
                .bean(PlayerService.class, "build(${header.name})")
                .endRest()

                .get("/name/{name}/class/{class}")
                .description("Returns a named human male player with selected class unequipped.")
                .route()
                .bean(PlayerService.class, "build(${header.name}, ${header.class})")
                .endRest()

                .get("/name/{name}/class/{class}/race/{race}/gender/{gender}")
                .description("Returns a named player with selected class, race and gender unequipped.")
                .route()
                .bean(PlayerService.class, "build(${header.name}, ${header.class}, ${header.race}, ${header.gender}");

        rest("/equipment")
                .description("Equips a player")

                .get("/player/{id}/weapon/{weaponId}")
                .description("Equips a player with a weapon")
                .route()
                .bean(EquipmentService.class, "equipWeapon(${header.id}, ${header.weaponId})")
                .endRest()

                .get("/player/{id}/shield/{shieldId}")
                .description("Equips a player with a shield")
                .route()
                .bean(EquipmentService.class, "equipShield(${header.id}, ${header.shieldId})")
                .endRest()

                .get("/player/{id}/armor/{armorId}")
                .description("Equips a player with a armor")
                .route()
                .bean(EquipmentService.class, "equipArmor(${header.id}, ${header.armorId})")
                .endRest()

                .get("/player/{id}/boots/{bootsId}")
                .description("Equips a player with boots")
                .route()
                .bean(EquipmentService.class, "equipBoots(${header.id}, ${header.bootsId})")
                .endRest()

                .get("/player/{id}/weapon/{helmetId}")
                .description("Equips a player with a helmet")
                .route()
                .bean(EquipmentService.class, "equipHelmet(${header.id}, ${header.helmetId})")
                .endRest()

                .get("/player/{id}/weapon/{accessoryId}")
                .description("Equips a player with an accessory")
                .route()
                .bean(EquipmentService.class, "equipAccessory(${header.id}, ${header.accessoryId})");

        from("telegram:bots/" + environment.getProperty("TELEGRAM_CODE"))
                .bean(UnlimitedHeroBot.class);
    }
}
