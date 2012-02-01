package org.springframework.amqp.rabbit.listener;

import org.springframework.amqp.rabbit.connection.Consumer;

/**
 * This provides hooks into the Consumer lifecycle
 *
 * @author Dave Stevens
 */
public interface ConsumerListener {

	public void onRestart(Consumer consumer);

}
