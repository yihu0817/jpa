package com.warmtel.jpa.demo1.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDAO {

	private EntityManager em;

	@Before
	public void before() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
		em = factory.createEntityManager();
		em.getTransaction().begin();// 开始事物
	}

	@After
	public void after() {
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testAddUser() {
		User user = new User("张三", 27, '1', "成都市", new Date(), new BigDecimal("1.2"));
		em.persist(user);
	}

	@Test
	public void testGetUserById() {
		User user = em.find(User.class, 98304);
		System.out.println(user.getName());
	}

	@Test
	public void deleteUserByQuery() {
		Query query = em.createQuery("DELETE FROM User u WHERE u.id=?1");
		query.setParameter(1, 65536);
		query.executeUpdate();
	}

	@Test
	public void delete() {
		User person = em.find(User.class, 98304);
		em.remove(person);
	}

	@Test
	public void query() {
		// 取得总数 1的作用是从id为1开始
		Query query = em.createQuery("select o from User o where o.id=?1");
		// 注意不是sql语言 jpaSql,=后面不要把值写到后面
		query.setParameter(1, 98304);
		// session.createQuery("").uniqueResult();相当于query.getSingleResult();
		// 或者是这样:
		// List<Persons> persons=query.getResultList();
		User person = (User) query.getSingleResult();
		System.out.println(person.getName());

	}

	@Test
	public void updateUser() {
		User user = em.getReference(User.class, 98304);
		user.setName("小明");
	}

	@Test
	public void updatePerson2() {
		// Session.save()-->Persist();
		User person = em.find(User.class, 98304);
		em.clear();// 把实体管理器中的所有实体变成游离状态
		person.setName("一起创梦吧");
		// 这时候不会报错,但是不会修改数据库
		em.merge(person);
		/* 这时候就可以了替换了,用于把游离状态的更新同步到数据库 */
		// 在提交之前,jpa中是放在批处理的缓存中.

	}
}
