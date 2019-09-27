package co.com.accounting.modelView;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ClientViewModel {

	  private int idClient;
	  private String name;
	  private String email;
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private String address;
	  private Date birthDate;
	  private int phone;
	  
}
