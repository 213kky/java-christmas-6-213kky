package christmas.domain;

public class Present {

    public static String presentMenu(int orderPrice) {
        if (orderPrice >= 120000) {
            return "샴페인 1개";
        }
        return "없음";
    }

    public static String presentEventBadge(int benefit) {
        System.out.println("<12월 이벤트 배지>");
        if (benefit <= -20000) {
            return "산타";
        }
        if (benefit <= -10000) {
            return "트리";
        }
        if (benefit <= -5000) {
            return "별";
        }
        return "없음";
    }

}
