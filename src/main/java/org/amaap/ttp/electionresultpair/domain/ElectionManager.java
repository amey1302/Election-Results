package org.amaap.ttp.electionresultpair.domain;

import org.amaap.ttp.electionresultpair.domain.model.ConstituencyData;
import org.amaap.ttp.electionresultpair.domain.model.ElectionResult;
import org.amaap.ttp.electionresultpair.domain.service.DataProcessor;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ElectionManager {
    private static ElectionManager electionManager;

    public static ElectionManager getElectionManager() {
        if (electionManager == null) {
            electionManager = new ElectionManager();
        }
        return electionManager;
    }

    private ElectionManager() {
    }

    public List<ConstituencyData> processFile(String path) throws Exception {
        return DataProcessor.processFile(path);
    }

    public Map<String, String> getWinnerForConstituency(List<ConstituencyData> listOfConstituencyData) {
        ElectionResult electionResult = new ElectionResult();
        return electionResult.getWinnerForConstituency(listOfConstituencyData);
    }
    //Todo : partyFullName in Config., problem statement extension remaining
}
