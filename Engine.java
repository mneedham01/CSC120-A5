import javax.management.RuntimeErrorException;

public class Engine {

    private FuelType fuelType;
    double currentFuelLevel;
    double maxFuelLevel;

    //constructor
    public Engine(FuelType fuelType, double maxFuelLevel){
        this.fuelType=fuelType;
        this.currentFuelLevel=maxFuelLevel;
        this.maxFuelLevel=maxFuelLevel;
    }

    //accessors
    public FuelType getFuelType(){
        return this.fuelType;
    }
    public double getCurrentFuelType(){
        return this.currentFuelLevel;
    }
    public double getMaxFuelLevel(){
        return this.maxFuelLevel;
    }

    //methods
    public void refuel(){
        this.currentFuelLevel=this.maxFuelLevel;
    }
    public void go(){
        if (this.currentFuelLevel==0){
            throw new RuntimeErrorException(null, "Can't go. Fuel Level is at 0.");
        }
        if ((this.currentFuelLevel-this.maxFuelLevel/4)<0){
            throw new RuntimeErrorException(null, "Can't go. Fuel Level is too low.");
        }
        else{
            this.currentFuelLevel=this.currentFuelLevel-this.maxFuelLevel/4;
            System.out.println("Success! The new fuel level is: "+this.currentFuelLevel);
        }
    }

    public static void main(String[] args) {
        //Construct an Engine
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }

        //Construct train 
        Train myTrain= new Train(FuelType.ELECTRIC, 100.0,5,2);

        //Get max capacity, seats remaining, and print manifest        
        System.out.println("This is my max capacity: "+myTrain.getMaxCapacity());
        System.out.println("These are the seats remaining: "+ myTrain.seatsRemaining());
        myTrain.printManifest();

        //Create new passenger, add to Train, print manifest, remove passenger 
        Passenger first= new Passenger("Maggie");
        myTrain.getCar(3).addPassenger(first);
        myTrain.printManifest();
        myTrain.getCar(3).removePassenger(first);
        myTrain.printManifest();


        //Create another passenger, have it board a car, print manifest 
        Passenger second=new Passenger("Greta");
        second.boardCar(myTrain.getCar(3));
        myTrain.printManifest();

        //Try to add two more passengers
        first.boardCar(myTrain.getCar(3));
        myTrain.printManifest();
        Passenger third=new Passenger("Lily");
        third.boardCar(myTrain.getCar(3));

    }

}