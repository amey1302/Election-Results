package org.amaap.election.results.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProcessor {

    public static boolean process(String path) {
        File file = new File(path);

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
            Map<String, Map<String, Integer>> electionData = processFile(fileReader);
            fileReader.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Map<String, Map<String, Integer>> processFile(BufferedReader fileReader) throws IOException {
        Map<String, Map<String, Integer>> electionData = new HashMap<>();
        String line;
        while ((line = fileReader.readLine()) != null) {
            String parts[] = line.split(", ");
            String constituencyName = parts[0];
            Map<String, Integer> partyVotes = new HashMap<>();
            for (int i = 0; i < parts.length; i += 3){
                String partyName = parts[i].trim(); // party name
                int votes;
                try {
                    votes = Integer.parseInt(parts[i+1].trim()); // party votes
                }catch (NumberFormatException e){
                    votes = 0;
                }
                partyVotes.put(partyName,votes);

            }
            electionData.put(constituencyName,partyVotes);

        }
        return electionData;
    }
}
