package ua.gnatyuk.sweethome;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.sweethome.config.SpringConfig;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringConfig.class})
public class TestConnectionDB {
	@Autowired
	SessionFactory sessionFactory;

	@Test@Transactional
	public void contextLoads() {
		BigInteger actual = (BigInteger) sessionFactory.getCurrentSession().createSQLQuery("select 1").uniqueResult();
		BigInteger expected = BigInteger.ONE;
		assertEquals(actual, expected);
	}

}
