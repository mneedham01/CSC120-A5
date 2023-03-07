import java.util.ArrayList;

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
    
    public Engine getEngine(){
        return this.engine;
    }

    public Object getCar(int i){
        return this.cars.get(i);
    }

    public int getMaxCapacity(){
        max_count=0;
        for (Car i: this.cars){
            max_count +=i.getCapacity();
        }
        return max_count;
    }

    public int seatsRemaining(){
        seat_count=0;
        for (Car i: this.cars){
            seat_count+=i.seatsRemaining();
        }
        return seat_count;
    }

    public void printManifest(){
        System.out.println("These are the passengers in the train: ");
        for (Car i: this.cars){
            System.out.println(i.printManifest());
        }
    }

    public static void main()

}


