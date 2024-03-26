public class Director implements Observer{

    private String name;
    private int salary;
    private final String occupation = "Director";
    private boolean isEmployed = false;

    public Director(String name){
        this.name = name;
        salary = 200000;
    }

    public String getOccupation(){
        return occupation;

    }

    public boolean getEmployed(){
        return isEmployed;
    }

    public void employ(){
        isEmployed = true;
    }


    @Override
    public void receiveOffer(String nameCompany, int salary, String occupation) {
        if (this.salary <= salary && !isEmployed){
            System.out.printf("Директор %s: Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                    name, nameCompany, salary);
            this.salary = salary;
            employ();
        }
        else {
            System.out.printf("Директор %s: Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                    name, nameCompany, salary);
        }
    }
}