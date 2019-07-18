package com.assertsolutions.events;

import java.util.EventObject;

import org.apache.camel.management.event.ExchangeSendingEvent;
import org.apache.camel.support.EventNotifierSupport;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author
 *
 */
@Component
public class EventNotifier extends EventNotifierSupport {

    @Autowired
    private Logger logger;

    @Override
    public void notify(EventObject event) throws Exception {
        if (event instanceof ExchangeSendingEvent) {
            ExchangeSendingEvent exse = (ExchangeSendingEvent) event;
            logger.warn("{}", exse.getExchange().getIn().getHeaders());
        }
    }

    @Override
    public boolean isEnabled(EventObject event) {
        return true;
    }

}
