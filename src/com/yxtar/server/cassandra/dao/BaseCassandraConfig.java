package com.yxtar.server.cassandra.dao;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.Authenticator;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.AuthenticationException;
@Repository
public class BaseCassandraConfig {
	private static final Logger LOG = LoggerFactory.getLogger(BaseCassandraConfig.class);

	private CassandraConnParam param;

	public CassandraConnParam getParam() {
		return param;
	}

	public void setParam(CassandraConnParam param) {
		this.param = param;
	}

	/**
	 * 
	 * @return
	 * @throws InstantiationException
	 */
	public CassandraClusterFactoryBean cluster() throws InstantiationException {

		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(param.getContactPoints());
		cluster.setPort(Integer.valueOf(param.getPort()));
		cluster.setUsername(param.getUserName());
		cluster.setPassword(param.getPassWord());
		cluster.setAuthProvider(new AuthProvider() {

			@Override
			public Authenticator newAuthenticator(InetSocketAddress host)
					throws AuthenticationException {

				return this.newAuthenticator(InetSocketAddress.createUnresolved(param.getContactPoints(), Integer.valueOf(param.getPort())));
			}
		});
		try {
			cluster.afterPropertiesSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cluster;
	}

	public CassandraMappingContext mappingContext() {
		return new BasicCassandraMappingContext();
	}

	public CassandraConverter converter() {
		return new MappingCassandraConverter(mappingContext());
	}

	public CassandraSessionFactoryBean session() throws Exception {

		CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
		session.setCluster(cluster().getObject());
		session.setKeyspaceName(param.getKeySpace());
		session.setConverter(converter());
		session.setSchemaAction(SchemaAction.NONE);
		session.afterPropertiesSet();
		return session;
	}

	public CassandraOperations getCassandraOperations() throws Exception {
		Session session = session().getObject();
		if(session.isClosed()){
			session = session().getObject().getCluster().connect();
		}
		return new CassandraTemplate(session);
	}

}
