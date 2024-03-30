package org.amaap.ttp.electionresultpair.domain;

import org.amaap.ttp.electionresultpair.domain.model.ConstituencyData;
import org.amaap.ttp.electionresultpair.domain.service.DataProcessor;

import java.util.Collections;
import java.util.List;

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
}
