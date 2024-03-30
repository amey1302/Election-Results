package org.amaap.ttp.electionresultpair.domain.model;

import com.mysql.cj.util.DnsSrv;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartyTest {
    @Test
    void shouldBeAbleToCreateParty(){
        // arrange
        String expectedCode = "BJP";
        String expectedName = "Bhartiya Janta Party";

        // act
        Party party = new Party("BJP","Bhartiya Janta Party");
        String actualCode = party.getCode();
        String actualName = party.getName();

        // assert
        assertEquals(expectedCode,actualCode);
        assertEquals(expectedName,actualName);
    }
}
