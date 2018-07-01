package com.moberan.zoops.t1kotlin;

import java.util.Objects;

public class D02 {
    private String s1 = "";
    private int i1 = 0;

    @Override
    public String toString() {
        return "D02{" +
                "s1='" + s1 + '\'' +
                ", i1=" + i1 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof D02)) return false;
        D02 d02 = (D02) o;
        return i1 == d02.i1 &&
                Objects.equals(s1, d02.s1);
    }

    @Override
    public int hashCode() {

        return Objects.hash(s1, i1);
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }
}
