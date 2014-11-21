package com.rugieCorp.engine.event;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import com.rugieCorp.engine.util.Logger;

/**
 * User: Adam Chlupacek
 * Date: 30/05/14
 * Time: 12:43
 * Package: com.rugieCorp.engine.event
 */
public class DeadEventListener {

    @Subscribe
    public void deadEvent(DeadEvent event){
        Logger.info("Dead event detected");
    }
}
