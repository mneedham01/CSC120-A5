import java.lang.invoke.TypeDescriptor;

public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public void boardCar(Car c){
        try{
            c.addPassenger(this);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void getOffCar(Car c){
        try{
            c.removePassenger(this);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void printName(){
        System.out.println(this.name);
    }
}
