# OOMD For Election Result
### pacakge : org.amaap.ttp.electionresultspair.domain

- **config**
  - ConstituencyConfig.txt
  - PartyCodeConfig.txt

- **model**
  - **exception**
    - InvalidConstituencyNameException: Exception thrown when an invalid constituency name is occured.
    - InvalidElectionDataException: Exception thrown when election data is invalid.
    - InvalidFileContentException: Exception thrown when file content is invalid.
    - InvalidPartyCodeException: Exception thrown when an invalid party code is encountered.
    - InvalidPartyVotesException: Exception thrown when invalid party votes are encountered.
  - Constituency: Represents a constituency.
    - **State**
      - private String name: Name of the constituency.
    - **Behavior**
      - Constructor and Getter methods.
  - ConstituencyData: Represents data for a constituency including votes for parties
    - **State**
      - private String name: Name of the constituency.
      - private Map<String,Integer> partyCodeWithVotes: Mapping of party codes to votes.
    - **Behavior**
      - Constructor and Getter methods.
  - Party: Represents a party.
    - **State**
      - private String name
      - private String code
    - **Behavior**
      - Constructor and Getter methods.
  - ElectionResult: Computes the winners for constituencies.
    - **Behavior**
      - getWinnerForConstituency(List<ConstituencyData>): Computes and returns winners for given list of constituency data.

- **service**
  - DataProcessor: Processes election data from a file.
    - **Behavior**
      - public static List<ConstituencyData> processFile(String path): Processes the election data file.
      - private static boolean isFileContentValid(String path): Checks if the file content is valid.
      - private static boolean isPresentInConfigFile(String name, String configFilePath): Checks if a name is present in a configuration file.

- **ElectionManager**
  - **State**
    - private static ElectionManager electionManager: Singleton instance of ElectionManager.
  - **Behavior**
    - public static ElectionManager getElectionManager(): Gets the singleton instance of ElectionManager.
    - public List<ConstituencyData> processFile(String path): Processes the election data file using DataProcessor.
    - public Map<String, String> getWinnerForConstituency(List<ConstituencyData> listOfConstituencyData): Gets the winners for constituencies based on processed data.
