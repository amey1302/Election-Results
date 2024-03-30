package org.amaap.ttp.electionresultpair.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionResult {
    public Map<String, String> getWinnerForConstituency(List<ConstituencyData> listOfConstituencyData) {
        Map<String, String> winnerDataList = new HashMap<>();

        for (ConstituencyData constituency : listOfConstituencyData) {
            String constituencyName = constituency.getName();
            Map<String, Integer> partyWithVotes = constituency.getPartyCodeWithVotes();
            String winningPartyCode = null;
            int maxVotes = Integer.MIN_VALUE;

            for (Map.Entry<String, Integer> entry : partyWithVotes.entrySet()) {
                String partyCode = entry.getKey();
                int votes = entry.getValue();
                if (votes > maxVotes) {
                    winningPartyCode = partyCode;
                    maxVotes = votes;
                }
            }
            if (winningPartyCode != null) {
                winnerDataList.put(constituencyName, winningPartyCode);
            }
        }
        return winnerDataList;
    }
}
