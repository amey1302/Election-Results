package org.amaap.ttp.electionresultpair.domain.service;

import org.amaap.ttp.electionresultpair.domain.model.exception.InvalidConstituencyNameException;
import org.amaap.ttp.electionresultpair.domain.model.exception.InvalidFileContentException;
import org.amaap.ttp.electionresultpair.domain.model.exception.InvalidPartyCodeException;
import org.amaap.ttp.electionresultpair.domain.model.exception.InvalidPartyVotesException;
import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    @Test
    void shouldBeAbleThrowInvalidPathException(){
        // arrange
        String emptyPath = "";
        String invalidPath = "D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\test\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\service\\DataProcessorTest.java";

        // act & assert
        assertThrows(InvalidPathException.class, ()->{
            DataProcessor.processFile(emptyPath);
        });
        assertThrows(InvalidPathException.class, ()->{
            DataProcessor.processFile(invalidPath);
        });
    }
    @Test
    void shouldBeAbleToThrowInvalidConstituencyNameException(){
        // arrange
        String path = "D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\test\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\model\\util\\InvalidConstituencyName.txt";

        // act & assert
        assertThrows(InvalidConstituencyNameException.class, ()->{
            DataProcessor.processFile(path);
        });

    }
    @Test
    void shouldBeAbleToThrowInvalidPartyCodeException(){
        // arrange
        String path = "D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\test\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\model\\util\\InvalidPartyCode.txt";

        // act & assert
        assertThrows(InvalidPartyCodeException.class, ()->{
            DataProcessor.processFile(path);
        });
    }
    @Test
    void shouldBeAbleToThrowInvalidPartyVotesException(){
        // arrange
        String path = "D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\test\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\model\\util\\InvalidPartyVote.txt";

        // act & assert
        assertThrows(InvalidPartyVotesException.class, ()->{
            DataProcessor.processFile(path);
        });

    }
}