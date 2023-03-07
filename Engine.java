import javax.management.RuntimeErrorException;

/*
 * 
 */
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
        //Testing Engine.java
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }

        //Testing Car.java
        Car myCar= new Car(100);
        System.out.println("This is my capacity: "+myCar.getCapacity());
        System.out.println("This is the amount of seats remaining: "+myCar.seatsRemaining());
        Passenger firstPassenger= new Passenger("Maggie");
        myCar.addPassenger(firstPassenger);
        myCar.printManifest();
        myCar.removePassenger(firstPassenger);
        myCar.printManifest();

        //Testing Passenger.java
        Passenger secondPassenger=new Passenger("Poppy");
        secondPassenger.boardCar(myCar);
        myCar.printManifest();
        secondPassenger.getOffCar(myCar);
        myCar.printManifest();

        //Testing Train.java
        Train myTrain= new Train(FuelType.ELECTRIC, 100.0,5,2);
        System.out.println("This is my max capacity: "+myTrain.getMaxCapacity());
        System.out.println("These are the seats remaining: "+ myTrain.seatsRemaining());
        myTrain.printManifest();
        myTrain.getCar(3).addPassenger(firstPassenger);
        myTrain.printManifest();
        myTrain.getCar(3).removePassenger(firstPassenger);
        myTrain.printManifest();
        myTrain.getCar(3).addPassenger(secondPassenger);
        myTrain.printManifest();
        myTrain.getCar(3).addPassenger(firstPassenger);
        myTrain.printManifest();
        Passenger thirdPassenger=new Passenger("Leo");
        myTrain.getCar(3).addPassenger(thirdPassenger);//Should cause error

    }

}