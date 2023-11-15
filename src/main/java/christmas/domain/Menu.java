package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    public static final Map<String, Integer> appetizerMenu = new HashMap<>() {{
        put("양송이수프", 6000);
        put("타파스", 5500);
        put("시저샐러드", 8000);
    }};

    public static final Map<String, Integer> mainMenu = new HashMap<>() {{
        put("티본스테이크", 55000);
        put("바비큐립", 54000);
        put("해산물파스타", 35000);
        put("크리스마스파스타", 25000);
    }};


    public static final Map<String, Integer> dessertMenu = new HashMap<>() {{
        put("초코케이크", 15000);
        put("아이스크림", 5000);
    }};

    public static final Map<String, Integer> drinkMenu = new HashMap<>() {{
        put("제로콜라", 3000);
        put("레드와인", 60000);
        put("샴페인", 25000);
    }};

//        System.out.println(appetizerMenu);
//        System.out.println(mainMenu);
//        System.out.println(dessertMenu);
//        System.out.println(drinkMenu);

    public static final Map<String, Map<String, Integer>> totalMenu = new HashMap<>() {{
        put("애피타이저", appetizerMenu);
        put("메인", mainMenu);
        put("디저트", dessertMenu);
        put("음료", drinkMenu);
    }};
//        totalMenu.put("에피타이저", appetizerMenu);
//        totalMenu.put("메인", mainMenu);
//        totalMenu.put("디저트", dessertMenu);
//        totalMenu.put("음료", drinkMenu);

//        System.out.println(totalMenu);

    public static Map<String, Integer> CategoryCount = new HashMap<>(){{
        put("애피타이저", 0);
        put("메인", 0);
        put("디저트", 0);
        put("음료", 0);
    }};


}
