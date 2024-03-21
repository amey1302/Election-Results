package org.amaap.election.results.model;

import org.amaap.election.results.IO.DataManager;
import org.amaap.election.results.IO.DataReader;
import org.amaap.election.results.IO.exception.FileOperationException;
import org.amaap.election.results.IO.exception.InvalidPartyNameException;

import java.io.FileNotFoundException;
import java.util.Map;

public class ElectionManager {

    public boolean readFile(String path) throws FileOperationException, FileNotFoundException {
        DataReader dataReader = new DataReader();
        return dataReader.readFile(path);
    }

    public boolean processFile(String path) throws InvalidPartyNameException {
        DataManager dataManager = new DataManager();
        return dataManager.process(path);
    }

//Todo: need to work on the voteCount and the related next function

//    public boolean findVoteCount(Map<String, Map<String, Integer>> electionData) {
//        ElectionCounter electionCounter = new ElectionCounter();
//        electionCounter.getPartyNameWithMaximumVotes(electionData);
//        if(electionCounter.getWinningPartyData().size() !=0) return true;
//        return false;
//
//    }
}
