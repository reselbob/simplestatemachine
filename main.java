package com.simplestate;

import java.util.Scanner;

abstract class State{
    static State chase, run, move, rise, die, current;
    void enter(){}
    void update(){}
}

class Chase extends State{

    void enter(){
        System.out.println("Now in the Chase state")
    }

    void update(){
        while(true){
            System.out.println("1. Player dies.");
            System.out.println("2. Player eats power pellet.");
            Scanner s = new Scanner(System.in);
            String input = s.next();
            switch(input){
                case "1":
                    current = move;
                    return;
                case "2":
                    current = run;
                    return;
                default:
                    System.out.println("\n Error: please select a menu item.");
            }
        }
    }
}
class Run extends State {
    void enter() {
        System.out.println("Now in the Run state");
    }

    void update() {
        while (true) {
            System.out.println("1. Player eats Ghost.");
            System.out.println("2. Power pellet wears off.");
            Scanner s = new Scanner(System.in);
            String input = s.next();
            switch (input) {
                case "1":
                    current = die;
                    return;
                case "2":
                    current = chase;
                    return;
                default:
                    System.out.println("\n Error: please select a menu item.");
            }
        }
    }
}
class Move extends State{
    void enter(){System.out.println("Now in the Move state");}
    void update(){
        while(true){
            System.out.println("1. Player respawns");
            Scanner s = new Scanner(System.in);
            String input = s.next();
            if ("1".equals(input)) {
                current = chase;
                return;
            } else {
                System.out.println("\n Error: please select a menu item.");
            }
        }
    }
}
class Rise extends State{
    void enter(){System.out.println("Now in the Rise state");}
    void update(){
        while(true){
            System.out.println("1. Player chase");
            Scanner s = new Scanner(System.in);
            String input = s.next();
            if ("1".equals(input)) {
                current = chase;
                return;
            } else {
                System.out.println("\n Error: please select a menu item.");
            }
        }
    }
}
class Die extends State{
    void enter(){System.out.println("Now in the Die state");}
    void update(){
        while(true){
            System.out.println("1. Player chase");
            Scanner s = new Scanner(System.in);
            String input = s.next();
            if ("1".equals(input)) {
                current = rise;
                return;
            } else {
                System.out.println("\n Error: please select a menu item.");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
	 State.chase = new Chase();
     State.run = new Run();
     State.move = new Move();
     State.die = new Die();
     State.rise = new Rise();
     State.current = State.rise;

     while(true){
         State.current.enter();
         State.current.update();
     }
    }
}
