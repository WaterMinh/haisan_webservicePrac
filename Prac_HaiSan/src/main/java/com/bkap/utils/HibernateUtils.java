package com.bkap.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sf;
	private HibernateUtils() {}
		
	public static SessionFactory iniSessionFactory() {
		if(sf==null) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
			Metadata metadata = new MetadataSources().buildMetadata(ssr);
			sf = metadata.buildSessionFactory();
		}
		return sf;
	}

}
