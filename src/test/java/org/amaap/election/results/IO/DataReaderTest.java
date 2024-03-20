package org.amaap.election.results.IO;

import org.amaap.election.results.IO.exception.FileNotContainDataException;
import org.amaap.election.results.IO.exception.FileOperationException;
import org.amaap.election.results.IO.exception.PathNotFoundException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataReaderTest {

    @Test
    void shouldAbleToReadFileFromSystem() throws FileOperationException, FileNotFoundException {
        //Arrange
        DataReader dataReader = new DataReader();
        //Act
        boolean isFileReadable = dataReader.readFile("D:\\AMAAP Training\\Projects\\ElectionResults\\src\\test\\java\\org\\amaap\\election\\results\\util\\Data.txt");

        //assert
        assertTrue(isFileReadable);
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenPathIsEmpty() {
        //Arrange
        DataReader dataReader = new DataReader();
        //Act and Assert
        assertThrows(PathNotFoundException.class, () -> {
            dataReader.readFile("");
        });

    }

    @Test
    void shouldAbleToThrowAnExceptionWhenFilesContainsEmptyData() {
        //Arrange
        DataReader dataReader = new DataReader();
        //Act and Assert
        assertThrows(FileNotContainDataException.class, () -> {
            dataReader.readFile("D:\\AMAAP Training\\Projects\\ElectionResults\\src\\test\\java\\org\\amaap\\election\\results\\util\\emptyfile.txt");
        });

    }

}
