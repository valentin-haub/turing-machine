package de.thm.mni.oop;

class TMApp{
    public static void main(String[] args){
        TuringMachine tm1 = TM.init('#', 6, "#11000#", "S");
        
        tm1.addTransition("S", '#', '#', Move.LEFT, "S");
        tm1.addTransition("S", '1', '0', Move.RIGHT, "R");
        tm1.addTransition("S", '0', '1', Move.LEFT, "L");

        tm1.addTransition("R", '0', '0', Move.RIGHT, "R");
        tm1.addTransition("R", '1', '1', Move.RIGHT, "R");
        tm1.addTransition("R", '#', '#', Move.LEFT, "W");

        tm1.addTransition("W", '1', '1', Move.RIGHT, "HALT");
        tm1.addTransition("W", '0', '0', Move.RIGHT, "HALT");
        tm1.addTransition("W", '#', '#', Move.RIGHT, "HALT");

        tm1.addTransition("L", '0', '1', Move.LEFT, "L");
        tm1.addTransition("L", '1', '0', Move.RIGHT, "R");
        tm1.addTransition("L", '#', '#', Move.RIGHT, "R");

        while(!tm1.getStatus().equals( "HALT")){
            tm1 = tm1.step();
            System.out.println(tm1.getTape() + " " + tm1.getStatus());
        }
    }
}