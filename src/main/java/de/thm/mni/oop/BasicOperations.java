package de.thm.mni.oop;

class BasicOperations {
    private BasicOperations(){};

    // Diese Methode dekrementiert eine Binärzahl
    public static void decreaseBinary(String init){
        TM tm = new TM(init, "q0");

        tm.addTransition("q0", '0', '0', Move.RIGHT, "q0");
        tm.addTransition("q0", '1', '1', Move.RIGHT, "q0");
        tm.addTransition("q0", tm.EMPTY, tm.EMPTY, Move.LEFT, "q1");
        tm.addTransition("q1", '0', '1', Move.LEFT, "q1");
        tm.addTransition("q1", '1', '0', Move.RIGHT, "HALT");
        tm.addTransition("q1", tm.EMPTY, tm.EMPTY, Move.RIGHT, "HALT");

        tm.run();
        System.out.println(tm);
    }

    // Diese Methode inkrementiert eine Binärzahl
    public static void increaseBinary(String init){
        TM tm = new TM(init, "q0");

        tm.addTransition("q0", '0', '0', Move.RIGHT, "q0");
        tm.addTransition("q0", '1', '1', Move.RIGHT, "q0");
        tm.addTransition("q0", tm.EMPTY, tm.EMPTY, Move.LEFT, "q1");
        tm.addTransition("q1", '1', '0', Move.LEFT, "q1");
        tm.addTransition("q1", '0', '1', Move.RIGHT, "HALT");
        tm.addTransition("q1", tm.EMPTY, tm.EMPTY, Move.RIGHT, "HALT");

        tm.run();
        System.out.println(tm);
    }

    // Schiebt alle '1' nach rechts auf
    public static void shiftOnesToTheRight(String init){
        TM tm = new TM(init, "q0");

        tm.addTransition("q0", '0', '0', Move.RIGHT, "q0");
        tm.addTransition("q0", '1', '1', Move.RIGHT, "q0");
        tm.addTransition("q0", tm.EMPTY, tm.EMPTY, Move.LEFT, "q1");
        tm.addTransition("q1", '1', '1', Move.LEFT, "q1");
        tm.addTransition("q1", tm.EMPTY, tm.EMPTY, Move.RIGHT, "HALT"); // nicht notwendig
        tm.addTransition("q1", '0', '0', Move.LEFT, "q2");
        tm.addTransition("q2", '0', '0', Move.LEFT, "q2");
        tm.addTransition("q2", tm.EMPTY, tm.EMPTY, Move.RIGHT, "HALT"); // nicht notwendig
        tm.addTransition("q2", '1', '0', Move.RIGHT, "q3");
        tm.addTransition("q3", '0', '0', Move.RIGHT, "q3");
        tm.addTransition("q3", '1', '1', Move.LEFT, "q4");
        tm.addTransition("q4", '0', '1', Move.LEFT, "q1");

        tm.run();
        System.out.println(tm);
    }
}