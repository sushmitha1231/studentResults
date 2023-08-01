package com.studentResults.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "results")

public class Results {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int rollNum;
	private String name;
	private int total;
	private int percentage;

	@Override
	public String toString() {
		return "Results [id=" + id + ", rollNum=" + rollNum + ", name=" + name + ", total=" + total + ", percentage="
				+ percentage + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public Results(int id, int rollNum, String name, int total, int percentage) {
		super();
		this.id = id;
		this.rollNum = rollNum;
		this.name = name;
		this.total = total;
		this.percentage = percentage;
	}

	public Results() {
		super();
	}

}
