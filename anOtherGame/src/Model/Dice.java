package Model;


import java.util.Random;

public class Dice {

    public int die;
    Random randomNumber = new Random();

    public Dice(){
       
    }
    
    public int roll(){
        die = randomNumber.nextInt(6)+1;
        System.out.println(die);
        return die;
    }
}
