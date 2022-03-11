public class Propellant {
    private final int maxPower;
    private int actualPower;

    public Propellant(int maxPower) throws Exception {
        checkPower(maxPower);
        this.maxPower = maxPower;
        this.actualPower = 0;
    }

    private void checkPower(int maxPower) throws  Exception{
        if(maxPower <= 0) throw new Exception("The propellant must have maximum power");
    }

    public int getMaxPower() {
        return maxPower;
    }


    public void updateActualPower(int actualPower) {
        this.actualPower += actualPower;
        if(this.actualPower > maxPower){
            this.actualPower = maxPower;
        }
        else if(this.actualPower < 0){
            this.actualPower = 0;
        }
    }

    public int getActualPower() {
        return actualPower;
    }
}
