import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class Car {

    //initialize variables
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    //constructor
    public Car(int maxCapacity){
        this.maxCapacity= maxCapacity;
        this.passengersOnboard= new ArrayList <Passenger>();
    }

    //accessor like methods
    public int getCapacity(){
        return this.maxCapacity;
    }
    public int seatsRemaining(){
        if (this.passengersOnboard.isEmpty()){
            return this.maxCapacity;
        }
        else{
            return this.maxCapacity-this.passengersOnboard.size();
        }
    }

    //add a passenger
    public void addPassenger(Passenger p){
        if (seatsRemaining()==0){
            throw new RuntimeErrorException(null, "No more seats remaining. Can't add passenger.");
        }
        else{
            this.passengersOnboard.add(p);
        }
    }
    //remove a passenger
    public void removePassenger(Passenger p){
        if (!this.passengersOnboard.contains(p)){
            throw new RuntimeErrorException(null, "Passenger is not on the car.");
        }
        else{
            this.passengersOnboard.remove(this.passengersOnboard.indexOf(p));
        }
    }
    //print manifest
    public void printManifest(){
        if (this.passengersOnboard.size()==0){
            System.out.println("This car is EMPTY!");
        }
        else{
            for (int i = 0; i < this.passengersOnboard.size()-1; i++) {
                String name=this.passengersOnboard.get(i).getName();
                System.out.println(name+", ");
              }
            System.out.println(this.passengersOnboard.get(i).getName());
        }
    }
}