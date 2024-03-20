package org.amaap.election.results.IO.exception;

public class PathNotFoundException extends FileOperationException {
    public PathNotFoundException(String message) {
        super(message);
    }
}
