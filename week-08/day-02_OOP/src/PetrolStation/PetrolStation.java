package PetrolStation;

public class PetrolStation {
    public static void main(String[] args) {

        Station station1 = new Station(500);
        Car audi = new Car();
        Car opel = new Car();

        station1.refill(audi);
        station1.refill(opel);
        System.out.println(audi.gasAmountOfCar);
        System.out.println(opel.gasAmountOfCar);
        System.out.println(station1.gasAmountOfStation);

    }
}
//Create Station and Car classes
//Station
//gasAmount
//refill(car) -> decreases the gasAmount by the capacity of the car and increases the cars gasAmount
//Car
//gasAmount
//capacity
//create constructor for Car where:
//initialize gasAmount -> 0
//initialize capacity -> 100