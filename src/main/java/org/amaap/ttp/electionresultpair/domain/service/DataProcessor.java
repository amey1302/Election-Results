package org.amaap.ttp.electionresultpair.domain.service;

import org.amaap.ttp.electionresultpair.domain.model.ConstituencyData;
import org.amaap.ttp.electionresultpair.domain.model.exception.InvalidConstituencyNameException;
import org.amaap.ttp.electionresultpair.domain.model.exception.InvalidElectionDataException;
import org.amaap.ttp.electionresultpair.domain.model.exception.InvalidPartyCodeException;
import org.amaap.ttp.electionresultpair.domain.model.exception.InvalidPartyVotesException;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.util.*;

public class DataProcessor {

    private DataProcessor() {
    }

    public static List<ConstituencyData> processFile(String path) throws InvalidElectionDataException, IOException {

        if (null == path || path.isEmpty() || !path.endsWith(".txt"))
            throw new InvalidPathException("Invalid Path", path);

        if (!isFileContentValid(path))
           return Collections.emptyList();

        List<ConstituencyData> constituencyDataList = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] parts = line.split(",");
                String constituencyName = parts[0].trim();
                Map<String, Integer> partyCodeWithVotes = new HashMap<>();
                for (int i = 1; i < parts.length; i += 2) {
                    String partyCode = parts[i].trim();
                    int votes = Integer.parseInt(parts[i + 1].trim());
                    partyCodeWithVotes.put(partyCode, votes);
                }
                constituencyDataList.add(new ConstituencyData(constituencyName, partyCodeWithVotes));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return constituencyDataList;
    }

    private static boolean isFileContentValid(String path) throws IOException, InvalidElectionDataException{

        BufferedReader fileReader = new BufferedReader(new FileReader(path));
        String line;
        String constituencyConfigFilePath = "D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\main\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\config\\ConstituencyConfig.txt";
        String partyCodeConfigFilePath = "D:\\AMAAP Training\\Projects\\ElectionResultV1\\src\\main\\java\\org\\amaap\\ttp\\electionresultpair\\domain\\config\\PartyCodeConfig.txt";
        while ((line = fileReader.readLine()) != null) {
            String parts[] = line.split(",");
            String constituencyName = parts[0].trim();
            if (!isPresentInConfigFile(constituencyName, constituencyConfigFilePath)) {
                throw new InvalidConstituencyNameException();
            }
            for (int i = 1; i < parts.length; i += 2) {
                String partyCode = parts[i].trim();

                if (!isPresentInConfigFile(partyCode, partyCodeConfigFilePath)) {
                    throw new InvalidPartyCodeException();
                }
                int votes = Integer.parseInt(parts[i + 1].trim());
                if (votes < 0)
                    throw new InvalidPartyVotesException();
            }
        }
        return true;
    }

    private static boolean isPresentInConfigFile(String name, String configFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(configFilePath));
        while (scanner.hasNextLine()) {
            String scannerLine = scanner.nextLine();
            if (scannerLine.equals(name)) {
                return true;
            }
        }
        return false;
    }

}