package com.infinityappsolutions.alexandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;

public class AlexandraConnection {
	private static AlexandraConnection ac;
	private Cluster cluster;

	private AlexandraConnection() {

	}

	public static AlexandraConnection getInstance() {
		if (ac == null) {
			ac = new AlexandraConnection();
		}
		return ac;
	}

	public static void main(String[] args) {
		ac.connect("127.0.0.1");
		ac.close();
	}

	public void connect(String node) {
		cluster = Cluster.builder().addContactPoint(node).build();
		Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n",
				metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
					host.getDatacenter(), host.getAddress(), host.getRack());
		}
	}

	public void close() {
		cluster.close();
	}

}
