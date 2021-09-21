import java.lang.reflect.Array;
import java.util.Scanner;

public class Check {

    public void checkIP(String address){
        char[] charAddress = address.toCharArray();
        if (checkPoint(charAddress) && checkLength(charAddress)) {
            for (char name : charAddress) {
                switch (name) {
                    case 46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57:
                        System.out.println("This symbol  > " + name + " <  - OK");
                        break;
                    default:
                        System.out.println("This symbol  > " + name + " <  unacceptable!");
                        break;
                }
            }
        }
    }

    public boolean checkLength(char[] address) {
        int result = 0;
        for (char number : address) {
            switch (number) {
                case 48, 49, 50, 51, 52, 53, 54, 55, 56, 57:
                    result++;
            }
        }
        if (result >= 4 && result <= 12){
            System.out.println("The address of the allowed length!");
            return true;
        } else {
            System.out.println("IP address length error.");
            return false;
        }
    }

    public boolean checkPoint(char[] address) {
        int x = 0;
        for (char point : address) {
            if (point == 46) {
                x++;
            }
        }
        if (x == 3) {
            System.out.println("The number of separating signs and their type meet the requirements.");
            return true;
        } else {
            System.out.println("Error in the number and / or type of separating characters.");
            return false;
        }
    }

    public boolean isIPV4Address(String address)
    {
        String[] arrayAddress = address.split("\\.");
        return arrayAddress.length == 4;
    }


}
