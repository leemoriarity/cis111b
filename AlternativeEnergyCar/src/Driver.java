import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        List<AlternativeEnergyCar> cars = new ArrayList();
        cars.add(new BatteryElectricAECar(2022, "Tesla", "Model S", 94490, "Hatchback" , "AWD", 670, 155, "407V Lithium-ion", 405, 120, "Supercharger"));
        cars.add(new HybridElectricAECar(2022,"Toyota", "Prius LE", 25835, "Hatchback", "FWD", 121, 101,  "1.3KWh Lithium-ion",25, 519.4, 52, "1.8L inline 4-cylinder", "Unleaded",11.3));
        cars.add(new HydrogenFuelAECar(2021, "Honda", "Clarity Fuel Cell", 58490, "Sedan", "FWD", 170, 103, 360, "Hydrogen Fuel Cell Stack w/Electric Motor", "Hydrogen", 5.46, 68, "1.7kW Lithium-ion"));

        List<AlternativeEnergyCar> sortedCars = new ArrayList();
        sortedCars.add(new BatteryElectricAECar(2022, "Tesla", "Model S", 94490, "Hatchback" , "AWD", 670, 155, "407V Lithium-ion", 405, 120, "Supercharger"));
        sortedCars.add(new HybridElectricAECar(2022,"Toyota", "Prius LE", 25835, "Hatchback", "FWD", 121, 101,  "1.3KWh Lithium-ion",25, 519.4, 52, "1.8L inline 4-cylinder", "Unleaded",11.3));
        sortedCars.add(new EthanolFuelAECar(1979, "Fiat", "147", 4000,"Hatchback", "FWD", 68, 93, 200,"1.3-litre 60hp powertrain", "E100", 9.8, 38));
        sortedCars.add(new HydrogenFuelAECar(2021, "Honda", "Clarity Fuel Cell", 58490, "Sedan", "FWD", 170, 103, 360, "Hydrogen Fuel Cell Stack w/Electric Motor", "Hydrogen", 5.46, 68, "1.7kW Lithium-ion"));

        Collections.sort(sortedCars);
        for (AlternativeEnergyCar car : sortedCars) {
            System.out.println(car);
        }
    }
}