import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FIRST_ROCKET = "32WESSDS";
    private static final String SECOND_ROCKET = "LDSFJA32";


    public static void main(String[] args) {
        try {
            List<Rocket> rocketList = createAllRocket();
            showRockets(rocketList);
            moveRockets(rocketList);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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

    private static void moveRockets(List<Rocket> rocketList) throws Exception{
        do {
            Rocket rocket = selectRocket(rocketList);

            int timesAccelerate = selectHowManyTimes("accelerate");
            accelerate(rocket,timesAccelerate);

            int timesSlowdown = selectHowManyTimes("slowdown");
            slowDown(rocket,timesSlowdown);

            showActualPower(rocketList);
        }
        while(wantContinue());

    }

    private static boolean wantContinue() {
        System.out.println("Want to continue?");
        return (new Scanner(System.in).nextLine().equalsIgnoreCase("Y"));
    }

    private static void slowDown(Rocket rocket, int timesSlowdown) {
        for (int i = 0; i < timesSlowdown; i++) {
            rocket.decreasePower();
        }
    }

    private static void accelerate(Rocket rocket, int times) {
        for (int i = 0; i < times; i++) {
            rocket.increasePower();
        }
    }

    private static int selectHowManyTimes(String action) {
        System.out.println("How many times do you want "+ action+ "?");
        Scanner s = new Scanner(System.in);
        int times = s.nextInt();
        s.nextLine();
        return times;
    }

    private static Rocket selectRocket(List<Rocket> rocketList) throws Exception{
        System.out.println("What rocket do  you want to choose?");
        Scanner s = new Scanner(System.in);
        int selectRocket = s.nextInt();
        s.nextLine();
        if (rocketList.isEmpty()){
            throw new Exception("We don't have any rocket");
        }
        else{
            if(rocketList.size() < selectRocket || selectRocket < 0){
                throw new Exception("Error when selecting a rokcet");
            }
            else{
                return rocketList.get(selectRocket);
            }
        }
    }

    private static void showActualPower(List<Rocket> rocketList) {
        for (Rocket currentRocket : rocketList) {
            System.out.println("The rocket: " + currentRocket.getCode() + " the actual power is: " + currentRocket.getThePowerOfAllPropellant());
        }
    }

}
