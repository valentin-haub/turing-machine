package de.thm.mni.oop;

import java.util.ArrayList;
import java.util.List;

public class TM implements TuringMachine {
    private Tape tape;
    final char EMPTY;
    private Table table;
    private String state;
    private int counter;
    List<Step> steps;

    TM(char pre, String init, String startState){
        this.tape = new Tape(pre, init);
        this.EMPTY = pre;
        this.table = new Table();
        this.state = startState;
        this.counter = 0;
        this.steps = new ArrayList<>();
        this.steps.add(new Step(this.counter, this.tape.toString(), this.state));
    }

    TM(String init, String startState){
        this('_', init, startState);
    }

    public static TM init(char pre, int head, String init, String startState){
        TM tm = new TM(pre, init, startState);
        tm.tape.setHead(head);
        return tm;
    }


    public void addTransition(Trigger t, Action a){
        this.table.add(t, a);
    }

    public void addTransition(String fromState, char read, char write, Move move, String toState){
        addTransition(new Trigger(fromState, read), new Action(write, move, toState));
    }


    public String getTape(){
        return this.tape.toString();
    }

    public String getStatus(){
        return this.state;
    }


    public TM step(int times){
        for (int i = 0; i < times; i++){
            Action resAction = table.findAction(new Trigger(this.state, this.tape.read()));
            if (resAction == null) return null;
            this.tape.write(resAction.write());
            this.tape.move(resAction.move());
            this.state = resAction.toState();
            this.steps.add(new Step(++this.counter, this.tape.toString(), this.state));
        }
        return this;
    }
    
    public TM step(){
        return this.step(1);
    }

    public TM run(){
        while (this.step() != null){}
        return this;
    }


    public static void main(String[] args) {}


    @Override
    public String toString(){
        String s = "";
        for (Step step : this.steps){
            s += step.toString() + "\n";
        }
        return s;
    }
}