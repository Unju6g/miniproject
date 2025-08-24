abstract class Vehicle{
    String brand;
    int speed;

    Vehicle(String brand ,int speed){
        this.brand=brand;
        this.speed= speed;

    }
    abstract void start();
    void displayInfo(){
        System.out.println("brand:"+brand);
        System.out.println("speed:"+speed+"km/h");
    }

}
interface FuelEfficient{
    double calculateMileage();
}
class Car extends Vehicle implements FuelEfficient{
    int fuel;
    int distance;
    Car(String brand,int speed,int fuel,int distance){
        super(brand,speed);
        this.fuel=fuel;
        this.distance=distance;
    }
    @Override
    void start(){
        System.out.println(brand+"car is starting with key ignition...");
    }
    @Override
    public double calculateMileage() {
        return(double)distance/fuel;
    }
}
class Bike extends Vehicle implements FuelEfficient{
    int fuel;
    int distance;
    Bike(String brand,int speed,int fuel,int distance) {
        super(brand,speed);
        this.fuel=fuel;
        this.distance=distance;
    }
    @Override
    void start(){
        System.out.println(brand+"bike is starting with self-start...");

    }
    @Override
    public double calculateMileage(){
        return(double)distance/fuel;
    }
}
public class assingment3_Q1 {
    public static void main(String[] args){
        Car car=new Car("toyota",180,20,300);
        Bike bike = new Bike("yamaha",120, 5 , 150);
        car.start();
        car.displayInfo();
        System.out.println("Car Mileage: " + car.calculateMileage() + " km/l\n");
        bike.start();
        bike.displayInfo();
        System.out.println("Bike Mileage: " + bike.calculateMileage() + " km/l");

    }
}

