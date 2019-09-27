package co.com.accounting.model;

import lombok.Data;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name="client")
public class Client {

    @Id
    @Column(name="idclient")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idClient;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="birtdate")
    private Date birthDate;

    @Column(name="phone")
    private int phone;

    public Client() { }

    public Client(int idClient, String name, String email, String address, Date birthDate, int phone) {
        this.idClient = idClient;
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.phone = phone;
    }
}
