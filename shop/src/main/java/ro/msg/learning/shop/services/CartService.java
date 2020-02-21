package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repositories.CartRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    @Transactional
    public void deleteById(Integer id, String userName) {
        cartRepository.deleteCartByProductIdAndUser_Username(id, userName);
    }

    @Transactional
    public void deleteByUser(String username){
        cartRepository.deleteCartByUser_Username(username);
    }
}
