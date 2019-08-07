package NPB.utilities;

public class TryCode {

    public static void main(String[] args) {
        String SUPER_ADMIN_LOGIN = System.getenv("SUPER_ADMIN_LOGIN");
        String SUPER_ADMIN_PASSWORD = System.getenv("SUPER_ADMIN_PASSWORD");
        System.out.println(SUPER_ADMIN_LOGIN + " " + SUPER_ADMIN_PASSWORD);
    }
}