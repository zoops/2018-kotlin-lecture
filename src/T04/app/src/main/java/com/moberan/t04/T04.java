package com.moberan.t04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class T04 {

    public static void main(String[] argvs) {
        List l = new ArrayList();
        l.add("String");
        l.add(new Integer(1));

        for ( Object o : l) {
            System.out.println(o);
        }
    }
}
