package com.example.restservice.domain;

import java.util.UUID;

public class Cat {
	public final String id;
	public final String name;

	public Cat(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static Cat cat(String id, String name) {
		if (id == null){
			id = UUID.randomUUID().toString();
		}
		return new Cat(id, name);
	}

	public static Cat fromPrevious(Cat cat, String name) {
		return Cat.cat(cat.id, cat.name);
	}
}
