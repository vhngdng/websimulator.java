import view.View;

public class Main {
    public static void main(String[] args) {
        // declare view
        View view = new View();
        // display view to user
        try {
            view.display();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
