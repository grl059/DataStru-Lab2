package Lab2;

import java.util.Scanner;

public class Lab2Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        MyChain list = new MyChain();
        System.out.print("Heden element oruulah ve? : ");
        int n = sc.nextInt();

        System.out.println(n + " elementiig oruulna uu:");
        for (int i = 0; i < n; i++) {
            list.Add(sc.nextInt());
        }

        Object[] o = list.toArray();
        System.out.print("Anhnii jagsaalt: ");
        for (int i = 0; i < o.length; i++)
            System.out.print(o[i] + " ");

        // addRange турших
        System.out.print("\naddRange hiihiin tuld heden element oruulah ve?: ");
        int m = sc.nextInt();
        Object[] o2 = new Object[m];
        System.out.println(m + " elementiig :");
        for (int i = 0; i < m; i++) {
            o2[i] = sc.nextInt();
        }
        list.addRange(o2);

        o = list.toArray();
        System.out.print("addRange hiisnii daraah jagsaalt: ");
        for (int i = 0; i < o.length; i++)
            System.out.print(o[i] + " ");

        // Intersection ба Union
        System.out.print("\nlist1-iin hemjeeg oruul: ");
        int n1 = sc.nextInt();
        MyChain list1 = new MyChain();
        System.out.println(n1 + " toog oruulna uu:");
        for (int i = 0; i < n1; i++) {
            list1.Add(sc.nextInt());
        }

        System.out.print("list2-iin hemjeeg oruul: ");
        int n2 = sc.nextInt();
        MyChain list2 = new MyChain();
        System.out.println(n2 + " toog oruulna uu:");
        for (int i = 0; i < n2; i++) {
            list2.Add(sc.nextInt());
        }

        MyChain list3 = list1.intersection(list2);
        System.out.println("Ogtloltsol: " + list3);

        MyChain list4 = list1.union(list2);
        System.out.println("Negdel: " + list4);
    }
}
