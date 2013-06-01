package com.aquafx_project.controls.skin.styles;


public class IllegalStyleCombinationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IllegalStyleCombinationException (String s){
        super(s);
    }
    
    public IllegalStyleCombinationException () {
        this("The applied StyleDefinitions cannot be combined");
    }
}
