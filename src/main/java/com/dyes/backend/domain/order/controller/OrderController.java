package com.dyes.backend.domain.order.controller;

import com.dyes.backend.domain.order.controller.form.OrderConfirmRequestForm;
import com.dyes.backend.domain.order.service.user.response.form.OrderListResponseFormForUser;
import com.dyes.backend.domain.order.service.user.response.form.OrderConfirmResponseFormForUser;
import com.dyes.backend.domain.order.controller.form.OrderProductInCartRequestForm;
import com.dyes.backend.domain.order.controller.form.OrderProductInProductPageRequestForm;
import com.dyes.backend.domain.order.service.OrderService;
import com.dyes.backend.domain.order.service.admin.response.form.OrderListResponseFormForAdmin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    final private OrderService orderService;

    // 카카오로 상품 구매
    @PostMapping("/payment/kakao")
    public RedirectView orderWithKakaoPayment(@RequestBody OrderProductInCartRequestForm requestForm) {
        return orderService.purchaseReadyWithKakao(requestForm);
    }

    // 장바구니에서 상품 주문
    @PostMapping("/in-cart")
    public boolean orderProductInCart(@RequestBody OrderProductInCartRequestForm requestForm) {
        return orderService.orderProductInCart(requestForm);
    }

    // 상세 페이지에서 상품 주문
    @PostMapping("/in-product-page")
    public boolean orderProductInProductPage(@RequestBody OrderProductInProductPageRequestForm requestForm) {
        return orderService.orderProductInProductPage(requestForm);
    }

    // 결제 전 주문 요청내역 확인
    @GetMapping("/confirm")
    public OrderConfirmResponseFormForUser confirmProductInCart(@RequestParam("userToken") String userToken) {
        OrderConfirmRequestForm requestForm = new OrderConfirmRequestForm(userToken);
        return orderService.orderConfirm(requestForm);
    }

    // 관리자의 주문 내역 확인
    @GetMapping("/admin/list")
    public List<OrderListResponseFormForAdmin> getAllOrderListForAdmin() {
        return orderService.getOrderListForAdmin();
    }

    // 사용자의 주문 내역 확인
    @GetMapping("/my-list")
    public List<OrderListResponseFormForUser> getMyOrderListForUser(@RequestParam("userToken") String userToken) {
        return orderService.getMyOrderListForUser(userToken);
    }
}
