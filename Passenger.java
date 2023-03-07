import java.lang.invoke.TypeDescriptor;

/*
 * Passenger constructor, can boardCar, getOffCar, and getName
 * @param: name
 */
public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    /*
     * Adds a passenger to a car. 
     * @param: Car c 
     */
    public void boardCar(Car c){
        try{
            c.addPassenger(this);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    /*
     * Removes a passenger from a car. 
     * @param: Car c 
     */
    public void getOffCar(Car c){
        try{
            c.removePassenger(this);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    /*
     * Returns the name of a passenger.
     * @return: this.name 
     */
    public String getName(){
        return this.name;
    }
}
