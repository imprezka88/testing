package pl.sda.testing.cart;

import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CartTest {
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

}