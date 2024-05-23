package com.example.ex4;

import java.io.Serializable;

public class CustomData implements Serializable {

    private int n1;
    private int n2;

    public enum Mode{

        ADD,MULTIPLY,SUBTRACT
    }

    private Mode mode;

    public CustomData(int n1, int n2, Mode mode) {
        this.n1 = n1;
        this.n2 = n2;
        this.mode = mode;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public Mode getMode() {
        return mode;
    }
}
