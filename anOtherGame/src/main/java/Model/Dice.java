/**
 *  @author: Amanda
 *  Revised by: Everybody.
 *  Responsibility: The logic behind the dice.
 *  Used by: TheLostKitten.
 *  Uses: IDice.
 */

package Model;

import Model.Interfaces.IDice;

import java.util.Random;

public class Dice implements IDice{

    public int die;
    Random randomNumber = new Random();

    public Dice(){
       
    }
    
    public int roll(){
        die = randomNumber.nextInt(6)+1;
        return die;
    }
}
