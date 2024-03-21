package org.amaap.election.results.IO;

import org.amaap.election.results.IO.exception.InvalidPartyNameException;
import org.amaap.election.results.model.PartyCodes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataManager {
    public static Map<String, Map<String, Integer>> electionData = new HashMap<>();

    public static Map<String, Map<String, Integer>> getElectionData() {
        return electionData;
    }

    public static boolean process(String path) throws InvalidPartyNameException {
//        File file = new File(path);

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
            Map<String, Map<String, Integer>> electionData = processFile(fileReader);
            fileReader.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Map<String, Map<String, Integer>> processFile(BufferedReader fileReader) throws IOException, InvalidPartyNameException {

        String line;
        while ((line = fileReader.readLine()) != null) {
            String parts[] = line.split(", ");
            String constituencyName = parts[0];
            Map<String, Integer> partyVotes = new HashMap<>();
            for (int i = 1; i < parts.length; i += 2) {
                String partyName = parts[i].trim(); // party name
                if (!isValidPartyName(partyName))
                    throw new InvalidPartyNameException("Invalid Party Name" + partyName);
                int votes;
                try {
                    votes = Integer.parseInt(parts[i + 1].trim()); // party votes
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    continue;
                }
                partyVotes.put(partyName, votes);

            }
            electionData.put(constituencyName, partyVotes);

        }
        return electionData;
    }

    private static boolean isValidPartyName(String partyName) {
        for (PartyCodes partyCodes : PartyCodes.values()) {
            if (partyCodes.name().equals(partyName))
                return true;
        }
        return false;
    }
}
