import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class Car {

    //initialize variables
    private ArrayList passengersOnboard;
    private int maxCapacity;

    //constructor
    public Car(int maxCapacity){
        this.maxCapacity= maxCapacity;
        ArrayList passengersOnboard= new ArrayList();
    }

    //accessor like methods
    public int getCapacity(){
        return this.maxCapacity;
    }
    public int seatsRemaining(){
        if (passengersOnboard.isEmpty()){
            return this.maxCapacity;
        }
        else{
            return this.maxCapacity-passengersOnboard.size();
        }
    }

    //add a passenger
    public void addPassenger(Passenger p){
        if (seatsRemaining()==0){
            throw new RuntimeErrorException(null, "No more seats remaining. Can't add passenger.");
        }
        else{
            passengersOnboard.add(p);
        }
    }
    //remove a passenger
    public void removePassenger(Passenger p){
        if (!passengersOnboard.contains(p)){
            throw new RuntimeErrorException(null, "Passenger is not on the car.");
        }
        else{
            passengersOnboard.remove(passengersOnboard.indexOf(p));
        }
    }
    //print manifest
    public void printManifest(){
        if (passengersOnboard.size()==0){
            System.out.println("This car is EMPTY!");
        }
        else{
            for (Object i: passengersOnboard){
                System.out.println(i);
            }
        }
    }


}