package com.code_chef;

import java.util.Scanner;

class TAEDITOR {
    private static Scanner input;
    private static StringBuilder text = new StringBuilder("");

    static void editString(int index, String str) {
        text.insert(index, str);
    }

    static void printString(StringBuilder str, int from, int to) {
        for (int i=from;i<=to;i++)
            System.out.print(str.charAt(i));
        System.out.println();
    }

    public static void main(String[] args) {
        input = new Scanner(System.in);
        long q = Long.parseLong(input.nextLine());

        while (q-- != 0) {
            String query = input.nextLine();
            String[] query_split = query.split("\\s+"); //WHITESPACE REGEX (ANY NUMBER OF WHITESPACES)

            if (query.charAt(0) == '+') {
                editString(Integer.parseInt(query_split[1]), query_split[2]);
            } else {
                printString(text, Integer.parseInt(query_split[1])-1, Integer.parseInt(query_split[2])-1);
            }
        }
    }
}
