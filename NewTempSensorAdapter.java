import newtemp.NewTempSensor.NewTempSensorDriver;
import itec3030.smarthome.standards.ControllerInterface;
import itec3030.smarthome.standards.TemperatureSensor;
import newtemp.NewTempSensor.Observer;
import newtemp.NewTempSensor.Subject;


public class NewTempSensorAdapter implements AbstractNewTempSensorAdapter, TemperatureSensor, Observer{
    protected ControllerInterface c;
    protected String ID;
    protected boolean enabled;
    protected int temperature = 23;
    //protected NewTempSensorDriver subject;  //newly added //Didn't choose this since it is a concrete class
    private Subject subject;  //new


    public NewTempSensorAdapter(Subject sSub){

        subject= sSub;
        subject.registerObserver(this);

    }

    @Override
    public NewTempSensorDriver getAdatptee() {

        return (NewTempSensorDriver)this.subject;  //new //had to cast since must return a concrete Subject class
    }

    @Override
    public void newTemperature(int i) {
        //this.temperature = i; //new
        this.getAdatptee().newTemperature(i); //notifies and call update method
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

    @Override
    public void update(int i) {

        //this.newTemperature(i);
        this.temperature = i;
        System.out.println("Sensor (" + ID +  ") receiving new temperature: " + i);

    }
}
