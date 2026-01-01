package de.thm.mni.oop;

record Action(char write, Move move, String toState) {
    @Override
    public String toString(){
        return write + "   " + (move == Move.LEFT ? "L" : "R") + "   " + toState;
    }
}