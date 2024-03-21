package org.amaap.election.results.IO;

import org.amaap.election.results.IO.exception.FileNotContainDataException;
import org.amaap.election.results.IO.exception.FileOperationException;
import org.amaap.election.results.IO.exception.PathNotFoundException;

import java.io.File;

public class DataReader {
    public boolean readFile(String path) throws FileOperationException {
        if (path.isEmpty())
            throw new PathNotFoundException("Provide Correct Path");
        File file = new File(path);
        if (file.length() == 0)
            throw new FileNotContainDataException("File is Empty");
        return DataManager.process(path);
    }
}
