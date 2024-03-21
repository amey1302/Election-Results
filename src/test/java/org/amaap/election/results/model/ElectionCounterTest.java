package org.amaap.election.results.model;

import org.amaap.election.results.IO.DataManager;
import org.amaap.election.results.IO.DataReader;
import org.amaap.election.results.IO.exception.FileOperationException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectionCounterTest {
    @Test
    void shouldAbleToGetPartyWithMoreNumberOfVotes() throws FileOperationException {
        // Arrange
        DataReader dataReader = new DataReader();
        dataReader.readFile("D:\\AMAAP Training\\Projects\\ElectionResults\\src\\test\\java\\org\\amaap\\election\\results\\util\\electionData.txt");

        // Act
        ElectionCounter electionCounter = new ElectionCounter();
        Map<String, Map<String, Object>> actual = electionCounter.getPartyNameWithMaximumVotes(DataManager.getElectionData());

        Map<String, Map<String, Integer>> expected = Map.ofEntries(

                Map.entry("Pune", Map.of("BJP", 7375)),
                Map.entry("Bangalore", Map.of("INC", 17803))
        );
        System.out.println(expected);
        System.out.println(actual);
        System.out.println(ElectionCounter.getWinningPartyData());

        // Assert
        assertEquals(expected, actual);
    }

}
