package com.myco.cashier.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cashier {
	
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private CASHIERSTATUS cashierStatus;
	private FULLPARTTIME employmentType;
	private boolean onOff;
	
	//@OneToMany(mappedBy = "cashier", cascade = CascadeType.ALL)
	List<Schedule> schedule;
	
	@ElementCollection
    @CollectionTable(name = "actualStart", 
      joinColumns = {@JoinColumn(name = "cashier_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "week_number")
	@Column(name = "date")
	private Map<Integer,Date> actualStart;
	
	@ElementCollection
    @CollectionTable(name = "actualEnd", 
      joinColumns = {@JoinColumn(name = "cashier_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "week_number")
	@Column(name = "date")
	private Map<Integer,Date> actualEnd;

}
