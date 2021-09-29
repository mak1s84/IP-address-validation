public class Check {

    public void checkingGroupOfDigitsForValidRange(String address){
        // Convert the address as a string to an array of strings.
        String[] addressLength = address.split( "\\." );
        // If there are 4 groups of numbers in the IP address, then do the following.
        if (addressLength.length == 4) {
            // An invalid character (letter or otherwise) can be used as one of the ip address values. An exception is possible...
            try {
                for (String group : addressLength) {
                    int groupOfNumber = Integer.parseInt(group);
                    // I check the range of each group of numbers (0 ... 255).
                    if ((groupOfNumber >= 0) && (groupOfNumber <= 255)) {
                        System.out.println("This group -> " + groupOfNumber + " <- is within acceptable limits  -  OK.");
                    } else {
                        System.out.println("This group -> " + groupOfNumber + " <- is out of range - WRONG.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error detected -> " + e);
                e.printStackTrace();
            }
        } else {
            System.out.println("The number of digit groups is not 4.");
        }
    }

    public void checkEverySymbol(String address){
        // I translate into an array of characters.
        char[] charAddress = address.toCharArray();
        for (char name : charAddress) {
            switch (name) {
                case '.', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    System.out.println("This symbol - > " + name + " < - OK");
                    break;
                default:
                    System.out.println("This symbol - > " + name + " < -  WRONG!");
                    break;
            }
        }
    }


    public void checkPoint(String address) {
        // I translate into an array of characters.
        char[] charAddress = address.toCharArray();
        int x = 0;
        for (char point : charAddress) {
            if (point == '.') {
                x++;
            }
        }
        if (x == 3) {
            System.out.println("Number and type of separating characters - ОК.");
        } else {
            System.out.println("Number and type of separating characters - WRONG.");
        }
    }

    public void foundPoints(String address){
        int indexLastPoint = address.lastIndexOf('.'); // Address of last point
        int indexFirstPoint = address.indexOf('.'); // Address of first point

        if (indexLastPoint == address.length() - 1){  // check the end of IP address id not point
            System.out.println("An IP address cannot end with a dot - WRONG");
        }
        if (indexFirstPoint == (0)){
            System.out.println("An IP address cannot start with a dot - WRONG!");
        }
        // Looking for points located together.

        int wrongBeforeLastPoint = address.lastIndexOf('.', indexLastPoint - 1); // Address point before last point
        int wrongAfterFirstPoint = address.indexOf('.', indexFirstPoint + 1); // Address point after first point

        if (indexLastPoint - wrongBeforeLastPoint == 1 ) {
            System.out.println("Two dots side by side in the last part of the address - WRONG");
        }
        if (wrongAfterFirstPoint - indexFirstPoint == 1){
            System.out.println("Two dots side by side in the first part of the address - WRONG");
        }
    }

    public boolean isIPV4Address(String address)
    // There are 4 groups of numbers in ipV4 address. Otherwise, it's something else ...
    {
        // Convert the address as a string to an array of strings.
        String[] arrayAddress = address.split("\\.");
        return arrayAddress.length == 4;
    }

}
