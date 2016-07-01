package com.ingcomp;

import sun.org.mozilla.javascript.internal.regexp.SubString;

public class Table {
    Variable variables[];
    int values[][];

    public Table(Variable variables[]) {
        constructTable(variables);
    }

    public Table(String sVariables[]) {
        Variable variables[] = new Variable[sVariables.length];

        for(int i = 0; i < variables.length; i++) {
            variables[i] = new Variable(sVariables[i]);
        }
        constructTable(variables);
    }

    private void constructTable(Variable variables[]) {
        try {
            setVariables(variables);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        generateValues();
    }

    public Variable[] getVariables() {
        return variables;
    }

    public void setVariables(Variable variables[]) throws Exception {
        if(variables.length < 1) {
            throw new Exception("Cannot create table without variables!");
        } else {
            this.variables = variables;
        }
    }

    private void generateValues() {
        int varNum = variables.length;
        int rows;
        if(varNum == 1) {
            rows = 2;
        } else {
            rows = varNum * varNum;
        }
        int i, j;
        String sValues;
        values = new int[rows][varNum];

        for(i = 0; i < rows; i++) {
            // Get value
            sValues = Integer.toBinaryString(i);

            // Add ceros
            while (sValues.length() < varNum) {
                sValues = "0" + sValues;
            }

            //Convert String to int[][]
            for(j = 0; j < varNum; j++) {
                values[i][j] = Integer.parseInt(sValues.substring(j, j+1));
            }
        }
    }

    public void print(String types) {
        int lineSpaces = 0;
        int rowNum = 0;

        if(types.contains(PrintingType.TRUTH_TABLE.toString())) {
            System.out.println();
            for(Variable variable : variables) {
                System.out.printf("%5s", variable.getName());
                lineSpaces = lineSpaces + 5;
            }

            if(types.contains(PrintingType.MINITERM.toString())) {
                System.out.printf("%12s", PrintingType.MINITERM.toString());
                lineSpaces = lineSpaces + 12;
            }

            printVerticalLine(lineSpaces);

            for(int[] row : values) {
                for(int value : row) {
                    System.out.printf("%5s", value);
                }

                if(types.contains(PrintingType.MINITERM.toString())) {
                    System.out.printf("%9s", "m" + rowNum);
                    rowNum++;
                }

                System.out.println();
            }
        }
    }

    private void printVerticalLine(int lineSpaces) {
        int col = lineSpaces + 5;
        System.out.println();
        while(col > 0) {
            System.out.print("-");
            col--;
        }
        System.out.println();
    }
}
