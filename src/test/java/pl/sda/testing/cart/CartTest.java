package pl.sda.testing.cart;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CartTest {

    @Mock
    public Persistence persistenceMock;

    @Test
    public void testMockInvoked() {
        //given
        Cart cartMock = mock(Cart.class);
        Item item1 = new Item(0);

        //when
        cartMock.addItem(item1);

        //then
        verify(cartMock).addItem(item1);
    }

    @Test
    @Ignore
    public void testMockNotInvoked() {
        //given
        Cart cartMock = mock(Cart.class);
        Item item1 = new Item(0);
        Item item2 = new Item(1);

        //when
        cartMock.addItem(item1);

        //then
        verify(cartMock).addItem(item2);
    }

    @Test
    public void testMockNeverInvoked() {
        //given
        Cart cartMock = mock(Cart.class);
        Item item1 = new Item(0);
        Item item2 = new Item(1);

        //when
        cartMock.addItem(item1);

        //then
        verify(cartMock, never()).addItem(item2);
    }

    @Test
    public void testMockInvokedOnce() {
        //given
        Cart cartMock = mock(Cart.class);
        Item item1 = new Item(0);

        //when
        cartMock.addItem(item1);

        //then
        verify(cartMock, times(1)).addItem(item1);
    }

    @Test
    public void testMockGetItems() {
        //given
        Item item1 = new Item(0);
        Item item2 = new Item(1);
        Item item3 = new Item(2);
        List<Item> items = Arrays.asList(item1, item2, item3);
        when(persistenceMock.getItems(0)).thenReturn(items);

        //then
        Assertions.assertThat(persistenceMock.getItems(0))
                .containsOnly(item1, item2, item3);
    }

    @Test
    public void whenItemListIsEmpty_shouldReturnIsEmptyTrue() {
        //given
        Cart cart = new Cart(0, persistenceMock);
        when(persistenceMock.getItems(0))
                .thenReturn(Collections.emptyList());

        //when
        boolean isEmpty = cart.isEmpty();

        //then
        Assertions.assertThat(isEmpty).isTrue();
    }

}