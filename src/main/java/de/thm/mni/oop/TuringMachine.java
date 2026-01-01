package de.thm.mni.oop;

interface TuringMachine{
    void addTransition(String fromState, char read, char write, Move move, String toState);
    TM step();
    String getTape();
    String getStatus();
}