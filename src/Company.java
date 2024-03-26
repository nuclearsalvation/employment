import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Company{

    private Random random = new Random();

    private String name;

    private Publisher jobAgency;

    private int maxSalary;

    private String[] occupations;

    public void setOccupations(String[] occupations){
        this.occupations = occupations;
    }

    public Company(String name, Publisher jobAgency, int maxSalary, String[] occupations){
        this.jobAgency = jobAgency;
        this.name = name;
        this.maxSalary = maxSalary;
        this.occupations = occupations;
    }

    public String getName(){
        return name;
    }

    public void needEmployee(){
        int salary = random.nextInt(maxSalary);
        String occupation = occupations[random.nextInt(occupations.length)];
        jobAgency.sendOffer(name, salary, occupation);
    }

    public void sendOffer(int salary, String occupation, Collection<Observer> observers){
        Collection<Observer> observersToRemove = new ArrayList<>();
        for (Observer observer : observers){
            if (observer.getOccupation().equals(occupation) || observer instanceof Student){
                observer.receiveOffer(name, salary, occupation);
                if (observer.getEmployed()){
                    observersToRemove.add(observer);
                }
            }

        }
        for (Observer observer: observersToRemove){
            observers.remove(observer);
        }
    }


}