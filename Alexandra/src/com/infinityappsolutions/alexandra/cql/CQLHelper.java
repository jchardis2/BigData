package com.infinityappsolutions.alexandra.cql;

import com.datastax.driver.core.Session;

public class CQLHelper {

	public void insert(Session session, String table, String[] columns,
			Object[] values) {

	}

	public String columnQueryBuilder(String[] columns) {
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for (int i = 0; i < columns.length; i++) {
			sb.append(columns[i]);
			if (i < columns.length) {
				sb.append(", ");
			}
		}
		sb.append(")");
		return sb.toString();
	}
}
