import itec3030.smarthome.standards.ControllerInterface;
import itec3030.smarthome.standards.TemperatureSensor;
import oldtempinc.drivers.OldTempSensor; //newly added

public class OldTempSensorAdapter implements TemperatureSensor{

    protected ControllerInterface c;
    protected String ID;
    protected boolean enabled;
    protected int temperature = 23;
    protected OldTempSensor o= new OldTempSensor();  //newly added
    protected float t; //newly added

    public OldTempSensorAdapter(){

    }

    @Override
    public void newTemperature(int i) {
        t= (float)i;     //new
        o.newTemperature(t);  //new
        this.temperature = (int) o.getTemperature(); //new

    }

    @Override
    public ControllerInterface getController() {
        return this.c;
    }

    @Override
    public void setController(ControllerInterface controllerInterface) {
        this.c = controllerInterface;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public void setID(String s) {
        this.ID = s;
    }

    @Override
    public void enable() {
        this.enabled = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }

    @Override
    public boolean enabled() {
        return this.enabled;
    }

    @Override
    public int getReading() {
        return this.temperature;
    }
}
