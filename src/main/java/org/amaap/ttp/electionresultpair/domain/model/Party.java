package org.amaap.ttp.electionresultpair.domain.model;

public class Party {
    private String code;
    private String name;

    public Party(String code, String name) {
        this.code = code;
        this.name = name;
    }
    //Todo: Config. file data validation

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
