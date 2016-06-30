package com.ingcomp;

public class Variable {
    String name;

    public Variable(String name) {
        try {
            setName(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws Exception {
        if(name.isEmpty()) {
            throw new Exception("Cannot create variable.");
        } else {
            this.name = name;
        }
    }
}
