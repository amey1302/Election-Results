package org.amaap.ttp.electionresultpair.domain;

import org.amaap.ttp.electionresultpair.domain.model.ConstituencyData;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionManagerTest {
    @Test
    void shouldBeAbleToProcessDataFromFile() throws Exception {
        // arrange
        List<ConstituencyData> expectedConstituencyData = new ArrayList<>();
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
        expectedConstituencyData.add(constituencyData);
        expectedConstituencyData.add(constituencyData1);

        // act
        ElectionManager electionManager = ElectionManager.getElectionManager();
        List<ConstituencyData> actualConstituencyData = electionManager.processFile("D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\test\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\model\\util\\ElectionData.txt");

        // assert
        assertEquals(expectedConstituencyData, actualConstituencyData);
    }

    @Test
    void shouldBeAbleToReturnWinnerOfConstituency() throws Exception {
        // arrange
        Map<String, String> expectedWinnerForConstituency = new LinkedHashMap<>();
        expectedWinnerForConstituency.put("Pune","BJP");
        expectedWinnerForConstituency.put("Satara","BJP");

        // act
        ElectionManager electionManager = ElectionManager.getElectionManager();
        List<ConstituencyData> listOfConstituencyData = electionManager.processFile("D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\test\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\model\\util\\ElectionData.txt");
        Map<String, String> actualWinnerForConstituency = electionManager.getWinnerForConstituency(listOfConstituencyData);

        // assert
        assertEquals(expectedWinnerForConstituency,actualWinnerForConstituency);
    }
}