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
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }

}