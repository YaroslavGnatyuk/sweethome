package ua.gnatyuk.sweethome;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestConnectionDB {
	@Autowired
	SessionFactory sessionFactory;

	@Test
	public void contextLoads() {
		int actual = (int) sessionFactory.getCurrentSession().createSQLQuery("select 1").uniqueResult();
		assertEquals(actual, 1);
	}

}
