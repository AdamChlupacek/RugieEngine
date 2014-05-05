package com.rugieCorp.engine.util;

import com.rugieCorp.engine.gameobject.GameObject;
import com.rugieCorp.engine.util.dt.Vector2f;
import com.rugieCorp.engine.util.dt.Vector3f;

/**
 * User: Adam Chlupacek
 * Date: 02/03/14
 * Time: 00:05
 * Package: com.rugieCorp.engine.util
 */
public class Distance {

    public static Vector3f getDistance(GameObject entity1, GameObject entity2){
        return entity1.getPosition().sub(entity2.getPosition());
    }

}
