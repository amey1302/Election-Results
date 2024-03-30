package org.amaap.ttp.electionresultpair.domain.model.exception;

public class InvalidFileContentException extends InvalidElectionDataException {
    public InvalidFileContentException(StringBuilder message) {
        super(String.valueOf(message));
    }
}
