package org.amaap.ttp.electionresultpair.domain;

import org.amaap.ttp.electionresultpair.domain.ElectionManager;
import org.amaap.ttp.electionresultpair.domain.model.ConstituencyData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionManagerTest {
    @Test
    void shouldBeAbleToProcessDataFromFile() throws Exception {
        // arrange
        List<ConstituencyData> expectedConstituencyData = new ArrayList<>();
        Map<String,Integer> partyCodeWithVotes = new HashMap<>();
        partyCodeWithVotes.put("BJP",100003);
        partyCodeWithVotes.put("IND",3098);
        ConstituencyData constituencyData = new ConstituencyData("Pune", partyCodeWithVotes);
        expectedConstituencyData.add(constituencyData);

        // act
        ElectionManager electionManager = ElectionManager.getElectionManager();
        List<ConstituencyData> actualConstituencyData = electionManager.processFile("D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\test\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\model\\util\\ElectionData.txt");

        // assert
        assertEquals(expectedConstituencyData,actualConstituencyData);
    }
}
