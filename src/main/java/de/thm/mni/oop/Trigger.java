package de.thm.mni.oop;

record Trigger(String fromState, char read) {
    @Override
    public String toString(){
        return fromState + "   " + read;
    }
}