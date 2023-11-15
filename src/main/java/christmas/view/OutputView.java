package christmas.view;

import christmas.domain.Order;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    public static void printHello() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printBenefitPreview(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public static void printMenu(Map<String, Integer> map) {
        System.out.println("<주문 메뉴>");
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
        System.out.println();
    }

    public static void printTotalOrderAmountBeforeDiscount() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatter.format(Order.totalAmount) + "원");
        System.out.println();
    }

    public static void printPresent(String input) {
        System.out.println("<증정 메뉴>");
        System.out.println(input);
        System.out.println();
    }

    public static void printBenefitsDetails(Map<String, Integer> map) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("<혜택 내역>");
        if (map.isEmpty()) {
            System.out.println("없음");
        }
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey() + ": " + formatter.format(entry.getValue()) + "원");
            }
        }
        System.out.println();
    }

    public static void printTotalBenefitAmount(int sum) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("<총혜택 금액>");
        System.out.println(formatter.format(sum) + "원");
        System.out.println();
    }

    public static void printEstimatedPaymentAmount() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(formatter.format(Order.totalAmount) + "원");
        System.out.println();
    }

    public static void printPresentEventBadge(String input) {
        System.out.println(input);
    }

}
