Project Purpose: 
    
    This project aims to create an engine strong enough to outplay humans and test its limits in BlockUdoku consistently. 

BlockUdoku Video Tutorial

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
    
    
Data from 1000 games sample(round reached): 
        20,86,25,33,59,115,11,50,35,29,149,39,63,25,54,16,92,14,47,44,45,49,26,117,
        16,126,20,38,33,49,28,32,32,37,69,40,31,45,62,51,37,22,28,34,63,37,32,29,
        36,84,128,36,23,23,18,81,10,20,13,88,37,144,25,35,42,206,59,19,123,24,65,
        58,36,33,25,15,36,10,44,112,96,69,158,112,55,17,48,47,30,22,18,50,41,26,21,
        13,34,43,33,25,36,14,21,18,35,57,18,15,29,8,55,22,19,37,37,21,12,16,27,49,36,
        34,42,61,87,19,15,95,72,19,67,31,14,13,20,92,70,48,82,16,43,15,14,21,49,43,14,
        30,33,24,51,42,40,73,37,87,61,132,84,75,41,14,53,103,22,162,56,50,42,21,58
        ,34,58,34,111,15,49,19,46,73,21,56,18,56,24,57,69,154,94,34,73,13,58,23,93,
        68,50,29,59,24,26,61,20,31,26,68,53,58,104,28,16,38,30,18,101,63,36,108,31,
        14,78,24,64,52,31,62,64,33,66,28,81,47,27,43,91,74,133,25,16,123,121,40,44,
        19,15,169,41,21,46,18,16,27,24,28,14,25,38,53,32,26,57,35,20,64,21,183,68,
        102,80,63,28,93,21,101,37,114,50,19,9,31,49,22,23,108,97,50,88,28,21,49,42,
        73,13,25,37,45,24,26,60,55,84,22,13,12,19,46,55,26,14,117,115,64,23,132,45,
        15,20,99,35,13,94,52,26,19,34,27,116,19,42,60,82,186,12,19,28,66,50,19,48,24,
        54,21,41,61,39,65,44,95,66,20,158,16,33,37,41,134,17,201,21,56,12,64,32,87,
        21,29,18,29,42,39,16,23,41,98,30,41,36,38,41,13,131,50,11,64,20,21,36,49,154,
        59,15,18,23,37,38,15,31,25,36,28,28,113,66,41,64,40,17,56,26,72,151,25,40,
        24,62,15,19,51,91,29,53,13,32,25,42,15,28,140,60,22,15,29,62,135,15,54,24,22
        ,114,83,51,27,35,32,157,129,42,18,25,15,40,63,50,60,30,77,40,15,81,20,42,38,
        181,23,59,22,19,21,29,77,31,13,11,15,27,21,40,25,25,50,67,155,87,70,36,87,65,
        31,19,81,17,35,69,31,40,41,114,21,83,14,28,19,97,49,94,65,28,39,32,94,31,52,17,
        32,19,150,23,25,37,20,13,23,79,36,160,25,37,33,52,60,25,42,13,69,23,39,73,
        16,61,37,28,27,27,30,10,32,45,59,25,13,47,33,113,14,12,28,77,52,121,35,22,66,
        61,43,18,43,65,28,51,27,23,11,15,166,65,9,55,71,28,26,32,64,78,77,18,38,19,63
        ,18,38,44,45,28,20,103,46,13,29,22,41,80,56,25,32,35,38,11,33,47,63,75,68,
        41,19,16,57,59,127,15,53,76,35,14,21,19,75,25,61,21,32,22,85,25,48,57,33,29 34,163,53,40,12,25,39,97,37,29,12,59,28,29,35,39,206,94,24,49,36,140,14,35,
        53,72,12,35,33,78,63,18,72,78,97,92,18,21,130,80,24,18,33,85,42,90,67,126,25,46,40,59,34,190,30,43,58,14,33,35,48,46,37,12,51,14,49,41,23,31,25,255,
        26,17,20,60,29,27,41,28,71,26,17,41,34,138,31,27,73,54,80,33,110,35,29,43,45,14,35,100,30,29,68,78,59,49,50,43,40,17,24,33,30,28,48,17,60,45,78,118,
        92,56,21,20,41,22,144,163,25,49,13,28,45,32,23,54,13,29,47,20,68,76,57,51,74,23,27,32,14,45,27,61,53,37,18,113,29,36,22,34,27,85,51,70,104,29,14,24,
        105,36,37,153,29,29,12,15,20,35,67,37,18,36,45,41,34,26,28,70,113,65,44,35,38,119,44,48,36,47,15,19,66,17,50,17,90,14,48,49,21,102,33,66,15,24,18,26,155
        ,49,23,20,28,30,137,22,40,42,13,52,16,42,60,50,21,44,89,46,32,95,21,38,19,50,29,48,43,20,90,30,24,40,18,193,76,33,15,27,32,64,54,26,42,32,62,36,57,
        43,46,26,43,31,81,91,43,22,45,98,27,30,22,64,118,101,133,167,14,36,74,81,51,15,44,44,37,26,29,52,20,99,58,14,37,49,57,20,19,17,29,91,66,24,35,70,10,49,
        87,34,77,59,41,30,12,9,94,56,16,33,30,79,45,43,68,19,39,31,45,19,12,32,47,95,43,26,131,34,73,23,15,126,43,47,28,20,31,73,40,45,34,26,33,43,60,63,136,

![1](https://user-images.githubusercontent.com/114194732/236049276-7fa2a3c2-555e-4d32-ad57-70782a76b51f.png)
![2](https://user-images.githubusercontent.com/114194732/236049279-582cc29e-9ef6-4a24-bdad-46473c4f9294.png)
![3](https://user-images.githubusercontent.com/114194732/236049281-76f49cef-145a-400c-b349-92f20ad5882c.png)
![4](https://user-images.githubusercontent.com/114194732/236049299-b5f4b798-197e-451c-92ee-d7318e24aa00.png)
![Confidence Level](https://user-images.githubusercontent.com/114194732/236049502-7e63ac0e-6906-4c2c-9bf3-927d17d09d1f.png)


    
    
