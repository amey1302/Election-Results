package org.amaap.election.results.model;

import org.amaap.election.results.IO.DataManager;
import org.amaap.election.results.IO.exception.FileOperationException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ElectionManagerTest {
    @Test
    void shouldAbleToReadDataFromTheFile() throws FileOperationException, FileNotFoundException {
        //arrange
        ElectionManager electionManager = new ElectionManager();
        //act
        boolean isFileReadable = electionManager.readFile("D:\\AMAAP Training\\Projects\\ElectionResults\\src\\test\\java\\org\\amaap\\election\\results\\util\\Data.txt");
        //assert
        assertTrue(isFileReadable);

    }

    @Test
    void shouldAbleToProcessDataFromTheFile() throws FileOperationException, FileNotFoundException {
        //arrange
        ElectionManager electionManager = new ElectionManager();
        //act
        boolean actual = electionManager.processFile("D:\\AMAAP Training\\Projects\\ElectionResults\\src\\test\\java\\org\\amaap\\election\\results\\util\\Data.txt");
        //assert
        assertTrue(actual);

    }
    //Todo: need to work on the voteCount calculator
//    @Test
//    void shouldAbleToCalculateVoteCountFromData() throws FileOperationException, FileNotFoundException {
//        //arrange
//        ElectionManager electionManager = new ElectionManager();
//        //act
//        electionManager.processFile("D:\\AMAAP Training\\Projects\\ElectionResults\\src\\test\\java\\org\\amaap\\election\\results\\util\\Data.txt");
//        boolean actual = electionManager.findVoteCount(DataManager.getElectionData());
//        //assert
//        assertTrue(actual);
//
//    }
}