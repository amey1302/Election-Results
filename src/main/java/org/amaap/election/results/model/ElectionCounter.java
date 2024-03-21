package org.amaap.election.results.model;

import java.util.HashMap;
import java.util.Map;

public class ElectionCounter {
    private static Map<String, Map<String, Object>> winningPartyData = new HashMap<>();

    Map<String, Integer> totalVoteInCity = new HashMap<>();

    public Map<String, Integer> getTotalVoteInCity() {
        return totalVoteInCity;
    }

    public static Map<String, Map<String, Object>> getWinningPartyData() {
        return winningPartyData;
    }


    public Map<String, Map<String, Object>> getPartyNameWithMaximumVotes(Map<String, Map<String, Integer>> electionData) {
        winningPartyData.clear();
        Map<String, Map<String, Object>> winningPartyData = new HashMap<>();

        for (String constituencyName : electionData.keySet()) {
            Map<String, Integer> partyWithVotes = electionData.get(constituencyName);
            String winningPartyCode = null;
            int maxVotes = Integer.MIN_VALUE;
            int totalVotes = 0;

            // Calculate total votes in the constituency
            for (int votes : partyWithVotes.values()) {
                totalVotes += votes;
            }

            // Determine the winning party
            for (Map.Entry<String, Integer> entry : partyWithVotes.entrySet()) {
                String partyCode = entry.getKey();
                int votes = entry.getValue();

                if (votes > maxVotes) {
                    winningPartyCode = partyCode;
                    maxVotes = votes;
                }
            }
            //storing total vote count in the city
            totalVoteInCity.put(constituencyName,totalVotes);
            // Store only the winning party's data
            if (winningPartyCode != null) {
                Map<String, Object> winnerDataList = new HashMap<>();
                winnerDataList.put(winningPartyCode, maxVotes);

                winningPartyData.put(constituencyName, winnerDataList);
            }
        }

        return winningPartyData;
    }

}
