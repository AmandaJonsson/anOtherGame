package Objects;


import java.util.Random;

public class Dice {

    public int die;

    public Dice(){
        roll();
    }

    public void roll(){
        Random randomNumber = new Random();
        die = randomNumber.nextInt(6)+1;
        System.out.println(die);
    }
}
