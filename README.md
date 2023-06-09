<h1>BlockUdoku Engine Solver</h1>
<h5>By Josue Arreaga</h5>
    
This project aims to create an engine strong enough to outplay humans and test its limits in BlockUdoku. 

<h3>What is BlockUdoku?</h3>

https://www.youtube.com/watch?v=B4ovtYYFUmM&ab_channel=Easybrain
   
<h3>How does the engine work?</h3> 
   
We start with an interactive board that detects whether a given piece fits. Next, we Iterate through the board, and in every location where the 
piece fits, we create a clone of the board and store it in a board ArrayList. Then we compare each possible board to one another and evaluate which is 
best. We do this for each of the three randomly generated pieces and save the best boards in a new ArrayList. Then we move on to our permutation method, which 
analyses the six possibilities to play the board best. Notice we can play the pieces in the following orders:
        123, 132, 213, 231, 312, 321. 
This method also considers null exceptions (imagine piece 2 does not fit, but pieces 1 and 3 fit). Afterward, we play the board in which all three pieces fit with the 
highest score.The game is terminated if all three pieces do not fit on any board.  
    
<h3>How are the board's positions analyzed?</h3>  

Our current implementation only utilizes two fields to analyze the best board:
* The first field analyses which move leads to a board with the least amount of squares (a move may lead to pieces poping and freeing space in the board)
* The second field analyses in which board do most pieces fit (a board where more pieces fit will be more likely to accommodate all our three pieces)
    
<h3>How are the parameters tested?</h3> 

For each parameter and method evaluation implementation, we ran the program 1000 times and analyzed the median, mean, and margin of error to maximize our program's
computation power. These test cases can all be in our file called "Parameters Test.
    
<h3>How Strong is the program?</h3> 
    
Based on a sample size of 1,000 games played:
* Our game has a mean, x = 48.139 completed rounds (each round must play all three pieces) 
* A Standard Deviation of 34.86 rounds.

<h3>How Does the program compare to humans?</h3> 

As a human, reaching round 48 (our program's average) is possible, and in general, 48 rounds is considered a good game. Our program can achieve a score of 80 rounds 
20% of the time, insanely good games. It currently has a max score of 255 rounds is a high score worthy of showing off to any friends. 
    
    
<h3>Data from 1000 sample games(round reached)</h3> 

![1](https://user-images.githubusercontent.com/114194732/236049276-7fa2a3c2-555e-4d32-ad57-70782a76b51f.png)
![2](https://user-images.githubusercontent.com/114194732/236049279-582cc29e-9ef6-4a24-bdad-46473c4f9294.png)
![3](https://user-images.githubusercontent.com/114194732/236049281-76f49cef-145a-400c-b349-92f20ad5882c.png)
![4](https://user-images.githubusercontent.com/114194732/236049299-b5f4b798-197e-451c-92ee-d7318e24aa00.png)

![Std](https://user-images.githubusercontent.com/114194732/236053369-4465deb7-d0c7-49d5-a2c5-f9effd842b77.png)
![Confidence Level](https://user-images.githubusercontent.com/114194732/236049502-7e63ac0e-6906-4c2c-9bf3-927d17d09d1f.png)

<h6>Graphs and Calculations made through Calculator.net</h6>

<h3>Self reflection and Extras</h3>

This project was my biggest challenge up to today, and it highlights the best of my skills. Many areas often overwhelm me, but resilience and consistency
lead to steadfastness. The two biggest challenges were these: cloning a board in Java composed of a 2D array of Squares and utilizing permutations efficiently 
to find the best board. <b>Special thanks to Samuel Christie</b> for helping me with the Clonable interface, something above my pay grade. While this program 
is not the most potent blockUdoku engine available, I am satisfied with my work. I created nodes representing each piece, utilized abstract classes, 
polymorphism, interfaces, try-and-catch blocks, and a lot more. 
<hr> </hr>
<h5>Possible future implementations include:</h5>

* The addition of a new parameter for our board evaluation, white space clustering. 

Too many white spaces on the board at random locations affect the pieces we can place. In other words, we want our pieces 
to be as close to each other as possible with no white spaces or gaps in between.
    
