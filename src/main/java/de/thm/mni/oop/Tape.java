package de.thm.mni.oop;

import java.util.List;
import java.util.ArrayList;

class Tape {
    private List<Character> band;
    final private char pre;
    private long head;

    Tape(char pre, String init){
        this.pre = pre;
        this.band = new ArrayList<>();
        char[] initChars = init.toCharArray();
        for (char c : initChars)
            this.band.add(c);
        this.head = 0;
    }

    void setHead(int head){
        while (this.band.size() <= head){
            this.band.add(pre);
        }
        this.head = head;
    }


    char read(){
        return
            this.band.get((int)this.head);
    }

    void write(char c){
        this.band.remove((int)this.head);
        this.band.add((int)this.head, Character.valueOf(c));
    }

    void move(Move m){
        switch (m){
            case Move.LEFT :
                if (this.head == 0)
                    this.band.addFirst(Character.valueOf(this.pre));
                else
                    this.head--;
                break;
            case Move.RIGHT :
                if (++this.head >= this.band.size())
                    this.band.addLast(Character.valueOf(this.pre));
                break;
        }
    }


    @Override
    public String toString(){
        String s = "";
        for (int i = (int)this.head-10; i <= (int)this.head+10; i++){
            if (i > (int)this.head-10)
                s += " ";
            if (i == this.head)
                s += "{" + this.read() + "}";
            else {
                if (i < 0 || i >= this.band.size())
                    s += this.pre;
                else
                    s += this.band.get(i);
            }
        }
        return s;
    }
}