package org.amaap.election.results.model;

import org.amaap.election.results.IO.DataManager;
import org.amaap.election.results.IO.DataReader;
import org.amaap.election.results.IO.exception.FileOperationException;
import org.amaap.election.results.IO.exception.InvalidPartyNameException;

import java.io.FileNotFoundException;
import java.util.Map;

public class    ElectionManager {

    public boolean readFile(String path) throws FileOperationException, FileNotFoundException {
        DataReader dataReader = new DataReader();
        return dataReader.readFile(path);
    }

    public boolean processFile(String path) throws InvalidPartyNameException {
        DataManager dataManager = new DataManager();
        return dataManager.process(path);
    }


    public boolean findVoteCount(Map<String, Map<String, Integer>> electionData) {
        ElectionCounter electionCounter = new ElectionCounter();
        electionCounter.getPartyNameWithMaximumVotes(electionData);
        return !electionCounter.getWinningPartyData().isEmpty() ;
    }
}
