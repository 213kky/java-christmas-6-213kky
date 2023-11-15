package christmas.controller;

import christmas.domain.Discount;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.Present;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Controller {
    Order o = new Order();

    //    public Controller{
//        o.calculateMenuAndCount();
//    }
    public Controller() {
        run();
    }

    Order order;

    public void run() {
        OutputView.printHello();
        int day = InputView.readDate();
        String input = InputView.readOrderMenu();
        menuCategoryCount(input);
        Map<String, Integer> map = o.menuListAndCount(input);
        OutputView.printBenefitPreview(day);
        OutputView.printMenu(map);

        OutputView.printTotalOrderAmountBeforeDiscount();
//        OutputView.printOrderPrice();
        OutputView.printPresent(Present.presentMenu(Order.getTotalAmount()));
        Map<String, Integer> mmap = discount(day, Menu.CategoryCount);
        OutputView.printBenefitsDetails(mmap);
        OutputView.printTotalBenefitAmount(mmap.values().stream().mapToInt(Integer::intValue).sum()); // 총 할인금액
        OutputView.printEstimatedPaymentAmount();
//        System.out.println("디저트 개수: " + Menu.CategoryCount.get("디저트"));
//        System.out.println("test: " + discount(day, Menu.CategoryCount).values().stream().mapToInt(Integer::intValue).sum());
        OutputView.printPresentEventBadge(
                Present.presentEventBadge(mmap.values().stream().mapToInt(Integer::intValue).sum()));
        System.out.println("test: " + Order.totalAmount);
    }

    private void menuCategoryCount(String input) {
        order = new Order();
        Map<String, Integer> menuListAndCount = order.menuListAndCount(input);
        for (Map.Entry<String, Integer> entry : menuListAndCount.entrySet()) {
            Map<String, Integer> map = order.calculateMenuListAndCount(entry.getKey(), entry.getValue().toString());
            order.menuCategoryCount(map);
        }

    }

    private Map<String, Integer> discount(int day, Map<String, Integer> map) {
        Discount discount = new Discount();
        Map<String, Integer> benefitsDetails = new LinkedHashMap<>();
        int sum = 0;
        if (Order.totalAmount >= 10000) {
            benefitsDetails.put("크리스마스 디데이 할인", discount.dDayDiscount(day));
            benefitsDetails.put("평일 할인", discount.weekendDiscount(day, map));
            benefitsDetails.put("특별 할인", discount.starDayDiscount(day));
            if (Order.totalAmount >= 120000) {
                benefitsDetails.put("증정 이벤트", -25000);
            }
        }
        sum = benefitsDetails.values().stream().mapToInt(Integer::intValue).sum();
        if (sum == 0) {
            return new HashMap<>();
        }
//        System.out.println();
//        int benefit = Discount.benefitAmount(dDay, weekAndWeekendDay, starDay, present);
//        if (benefit == 0) {
//            System.out.println("없음");
//        }
//        System.out.println("할인 후 예상 결제 금액: " + Order.getTotalAmount());
//        Present.presentEventBadge(benefit);
        return benefitsDetails;
    }
}
