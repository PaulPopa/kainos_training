package app;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.WorldMapper;
import model.City;

public class Main {

	public Main() {
	}

	public static void main(String args[]) {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("data/mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);
		SqlSession session = factory.openSession();
		
		try {
			WorldMapper mapper = session.getMapper(WorldMapper.class);

			City belfast = mapper.getCity(469);

			System.out.println(belfast.getName() 
					+ " has a population of " 
					+ belfast.getPopulation());
			
			var walesCities = mapper.getCitiesForDistrict("wales");
			for(var city: walesCities) {
				System.out.println(city.getName() 
						+ " has a population of " 
						+ city.getPopulation());	
			}
			
			City myCity = new City("MyCity", "AFG", "MyDistrict", 250);
			mapper.insertCity(myCity);
			session.commit();

		} finally {
			session.close();
		}
 	}
}
