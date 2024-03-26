public interface Publisher {

    void sendOffer(String companyName, int salary, String occupation);

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);


}