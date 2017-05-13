package org.heroesunlimited.infra;

import org.apache.camel.component.telegram.model.IncomingMessage;
import org.apache.camel.component.telegram.model.OutgoingTextMessage;
import org.springframework.stereotype.Component;

@Component
public class UnlimitedHeroBot {

    public OutgoingTextMessage process(IncomingMessage message) {
        return null;
    }

}
