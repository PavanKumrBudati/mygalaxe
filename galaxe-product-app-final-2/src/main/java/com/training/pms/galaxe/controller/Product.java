package com.training.pms.galaxe.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "freshtable")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

	@Id
	private int productId;
	private String productName;
	private int quantityOnHand;
	private int price;
}
