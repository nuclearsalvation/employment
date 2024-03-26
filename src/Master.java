public class Master implements Observer{

    private String name;
    private int salary;
    private String occupation;
    private boolean isEmployed = false;

    @Override
    public String getOccupation(){
        return occupation;
    }

    public Master(String name){
        this.name = name;
        salary = 80000;
    }

    public boolean getEmployed(){
        return isEmployed;
    }

    public void employ(){
        isEmployed = true;
    }

    public Master(String name, String occupation){
        this.name = name;
        this.occupation = occupation;
        salary = 80000;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary, String occupation) {
        if (this.salary <= salary && this.occupation.equals(occupation) && !isEmployed){
            System.out.printf("Специалист %s: Мне нужна эта работа! (компания: %s; заработная плата: %d; профессия %s)\n",
                    name, nameCompany, salary, occupation);
            this.salary = salary;
            employ();
        }
        else {
            System.out.printf("Специалист %s: Я найду работу получше! (компания: %s; заработная плата: %d; профессия %s)\n",
                    name, nameCompany, salary, occupation);
        }
    }
}