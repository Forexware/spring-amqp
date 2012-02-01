package org.springframework.amqp.rabbit.listener;

import org.springframework.amqp.rabbit.connection.Consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Delegate to collection of listener
 *
 * @author Dave Stevens
 */
public class CompositeConsumerListener implements ConsumerListener {

	private List<ConsumerListener> delegates = new ArrayList<ConsumerListener>();

	public void onRestart(final Consumer consumer) {
		for (ConsumerListener d : delegates) {
			d.onRestart(consumer);
		}
	}

	public void addDelegate(ConsumerListener delegate) {
		this.delegates.add(delegate);
	}

}
