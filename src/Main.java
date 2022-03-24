import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int NUM_ACCELERATION_ROCKETS = 3;
    private static final int NUM_SLOW_DOWN_FIRST_ROCKET = 5;
    private static final int NUM_ACCELERATION_SECOND_ROCKET = 7;
    private static final int NUM_MAX_ACCELERATION_ROCKETS = 15;
    private static final String FIRST_ROCKET = "32WESSDS";
    private static final String SECOND_ROCKET = "LDSFJA32";


    public static void main(String[] args) {
        try {
            List<Rocket> rocketList = createAllRocketWithPropellant();
            showRockets(rocketList);
            moveRockets(rocketList);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static List<Rocket> createAllRocketWithPropellant() throws Exception {
        List<Rocket> rocketList = createAllRocket();

        return rocketList;
    }

    private static List<Rocket> createAllRocket() throws Exception {
        List<Rocket> rocketList = new ArrayList<>();
        Rocket firstRocket = createRocket(FIRST_ROCKET);
        Rocket secondRocket = createRocket(SECOND_ROCKET);
        int[] propellantListPower = {10, 30, 80};
        int[] propellantListPower2 = {30, 40, 50, 50, 30, 10};
        firstRocket.addPropellant(propellantListPower);
        secondRocket.addPropellant(propellantListPower2);

        rocketList.add(firstRocket);
        rocketList.add(secondRocket);

        return rocketList;
    }


    private static Rocket createRocket(String code) throws Exception {
        return new Rocket(code);
    }


    private static void showRockets(List<Rocket> rocketList) {
        for (Rocket currentRocket : rocketList) {
            System.out.println(currentRocket.getCode() + ": " + currentRocket.getNumOfPropellantWithMaxPower());
        }
    }

    private static void moveRockets(List<Rocket> rocketList) throws Exception {
        //accelerateRocketsAndShowResults(rocketList);
        Rocket rocket = null;
        int times = 0;
        times = askNumberOfTimes();

        accelerateRockets(rocket, times);
        //slowDownAndAccelerateAndShowResults(rocketList);
        times = askNumberOfTimes();
        rocket = chooseRocket(rocketList);
        accelerateRocketsThreeTimes(rocketList, times);
        showActualPower(rocketList);
        slowDownAndAccelerate();


        //accelerateRocketsMaxPower(rocketList);

    }


    private static Rocket chooseRocket(List<Rocket> rocketList) throws Exception {
        Scanner scan = new Scanner(System.in);
        return checkRocket(rocketList, scan.nextInt());
    }

    private static Rocket checkRocket(List<Rocket> rocketList, int chooseRocket) throws Exception {
        if (chooseRocket >= rocketList.size()) throw new Exception("Error the rocket we choose doesn't exist");
        return rocketList.get(chooseRocket);
    }

    private static int askNumberOfTimes() {
        Scanner scan = new Scanner(System.in);
        int numTimes = scan.nextInt();
        scan.nextLine();
        return numTimes;
    }

    private static void accelerateRockets(Rocket rocket, int numAccelerationRockets) {
        for (int i = 0; i < numAccelerationRockets; i++) {
            rocket.increasePower();
        }
    }

    private static void slowDownRockets(int numBrakeRockets) {
        rocket = chooseRocket(rocketList);
        for (int i = 0; i < numBrakeRockets; i++) {
            rocket.decreasePower();
        }
    }

    private static void accelerateRocketsAndShowResults(List<Rocket> rocketList) {
        //accelerateFirstRocketThreeTimes(rocketList);
        showActualPower(rocketList);
    }

    private static void accelerateRocketsThreeTimes(List<Rocket> rocketList, int times) {


        for (Rocket currentRocket : rocketList) {
            accelerateRockets(currentRocket, times);
        }
    }

    private static void slowDownAndAccelerateAndShowResults(List<Rocket> rocketList) {
        // slowDownAndAccelerate(rocketList);
        showActualPower(rocketList);
    }

    private static void slowDownAndAccelerate(List<Rocket> rocketList) {
        slowDownRockets(rocket, times);
        for (Rocket currentRocket : rocketList) {
            if (currentRocket.getCode().equals(FIRST_ROCKET)) {
                for (int i = 0; i < NUM_SLOW_DOWN_FIRST_ROCKET; i++) {
                    currentRocket.decreasePower();
                }
            } else {
                for (int i = 0; i < NUM_ACCELERATION_SECOND_ROCKET; i++) {
                    currentRocket.increasePower();
                }
            }
        }
    }

    private static void accelerateRocketsMaxPower(List<Rocket> rocketList) {
        //accelerateMaxPower(rocketList);
        showActualPower(rocketList);
    }

    private static void accelerateMaxPower(List<Rocket> rocketList) {

        for (Rocket currentRocket : rocketList) {
            for (int i = 0; i < NUM_MAX_ACCELERATION_ROCKETS; i++) {
                currentRocket.increasePower();
            }
        }
    }

    private static void showActualPower(List<Rocket> rocketList) {
        for (Rocket currentRocket : rocketList) {
            System.out.println("The rocket: " + currentRocket.getCode() + " the actual power is: " + currentRocket.getThePowerOfAllPropellant());
        }
    }


}
