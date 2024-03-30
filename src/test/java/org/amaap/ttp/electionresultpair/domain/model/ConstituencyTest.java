package org.amaap.ttp.electionresultpair.domain.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstituencyTest {
    @Test
    void shouldBeAbleToCreateConstituency(){
        // arrange
        String expectedConstituencyName ="Pune";

        // act
        Constituency constituency = new Constituency("Pune");
        String actualConstituencyName = constituency.getName();

        // assert
        assertEquals(expectedConstituencyName,actualConstituencyName);
    }
}
