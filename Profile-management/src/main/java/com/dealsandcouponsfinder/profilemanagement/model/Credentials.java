package com.dealsandcouponsfinder.profilemanagement.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Credentials")
public class Credentials {


	@NotEmpty
	@Id
	private String username;
	@NotEmpty
	@Field
	private String password;

}
