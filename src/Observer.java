public interface Observer {

    void receiveOffer(String nameCompany, int salary, String occupation);

    String getOccupation();

    boolean getEmployed();

    void employ();

}