import java.util.ArrayList;

public class Train {

    private final Engine engine;
    private ArrayList cars; 
    public int max_count;
    public int seat_count;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.fuelCapacity=fuelCapacity;
        this.passengerCapacity=passengerCapacity;  

        this.Engine=Engine(fuelType, fuelCapacity);

       // for (Object i: cars){
            //cars.add(i);
       // }

    }
    
    public Engine getEngine(){
        return this.Engine();
    }

    public Object getCar(int i){
        return cars.get(i);
    }

    public int getMaxCapacity(){
        max_count=0;
        for (Object i:cars){
            max_count += cars.get(i).getCapacity();
        }
        return max_count;
    }

    public int seatsRemaining(){
        seat_count=0;
        for (Object i: cars){
            seat_count+=cars.get(i).seatsRemaining();
        }
        return seat_count;
    }

    public void printManifest(){
        System.out.println("These are the passengers in the train: ");
        for (Object i:cars){
            System.out.println(cars.get(i).printManifest());
        }
    }




}
