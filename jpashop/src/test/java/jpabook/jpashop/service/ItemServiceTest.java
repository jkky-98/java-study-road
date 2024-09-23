package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    void 상품_저장() {
    	// given
        Item movie = new Movie();
        // when
        Long itemSavedId = itemService.saveItem(movie);

        // then
        Item findItem = itemRepository.findOne(itemSavedId);
        assertThat(findItem).isEqualTo(movie);
    }


    @Test
    void 상품_전체_조회() {
    	// given
        Item movie1 = new Movie();
        Item movie2 = new Movie();
        Item movie3 = new Movie();
    	// when
        Long id1 = itemService.saveItem(movie1);
        Long id2 = itemService.saveItem(movie2);
        Long id3 = itemService.saveItem(movie3);

        // then
        assertThat(itemService.findItems().size()).isEqualTo(3);
    }


    @Test
    void 엔티티_수량_add() {
    	// given
        Item movie1 = new Movie();
    	// when
        Long savedId = itemService.saveItem(movie1);
        Item findItem = itemService.findOne(savedId);
        findItem.addStock(3);

        // then
        Item checkItem = itemService.findOne(savedId);
        assertThat(checkItem.getStockQuantity()).isEqualTo(3);
    }

    @Test
    void 엔티티_수량_remove() {
        // given
        Item movie1 = new Movie();
        // when
        Long savedId = itemService.saveItem(movie1);
        Item findItem = itemService.findOne(savedId);
        findItem.addStock(3);
        findItem.removeStock(1);

        // then
        Item checkItem = itemService.findOne(savedId);
        assertThat(checkItem.getStockQuantity()).isEqualTo(2);
    }

}