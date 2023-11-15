package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Discount {

    public static final List<Integer> weekend = new ArrayList<>(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
    public static final List<Integer> starDay = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 31, 25));

    public int dDayDiscount(int day) {
//        System.out.println("dDayDiscount전" + Order.getOrderPrice());
        int discount = 0;
        if (day >= 1 && day <= 25) {
            Order.setTotalAmount(Order.getTotalAmount() - 1000 - 100 * (day - 1));
            discount = - 1000 - 100 * (day - 1);
        }
//        System.out.println("dDayDiscount후" + Order.getOrderPrice());
        return discount;
    }

    public int starDayDiscount(int day) {
        int discount = 0;
//        System.out.println("starDayDiscount전" + Order.getOrderPrice());
        if (starDay.contains(day)) {
            Order.setTotalAmount(Order.getTotalAmount() - 1000);
            discount = -1000;
        }
//        System.out.println("starDayDiscount후" + Order.getOrderPrice());
        return discount;
    }

    public int weekendDiscount(int day, Map<String, Integer> map) {
//        System.out.println("디저트 개수: " + map.get("디저트"));
        int discount = 0;
//        System.out.println("weekendDiscount전" + Order.getOrderPrice());
        if (weekend.contains(day)) {
            Order.setTotalAmount(Order.getTotalAmount() - map.get("메인") * 2023);
            discount = -map.get("메인") * 2023;
        }
        if (!weekend.contains(day)) {
            Order.setTotalAmount(Order.getTotalAmount() - map.get("디저트") * 2023);
            discount = -map.get("디저트") * 2023;
        }
//        System.out.println("weekendDiscount후" + Order.getOrderPrice());
        return discount;
    }

    public static int benefitAmount(int a, int b, int c, int d) {
        int sum = a + b + c + d;
        System.out.println("<총혜택 금액>");
        if (sum == 0) {
            System.out.println("없음");
        }
        if (sum != 0) {
            System.out.println(sum + "원");
        }
        return sum;
    }


}
