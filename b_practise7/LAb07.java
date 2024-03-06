package b_practise7;
import java.util.Scanner;

public class LAb07 {
    private static String[] namesOfFriends = { "Ela", "Eren", "Alona", "Jen", "Mark", "Mel", "Ender" };
    private static int[] departureTime = { 12, 7, 11, 12, 10, 9, 10 };
    private static int[] arrivalTime = { 9, 5, 8, 7, 9, 7, 8 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the time you are available: ");
        String[] range = in.nextLine().split(" ");
        int max = Integer.parseInt(range[1]);
        int[] values = new int[max - Integer.parseInt(range[0])];
        for (int i = Integer.parseInt(range[0]), b = 0; i < max; i++, b++) {
            values[b] = i;
        }

        bestTime(values);
        int[] friend = friendsAttending(values);
        for (int i = 0; i < friend.length; i++) {
            System.out.println("At " + values[i] + "pm, " + friend[i] + " friends will be at the party");
        }

        int max1 = friend[0];
        int index;
        index = 0;
        for (int i = 0; i < friend.length; i++) {
            if (friend[i] > max1) {
                max1 = friend[i];
                index = i;
            }
        }
        System.out.println("BEst time to attend is: " + values[index]);
        in.close();
    }

    public static int[] friendsAttending(int[] values) {
        int count = 0;
        int[] amountOFFrineds = new int[values.length];
        for (int i = 0; i < amountOFFrineds.length; i++) {
            count = 0;
            for (int j = 0; j < namesOfFriends.length; j++) {
                for (int k = arrivalTime[j]; k < departureTime[j]; k++) {
                    if (values[i] != departureTime[j]) {
                        if (values[i] == k) {
                            count++;
                        }
                    }

                }
            }
            amountOFFrineds[i] = count;
        }
        return amountOFFrineds;
    }

    public static void bestTime(int[] values) {

        int[] amountOFFrineds = friendsAttending(values);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter friend you wish to avoid: ");
        String name = in.nextLine();
        int index = 0;
        int count;
        for (int i = 0; i < namesOfFriends.length; i++) {
            if (name.equalsIgnoreCase(namesOfFriends[i])) {
                index = i;
            }
        }
        int[] withoutFriend = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            count = 0;

            for (int j = 0; j < namesOfFriends.length; j++) {
                for (int k = arrivalTime[j]; k < departureTime[j]; k++) {
                    if (k >= arrivalTime[index] && k <= departureTime[index]) {

                    } else {
                        if (values[i] != departureTime[j]) {
                            if (values[i] == k) {
                                count++;
                            }
                        }
                    }
                }
            }

            withoutFriend[i] = count;
        }
        int bestTime;
        bestTime = amountOFFrineds[0];
        int index1;
        index1 = 0;

        for (int i = 0; i < withoutFriend.length; i++) {
            if (withoutFriend[i] > bestTime) {
                bestTime = withoutFriend[i];
                index1 = i;
            }
        }
        int count1;
        count1 = 0;
        /*
         * for (int i = 0 ; i < withoutFriend.length ; i ++)
         * {
         * 
         * if (withoutFriend[0] == withoutFriend[i])
         * {
         * count1 = -1 ;
         * }
         * else
         * {
         * 
         * }
         * }
         */
        if (count1 == -1) {
            System.out.println("Best time to attend is " + count1);
        } else {
            System.out.println("Best time to attend is " + values[index1]);
        }

        in.close();

    }
}
