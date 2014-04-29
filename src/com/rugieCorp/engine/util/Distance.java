package com.rugieCorp.engine.util;

import com.rugieCorp.engine.gameobject.GameObject;
import com.rugieCorp.engine.util.dt.Vector2f;

/**
 * User: Adam Chlupacek
 * Date: 02/03/14
 * Time: 00:05
 * Package: com.rugieCorp.engine.util
 */
public class Distance {

    public static Vector2f getDistance(GameObject entity1, GameObject entity2){
        return entity1.getPosition().subtract(entity2.getPosition());
    }

}
