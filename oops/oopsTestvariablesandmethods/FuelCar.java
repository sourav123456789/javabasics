public class FuelCar extends Car{

    private final int fuel_capacity;

    public FuelCar(int fuel_capacity , String carModel , String carBrand){
        super(carModel , carBrand);
        this.fuel_capacity = fuel_capacity;
    }

    @Override
    public String toString() {
        return "FuelCar{" +
                "fuel_capacity=" + fuel_capacity +
                ", carModel='" + super.getCarModel() + '\'' +
                ", carBrand='" + super.getCarBrand() + '\'' +
                '}';
    }

    public int getFuel_capacity() {
        return fuel_capacity;
    }
}
