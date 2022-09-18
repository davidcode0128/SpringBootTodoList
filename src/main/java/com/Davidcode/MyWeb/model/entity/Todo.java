package com.Davidcode.MyWeb.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Davidcode.MyWeb.model.entity.Todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@Column
	String task;

	@Column
	Integer status;

	@Column
	String createTime;

	@Column
	String updateTime;

}