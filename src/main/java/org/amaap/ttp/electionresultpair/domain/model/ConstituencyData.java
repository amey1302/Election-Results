package org.amaap.ttp.electionresultpair.domain.model;

import java.util.Map;
import java.util.Objects;

public class ConstituencyData {
    private String name;
    private Map<String, Integer> partyCodeWithVotes;

    public ConstituencyData(String name, Map<String, Integer> partyCodeWithVotes) {
        this.name = name;
        this.partyCodeWithVotes = partyCodeWithVotes;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getPartyCodeWithVotes() {
        return partyCodeWithVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstituencyData that = (ConstituencyData) o;
        return Objects.equals(name, that.name) && Objects.equals(partyCodeWithVotes, that.partyCodeWithVotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, partyCodeWithVotes);
    }
}
