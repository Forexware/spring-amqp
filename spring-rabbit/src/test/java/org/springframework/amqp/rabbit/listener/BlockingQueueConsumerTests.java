package org.springframework.amqp.rabbit.listener;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.support.MessagePropertiesConverter;

/**
 * @author Dave Stevens
 */
public class BlockingQueueConsumerTests {

	@Test
	public void testGetQueues() {
		ConnectionFactory mockConnectionFactory = mock(ConnectionFactory.class);
		MessagePropertiesConverter mockMessagePropertiesConverter = mock(MessagePropertiesConverter.class);
		ActiveObjectCounter<BlockingQueueConsumer> activeObjectCounter = new ActiveObjectCounter<BlockingQueueConsumer>();

		BlockingQueueConsumer sut = new BlockingQueueConsumer(mockConnectionFactory,
				mockMessagePropertiesConverter,
				activeObjectCounter,
				AcknowledgeMode.NONE,
				false, 1, "a", "b");
		
		String[] queues1 = sut.getQueues();
		String[] queues2 = sut.getQueues();

		assertNotSame(queues1, queues2);
	}

}
