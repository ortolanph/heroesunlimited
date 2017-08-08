package org.heroesunlimited.infra;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.heroesunlimited.business.AdminService;
import org.heroesunlimited.business.EquipmentService;
import org.heroesunlimited.business.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CamelBuilder extends RouteBuilder {

    @Autowired
    private Environment environment;

    @Autowired
    private UnlimitedHeroBot bot;

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

                .post("/name/{name}")
                .description("Returns a named human warrior male player unequipped.")
                .route()
                .bean(PlayerService.class, "build(${header.name})")
                .endRest()

                .post("/name/{name}/class/{playerClass}")
                .description("Returns a named human male player with selected class unequipped.")
                .route()
                .bean(PlayerService.class, "build(${header.name}, ${header.playerClass})")
                .endRest()

                .post("/name/{name}/class/{playerClass}/race/{playerRace}/gender/{gender}")
                .description("Returns a named player with selected class, race and gender unequipped.")
                .route()
                .bean(PlayerService.class, "build(${header.name}, ${header.playerClass}, ${header.playerRace}, ${header.gender})")
                .endRest()

                .get("/id/{id}")
                .description("Returns a determined hero by id")
                .route()
                .bean(PlayerService.class, "getById(${header.id})")
                .endRest()

                .get("/name/{name}")
                .description("Returns a determined hero by name")
                .route()
                .bean(PlayerService.class, "getByName(${header.name})")
                .endRest()

                .get("/races")
                .description("Returns the list of races")
                .route()
                .bean(PlayerService.class, "getRaces()")
                .endRest()

                .get("/classes")
                .description("Returns the list of classes")
                .route()
                .bean(PlayerService.class, "getClasses()");

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
                .bean(EquipmentService.class, "equipAccessory(${header.id}, ${header.accessoryId})")
                .endRest()

                .get("/ofKind/{kind}")
                .description("List all equipment of a kind")
                .route()
                .bean(EquipmentService.class, "ofKind(${header.kind})")
                .endRest()

                .get("/kinds")
                .description("List all kinds")
                .route()
                .bean(EquipmentService.class, "getKinds()");

        rest("/admin")
                .description("Admin tasks")

                .get("/clear")
                .description("Clears database")
                .route()
                .bean(AdminService.class, "clearDatabase()");

//        String botId = environment.getProperty("HEROES_UNLIMITED_TELEGRAM_ID");
//
//        from("telegram:bots/" + botId)
//                .bean(bot);
    }

    private static final Logger LOGGER = Logger.getLogger(CamelBuilder.class.getName());
}
