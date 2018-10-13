package com;

import java.lang.StringBuffer;

public class CodeSnippets {
    public static void main(String[] args) {
       /* String str = "Harshit";
        str.concat(" Agarwal");
        System.out.println(str);*/

        StringBuffer str = new StringBuffer("Harshit");
        str.append(" Agarwal");
        System.out.println(str);
    }
}

//Testing sync