package event;

import character.*;

public class Event {
    public static boolean checkHit(Sanic sanic, Wave wave) {
        if(sanic.x+sanic.sanicSize>wave.x && sanic.x < wave.x){
            if(sanic.y+sanic.sanicSize>=wave.y-wave.height){
              return true;
            }
        }
        return false;
    }
        
}
    

