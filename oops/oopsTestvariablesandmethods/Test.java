public class Test {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar(
                "Tesla" , "Tesla" , "Electric", "750KWH"
        );
        ElectricCar electricCar1 = new ElectricCar(
                "Tesla" , "Tesla" , "Electric", "750KWH"
        );
        System.out.println(electricCar);

        FuelCar fuelCar = new FuelCar(50 , "GLS650" , "BMW");
        System.out.println(fuelCar);
        System.out.println(Car.car_created_count);

    }
}

// final fields are available in the inherited class

