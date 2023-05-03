<h1>Project Purpose</h1> 
    
    This project aims to create an engine strong enough to outplay humans and test its limits in BlockUdoku. 

<h3>What is BlockUdoku?</h3>

    https://www.youtube.com/watch?v=B4ovtYYFUmM&ab_channel=Easybrain
   
How does the engine work? 
   
    We start with an interactive board that detects whether a given piece fits. Next, we Iterate through the board, and in every location where the 
    piece fits, we create a clone of the board and store it in a board ArrayList. Then we compare each possible board to one another and evaluate which is 
    best. We do this for each of the three randomly generated pieces and save the best boards in a new ArrayList. Then we move on to our permutation method, which 
    analyses the six possibilities to play the board best. Notice we can play the pieces in the following orders: 123, 132, 213, 231, 312, 321. This method also 
    considers null exceptions (imagine piece 2 does not fit, but pieces 1 and 3 fit). Afterward, we play the board in which all three pieces fit with the highest score.
    The game is terminated if all three pieces do not fit on any board.  
    

How are the board's positions analyzed?  

    Our current implementation only utilizes two fields to analyze the best board:
    * The first field analyses which move leads to a board with the least amount of squares (a move may lead to pieces poping and freeing space in the board)
    * The second field analyses which board most pieces fit (a board where more pieces fit will be more likely to accommodate all our three pieces)
    
How are the parameters tested? 

    For each parameter and method evaluation implementation, we ran the program 1000 times and analyzed the median, mean, and margin of error to maximize our program's
    computation power. These test cases can all be in our file called "Parameters Test.
    
How Strong is the program? 
    
    Based on a sample size of 1,000 games played:
    * Our game has a mean, x = 48.139 completed rounds (each round must play all three pieces) 
    * A Standard Deviation of 34.86 rounds.

How Does the program compare to humans? 

    As a human, reaching round 48 (our program's average) is possible, and in general, 48 rounds is considered a good game. Our program can achieve a score of 80 rounds 
    20% of the time, an insanely good game. It currently has a max score of 255 rounds is a high score worthy of showing off to any friends. 
    
    
Data from 1000 sample games(round reached): 

![1](https://user-images.githubusercontent.com/114194732/236049276-7fa2a3c2-555e-4d32-ad57-70782a76b51f.png)
![2](https://user-images.githubusercontent.com/114194732/236049279-582cc29e-9ef6-4a24-bdad-46473c4f9294.png)
![3](https://user-images.githubusercontent.com/114194732/236049281-76f49cef-145a-400c-b349-92f20ad5882c.png)
![4](https://user-images.githubusercontent.com/114194732/236049299-b5f4b798-197e-451c-92ee-d7318e24aa00.png)

![Std](https://user-images.githubusercontent.com/114194732/236053369-4465deb7-d0c7-49d5-a2c5-f9effd842b77.png)
![Confidence Level](https://user-images.githubusercontent.com/114194732/236049502-7e63ac0e-6906-4c2c-9bf3-927d17d09d1f.png)

Graphs and Calculations made through Calculator.net

    
    
