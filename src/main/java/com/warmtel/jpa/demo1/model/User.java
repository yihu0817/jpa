package com.warmtel.jpa.demo1.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
	 一些比较重要的注解进行下说明：
	@Entity(name = "User")：指明这个类是一个Domian Object（实体类），name属性不指定，则类名即为表名，指定则无此限制。
	
	@Id：此字段为表的主键。
	
	@GeneratedValue(strategy = xxx)：主键生成策略，有以下4种：
         GenerationType.IDENTITY：自增主键，oracle不支持。
         GenerationType. AUTO：默认选项，由JPA选择合适策略。
         GenerationType. TABLE：通过表产生主键，主要方便数据库移植。
         GenerationType. SEQUENCE：通过序列产生主键。
         
	@Column(name = "ID")：将字段与指定列绑定。不必制定字段类型，JPA可以通过反射获取。可以为字符类型指定长度，以便可以自动生成DDL语句。
	
	@Temporal(TemporalType.DATE)：时间类型必须指明具体类型，包括DATE，TIME，TIMESTAMP。
 *
 */
@Entity  
public class User {  
    @Id  
    @GeneratedValue(strategy = GenerationType.TABLE)  
    @Column(name = "ID")  
    private int id;  
  
    @Column(name = "Name", length = 50)  
    private String name;  
  
    @Column(name = "Age")  
    private int age;  
  
    @Column(name = "Sex", length = 1)  
    private char sex;  
  
    @Column(name = "Address")  
    private String address;  
  
    @Column(name = "Birth")  
    @Temporal(TemporalType.DATE)  
    private Date birth;  
  
    @Column(name = "Income")  
    private BigDecimal income;

    
	public User() {
	}

	public User(String name, int age, char sex, String address, Date birth, BigDecimal income) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.birth = birth;
		this.income = income;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}  
  
    // getter and setter methods  
}  