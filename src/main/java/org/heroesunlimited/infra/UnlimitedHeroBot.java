package org.heroesunlimited.infra;

import org.apache.camel.component.telegram.model.IncomingMessage;
import org.apache.camel.component.telegram.model.OutgoingTextMessage;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UnlimitedHeroBot {

    public OutgoingTextMessage process(IncomingMessage message) {
        if(message == null) {
            return null;
        }
        LOGGER.info(message.toString());
        return null;
    }

    private static final Logger LOGGER = Logger.getLogger(UnlimitedHeroBot.class.getName());
}
