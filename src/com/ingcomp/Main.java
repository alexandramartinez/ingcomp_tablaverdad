package com.ingcomp;

public class Main {

    public static void main(String[] args) {
        String vars[] = new String[]{
                "A", "B", "C", "D"
        };
        Table t = new Table(vars);
        t.print(PrintingType.TRUTH_TABLE.toString()
                + PrintingType.MINITERM.toString()
                + PrintingType.MAXTERM.toString()
        );
    }
}
