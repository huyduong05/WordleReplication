# wordlereplication
A replication of Wordle (NYT Minigame) written in Java. 

Wordle Class: 
    Runs the wordle game in main. 


WordBank Class:

    Creates a WordBank object that operates as the game's dictionary of valid words.

    Skills/Techniques used: 
    - Parsing .txt file into an ArrayList


WordCheck Class:
    
    It extends the WordBank Class and performs most of the game operations. 
        Operations include:
        - Checking if the inputed word is a valid word in the WordBank
        - Comparing the indexs of characters within the inputed word and the answer
        - Checking if the inputed word is the right answer

    Skills/Techniques used: 
    - String manipulation
    - Binary Search 


UserInterface Class: 

    Creates a graphical user interface for the game to be played on.

    Skills/Techniques used: 
    - Java Swing/AWT
    - User input/output


