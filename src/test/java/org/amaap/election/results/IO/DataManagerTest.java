package org.amaap.election.results.IO;

import org.amaap.election.results.IO.exception.InvalidPartyNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DataManagerTest {

    @Test
    void shouldAbleToThrowAnExceptionWhenPartyNameIsInvalid() {
        DataManager dataManager = new DataManager();
        assertThrows(InvalidPartyNameException.class, () -> {
            dataManager.process("D:\\AMAAP Training\\Projects\\ElectionResults\\src\\test\\java\\org\\amaap\\election\\results\\util\\invalidaData.txt");
        });
    }

}