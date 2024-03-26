public class Student implements Observer{

    private String name;
    private int salary;
    private String occupation;
    private boolean isEmployed;

    public Student(String name){
        this.name = name;
        salary = 5000;
    }

    @Override
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
            System.out.printf("Студент %s: Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                    name, nameCompany, salary);
            this.salary = salary;
            this.occupation = occupation;
            employ();
        }
        else {
            System.out.printf("Студент %s: Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                    name, nameCompany, salary);
        }
    }
}