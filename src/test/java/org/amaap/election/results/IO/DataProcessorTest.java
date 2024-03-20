package org.amaap.election.results.IO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
@Test
    void shouldAbleToReadDataFromTheFile(){
    //Arrange
    DataProcessor dataProcessor = new DataProcessor();
    //Act
    boolean isDataReadable = dataProcessor.process("D:\\AMAAP Training\\Projects\\ElectionResults\\src\\test\\java\\org\\amaap\\election\\results\\util\\data.txt");
     //Assert
    assertTrue(isDataReadable);
}
}