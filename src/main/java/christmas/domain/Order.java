package christmas.domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Order {
    public static int totalAmount; // 총 주문가격

    public static int getTotalAmount() {
        return totalAmount;
    }

    public static void setTotalAmount(int totalAmount) {
        Order.totalAmount = totalAmount;
    }


    public Map<String, Integer> menuListAndCount(String orderMenuList) { // 주문한 내용을 받아 맵으로 반환
        Map<String, Integer> orderMenuListAndCount = new HashMap<>();
        String[] menuAndCount = orderMenuList.split(",");
        for (String a : menuAndCount) {
            String[] tmp = a.split("-");
//            System.out.println(tmp[0] + " " + tmp[1] + "개");
            orderMenuListAndCount.put(tmp[0], Integer.parseInt(tmp[1])); // map에 메뉴와 개수 집어넣음
        }
//        System.out.println("주문 종류");
//        System.out.println(orderMenuListAndCount);
        return orderMenuListAndCount;
    }


    public Map<String, Integer> calculateMenuListAndCount(String menu, String count) { // 메뉴 한개에 대한 가격과 카테고리
        String key = "";
        for (Map.Entry<String, Map<String, Integer>> entry : Menu.totalMenu.entrySet()) {  // 주문메뉴와 개수를 받아서 가격을 계산하는부분
            Map<String, Integer> value = entry.getValue();
            if (value.get(menu) != null) {
//                System.out.println(menu + count + "개 가격은 " + Integer.parseInt(count) * value.get(menu)); //value.get(menu) = 가격
                key = entry.getKey();  // 메뉴 카테고리
//                System.out.println("[key]:" + key + ", [value]:" + value);
                totalAmount += Integer.parseInt(count) * value.get(menu); // 총 가격계산
                break;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        map.put(key, Integer.parseInt(count));
        return map;
    }

//    public String calculateMenuListAndCount(String menu, String count) { // 메뉴 한개에 대한 가격과 카테고리
//        String key ="";
//        for (Map.Entry<String, Map<String, Integer>> entry : Menu.totalMenu.entrySet()) {  // 주문메뉴와 개수를 받아서 가격을 계산하는부분
//            Map<String, Integer> value = entry.getValue();
//            if (value.get(menu) != null) {
//                System.out.println(menu + count + "개 가격은 " + Integer.parseInt(count) * value.get(menu)); //value.get(menu) = 가격
//                key = entry.getKey();  // 메뉴 카테고리
//                System.out.println("[key]:" + key + ", [value]:" + value);
//                orderPrice += Integer.parseInt(count) * value.get(menu); // 총 가격계산
//                break;
//            }
//        }
//        return key;
//    }


    /**
     * 메뉴 카테고리별로 정리하는거 할 차례
     */

    public void menuCategoryCount(Map<String, Integer> map) {  // 카테고리 하나 받아서 증가시킴 (할인 또는 음료만 주문시 거절에 이용)
//        System.out.println(Menu.CategoryCount);
        String key = "";
        for (String k : map.keySet()) {
            key = k;
        }

        Menu.CategoryCount.put(key, Menu.CategoryCount.get(key) + map.get(key));
//        System.out.println("크기가 커졌나?: " + Menu.CategoryCount.get(key));
//        System.out.println(Menu.CategoryCount);

    }


}
