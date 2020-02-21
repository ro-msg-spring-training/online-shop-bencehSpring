package ro.msg.learning.shop.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.CartDTO;
import ro.msg.learning.shop.entities.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartDTO mapCartToCartDTO(Cart cart) {
        return CartDTO.builder()
                .productId(cart.getProductId())
                .quantity(cart.getQuantity())
                .id(cart.getId())
                .build();
    }

    public List<CartDTO> mapCartListToCartDTOList(List<Cart> cartList) {
        return cartList.stream().map(this::mapCartToCartDTO).collect(Collectors.toList());
    }

    public Cart mapCartDTOToCart(CartDTO cartDTO) {
        return Cart.builder()
                .productId(cartDTO.getProductId())
                .quantity(cartDTO.getQuantity())
                .id(cartDTO.getId())
                .build();
    }

    public List<Cart> mapCartDTOListToCartList(List<CartDTO> cartDTOList) {
        return cartDTOList.stream().map(this::mapCartDTOToCart).collect(Collectors.toList());
    }
}
