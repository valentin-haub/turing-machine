package de.thm.mni.oop;

import java.util.Map;
import java.util.HashMap;

class Table {
    private Map<Trigger, Action> map;


    Table(){
        this.map = new HashMap<>();
    }
    

    void add(Trigger t, Action a){
        this.map.put(t, a);
    }

    Action findAction(Trigger t){
        if (map.containsKey(t))
            return map.get(t);
        return null;
    }


    @Override
    public String toString(){
        String s = "";
        for (Map.Entry<Trigger,Action> m : this.map.entrySet()){

            s += m.getKey() + " | " + m.getValue() + "\n";
        }
        return s;
    }
}