package com.infinityappsolutions.alexandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.AuthenticationException;
import com.datastax.driver.core.exceptions.NoHostAvailableException;

public class AlexandraSessionFactory {
	private static AlexandraSessionFactory asf;
	private Session session;

	private AlexandraSessionFactory() {

	}

	public static AlexandraSessionFactory getInstance() {
		if (asf == null) {
			asf = new AlexandraSessionFactory();
		}
		return asf;
	}

	public Session createConnection(Cluster cluster)
			throws NoHostAvailableException, AuthenticationException {
		return cluster.connect();
	}
}
