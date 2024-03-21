package org.amaap.election.results.model;

import java.util.HashMap;
import java.util.Map;

public enum PartyCodes {
    BJP("Bhartiya Janta Party"),
    INC("Indian National Congress"),
    BSP("Bahujan Samaj Party"),
    CPI("Communist Party of India"),
    NCP("Nationalist Congress Party"),
    IND("Independant");

    private final String fullName;

    PartyCodes(String fullName) {
        this.fullName = fullName;
    }

    public static String getFullName(String code) {
       for(PartyCodes partyCodes : PartyCodes.values()){
           if(partyCodes.name().equals(code)){
               return partyCodes.fullName;
           }

       }
        return null;
    }
}
