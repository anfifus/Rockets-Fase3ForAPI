import java.util.ArrayList;
import java.util.List;

public class Rocket {
    private final String code;
    private final List<Propellant> propellantList = new ArrayList<>();

    public Rocket(String code) throws Exception {
        checkCode(code);
        this.code = code;
    }

    private void checkCode(String code) throws Exception {
        if (code.length() != 8) throw new Exception("The format of the code is incorrect");
    }




    public String getCode() {
        return code;
    }

    public String getNumOfPropellantWithMaxPower() {
        StringBuilder resultToShow = new StringBuilder();
        for (Propellant currentPropellant : propellantList) {
            resultToShow.append(currentPropellant.getMaxPower()).append(" ");
        }
        return resultToShow.toString();
    }

    public int getThePowerOfAllPropellant() {
        int resultToShow = 0;
        for (Propellant currentPropellant : propellantList) {
            resultToShow+= currentPropellant.getActualPower();
        }
        return resultToShow;
    }

    public void addPropellant(int[] propellant) throws Exception {
        for (int currentPropellantPotency : propellant) {
            propellantList.add(new Propellant(currentPropellantPotency));
        }
    }
    public void increasePower(){
        for (Propellant currentPropellant:propellantList) {
            currentPropellant.updateActualPower(10);
        }
    }
    public void decreasePower(){
        for (Propellant currentPropellant:propellantList) {
            currentPropellant.updateActualPower(-10);
        }
    }
}
