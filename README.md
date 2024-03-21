## OOMD For Election-ManageMent System
### classes for DataOperations
## class DataReader
  - ### Behaviour
    - readFile(path)
## class DataManager
  - ### Behaviour
      - public processFile (path) :- boolean
      - private process() :- hashmap : election data
      - private isValidPartyName() :- boolean
## enum partyCodes 
  - mapping of party name with code

## class ElectionCounter
  - Behaviour
     - public getPartyNameWithMaximumVotes(election Data) :- winning party data
