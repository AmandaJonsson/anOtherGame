package Model;

import Model.Intefaces.IDice;

import java.util.Random;

public class Dice implements IDice{

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
