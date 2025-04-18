public class ElectricCar extends Car{

    private final String batteryType;

    private final String batteryPower;

    public ElectricCar(String carModel, String carBrand ,
                       String batteryType , String batteryPower) {
        super(carModel, carBrand);
        this.batteryType = batteryType;
        this.batteryPower = batteryPower;
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "batteryPower='" + batteryPower + '\'' +
                ", batteryType='" + batteryType + '\'' +
                ", carModel='" + super.getCarModel() + '\'' +
                ", carBrand='" + super.getCarBrand() + '\'' +
                '}';
    }

    public String getBatteryType() {
        return batteryType;
    }

    public String getBatteryPower() {
        return batteryPower;
    }
}
