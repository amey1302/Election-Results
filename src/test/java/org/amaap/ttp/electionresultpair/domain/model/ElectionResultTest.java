package org.amaap.ttp.electionresultpair.domain.model;

import org.amaap.ttp.electionresultpair.domain.ElectionManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ElectionResultTest {
    @Test
    void shouldBeAbleToReturnWinnerOfConstituency() throws Exception {
        // arrange
        Map<String, String> expectedWinnerForConstituency = new LinkedHashMap<>();
        expectedWinnerForConstituency.put("Pune","BJP");
        expectedWinnerForConstituency.put("Satara","BJP");

        List<ConstituencyData>  listOfConstituencyData = new ArrayList<>();
        Map<String,Integer> partyCodeWithVotes = new LinkedHashMap<>();
        Map<String,Integer> partyCodeWithVotes1 = new LinkedHashMap<>();
        partyCodeWithVotes.put("BJP",100003);
        partyCodeWithVotes.put("BSP",1003);
        partyCodeWithVotes.put("IND",3098);
        ConstituencyData constituencyData = new ConstituencyData("Pune", partyCodeWithVotes);
        partyCodeWithVotes1.put("BJP",10023);
        partyCodeWithVotes1.put("INC",1003);
        partyCodeWithVotes1.put("NCP",3098);
        ConstituencyData constituencyData1 = new ConstituencyData("Satara", partyCodeWithVotes1);
        listOfConstituencyData.add(constituencyData);
        listOfConstituencyData.add(constituencyData1);

        // act
        ElectionResult electionResult = new ElectionResult();
        Map<String, String> actualWinnerForConstituency = electionResult.getWinnerForConstituency(listOfConstituencyData);

        // assert
        assertEquals(expectedWinnerForConstituency,actualWinnerForConstituency);
    }
}