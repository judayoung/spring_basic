package hello.core.order;

public interface OrderService {

    // 1. 주문생성  4. 주문반환
    Order createOrder(Long memberId, String itemName, int itemPrice);
    
}
