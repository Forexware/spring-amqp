package org.springframework.amqp.rabbit.listener;

import org.junit.Test;
import org.springframework.amqp.rabbit.connection.Consumer;

import static org.mockito.Mockito.*;

/**
 * @author Dave Stevens
 */
public class CompositeConsumerListenerTests {

	@Test
	public void testOnRestart() {
		ConsumerListener mockListener1 = mock(ConsumerListener.class);
		ConsumerListener mockListener2 = mock(ConsumerListener.class);
		Consumer mockConsumer = mock(Consumer.class);

		CompositeConsumerListener sut = new CompositeConsumerListener();
		sut.addDelegate(mockListener1);
		sut.addDelegate(mockListener2);

		sut.onRestart(mockConsumer);

		verify(mockListener1, times(1)).onRestart(mockConsumer);
		verify(mockListener2, times(1)).onRestart(mockConsumer);
	}
}
