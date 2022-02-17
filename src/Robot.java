import static java.lang.Thread.sleep;

public class Robot {

    private String name;
    private boolean working = false;
    private int age;

    public Robot(String name,int age)
    {
        setName(name);
        setAge(age);
    }

    private void setAge(int age) {
        if (age <= 30)
        {
            this.age = age;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isWorking(){
        return working;
    }

    public int getAge() {
        return age;
    }

    public void talkToRobot() {
        working = true;
    }

    public String getWorkingMsg()
    {
        if(!working)
        {
            throw new IllegalStateException();
        }
        return "I am in working mode";
    }

    public String checkage()
    {
        if (age <= 20){ return "Age ok"; } else { return "Too old"; }
    }

    public double checkCost()
    {
        if (age <= 5)
        {
            return 10000.00;
        }
        else if (age <= 10)
        {
            return 7500.00;
        }
        else
            return 5000.00;
    }
}

