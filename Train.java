import java.util.ArrayList;

/*
 * Train constructor, can get engine, get a specific car, the maximum capacity of train, the total seats left 
 * in the train, and print a list of passengers in the train. 
 * @param: FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity
 */
public class Train {

    private final Engine engine;
    private ArrayList<Car> cars; 
    public int max_count;
    public int seat_count;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){

        this.engine=new Engine(fuelType, fuelCapacity);

        this.cars= new ArrayList<Car>();

        for (int i = 0; i < nCars; i++) {
            Car c= new Car(passengerCapacity);
            this.cars.add(c);
          }

    }
    
    /*
     * Returns the engine
     * @return: this.engine
     */
    public Engine getEngine(){
        return this.engine;
    }

    /*
     * Returns the car for a given index number. 
     * @param: int i 
     * @returns: car 
     */
    public Car getCar(int i){
        return this.cars.get(i);
    }
    
    /*
     * Returns the maximum number of passengers in the train
     * @returns: max_count 
     */
    public int getMaxCapacity(){
        max_count=0;
        for (Car i: this.cars){
            max_count +=i.getCapacity();
        }
        return max_count;
    }

    /* 
     * Returns maximum number of seats remaining in a train. 
     * @returns: seat_count 
     */
    public int seatsRemaining(){
        seat_count=0;
        for (Car i: this.cars){
            seat_count+=i.seatsRemaining();
        }
        return seat_count;
    }

    /*
     * Prints out a list of the passengers in the train. 
     */
    public void printManifest(){
        System.out.println("These are the passengers in the train: ");
        for (Car i: this.cars){
            i.printManifest();
        }
    }
}


