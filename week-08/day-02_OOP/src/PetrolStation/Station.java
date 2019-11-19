package PetrolStation;

public class Station {

    int gasAmountOfStation;

    public Station() {
    }

    public Station(int gasAmountOfStation) {
        this.gasAmountOfStation = gasAmountOfStation;
    }

    public void refill(Car car) {
        this.gasAmountOfStation -= car.capacity;
        car.gasAmountOfCar += car.capacity;
    }
}
