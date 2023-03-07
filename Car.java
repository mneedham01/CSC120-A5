import java.util.ArrayList;

import javax.management.RuntimeErrorException;

/*
 * Car constructor, has methods to getCapacity, seatsRemaining, add and remove a passenger, and print a list of passengers onboard.
 * @param: int maxCapacity
 */
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
    /*
     * Returns the max capacity of a car.
     * @return: this.maxCapacity
     */
    public int getCapacity(){
        return this.maxCapacity;
    }

    /*
     * Returns the number of seats remaining. If the car is empty, returns maxCapacity. 
     * @return:remaining seats.
     */
    public int seatsRemaining(){
        if (this.passengersOnboard.isEmpty()){
            return this.maxCapacity;
        }
        else{
            return this.maxCapacity-this.passengersOnboard.size();
        }
    }

    /*
     * Add a passenger, if there are seats remaining. 
     */
    public void addPassenger(Passenger p){
        if (seatsRemaining()==0){
            throw new RuntimeErrorException(null, "No more seats remaining. Can't add passenger.");
        }
        else{
            this.passengersOnboard.add(p);
        }
    }
    /*
     * Remove a passenger, if it is on the train. 
     */
    public void removePassenger(Passenger p){
        if (!this.passengersOnboard.contains(p)){
            throw new RuntimeErrorException(null, "Passenger is not on the car.");
        }
        else{
            this.passengersOnboard.remove(this.passengersOnboard.indexOf(p));
        }
    }
    /*
     * Prints out a list of passengers in the car. 
     */
    //print manifest
    public void printManifest(){
        if (this.passengersOnboard.size()==0){
            System.out.println("This car is EMPTY!");
        }
        else{
            for (int i = 0; i < this.passengersOnboard.size()-1; i++) {
                String name=this.passengersOnboard.get(i).getName();
                System.out.print(name+", ");
              }
            System.out.println(this.passengersOnboard.get(this.passengersOnboard.size()-1).getName());
        }
    }
}