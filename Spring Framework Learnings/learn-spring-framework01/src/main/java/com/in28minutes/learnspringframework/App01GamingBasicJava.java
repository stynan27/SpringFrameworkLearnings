package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacMan;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        //var game = new MarioGame();
        //var game = new SuperContraGame();
        var game = new PacMan(); // Object Creation

        // Object Creation + Wiring Dependencies
        // Game is a Dependency of GameRunner
        var gameRunner = new GameRunner(game); 

        gameRunner.run();
    }
}
