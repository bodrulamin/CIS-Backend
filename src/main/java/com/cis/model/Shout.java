package com.cis.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Shout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;	

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shouterid", referencedColumnName = "id")
	User shouter;
    
    @JoinColumn(name = "actiontakerid",referencedColumnName = "id")
    User actionTaker;
    
    @JoinColumn(name = "categoryid")
    Category category;
    
    String shoutmessage;
    
	
}
