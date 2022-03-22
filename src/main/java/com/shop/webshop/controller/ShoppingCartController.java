package com.shop.webshop.controller;

import com.shop.webshop.dto.orderdto.OrderFullDto;
import com.shop.webshop.model.Order;
import com.shop.webshop.service.OrderLineService;
import com.shop.webshop.service.OrderService;
import com.shop.webshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webshopapp/shoppingCart/")
public class ShoppingCartController {

    private final OrderService orderService;
    private final OrderLineService orderLineService;
    private final ProductService productService;

    public ShoppingCartController(OrderService orderService, OrderLineService orderLineService, ProductService productService) {
        this.orderService = orderService;
        this.orderLineService = orderLineService;
        this.productService = productService;
    }

    // /api/webshopapp/shoppingCart/{orderId}/{productId}/{quantity}
    // /api/webshopapp/shoppingCart/12/5/10
    /*@PostMapping("/{orderId}/{productId}/{quantity}")
    public ResponseEntity<OrderFullDto> addToCart(
            @PathVariable(name = "orderId") Integer orderId,
            @PathVariable(name = "productId") Integer productId,
            @PathVariable(name = "quantity") Integer quantity
    ) {
        OrderFullDto savedOrder = this.orderService.addToCart(orderId, productId, quantity);
        return ResponseEntity.ok(savedOrder);
    }*/

    @PostMapping("/addToCart")
    public ResponseEntity<OrderFullDto> addToCart(@RequestParam Integer orderId,
                                                  @RequestParam Integer productId,
                                                  @RequestParam Integer quantity) {
        OrderFullDto savedOrder = this.orderService.addToCart(orderId, productId, quantity);
        return ResponseEntity.ok(savedOrder);

    }

    @PostMapping("/checkOut")
    public ResponseEntity<OrderFullDto> checkOut(@RequestParam Integer orderId) {
        OrderFullDto checkOrder = this.orderService.checkOut(orderId);
        return ResponseEntity.ok(checkOrder);
    }


    // checkout/{orderId}
    // in oderService metoda de checkout
    // ia comanda, recalculeaza preturile, pune statusul pe ORDERED

    // creaza un Order nou, pe status SHOPPINGCART, care va actiona ca nou shopping cart
    // returneaza id-ul noului order
    // update la user.currentOrder
}
