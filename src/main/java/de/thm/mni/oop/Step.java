package de.thm.mni.oop;

record Step(int number, String tape, String state) {
    @Override
    public String toString(){
        return this.number + ":  " + this.tape.toString() + " -- " + this.state;
    }
}