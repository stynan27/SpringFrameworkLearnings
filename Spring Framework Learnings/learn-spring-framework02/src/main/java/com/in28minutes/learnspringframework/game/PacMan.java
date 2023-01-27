package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

// New Decorator - specifies a component that Spring will manage for us (creates Beans!)
@Component
public class PacMan implements GamingConsole{
    public void up() {
        System.out.println("Eat up");
    };

    public void down() {
        System.out.println("Eat down");
    };

    public void left() {
        System.out.println("Eat left");
    };

    public void right() {
        System.out.println("Eat right");
    };
}
