import java.util.ArrayList;
import java.util.Collection;

public class JobAgency implements Publisher {

    private Collection<Observer> observers = new ArrayList<>();

    public void sendOffer(String companyName, int salary, String occupation){
        Collection<Observer> observersToRemove = new ArrayList<>();
        for (Observer observer : observers){
            if ((observer.getOccupation().equals(occupation) || observer instanceof Student) && observer.getEmployed() == false){
                observer.receiveOffer(companyName, salary, occupation);
                if (observer.getEmployed()){
                    observersToRemove.add(observer);
                }
            }

        }
        for (Observer observer: observersToRemove){
            removeObserver(observer);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

}