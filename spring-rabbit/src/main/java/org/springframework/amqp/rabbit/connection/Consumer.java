package org.springframework.amqp.rabbit.connection;

import com.rabbitmq.client.Channel;

/**
 * @author Dave Stevens
 */
public interface Consumer {

	public String[] getQueues();

	public Channel getChannel();

	public String getConsumerTag();

}
