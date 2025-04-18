public abstract class Car {

    private final String carModel;

    private final String carBrand;

    public static int car_created_count = 0;


    public Car(String carModel, String carBrand) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        car_created_count++;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }
}
