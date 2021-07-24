package com.higradius;

public class CompanyTable {
	String name;
	String customerno;
	String id;
	String amount;
	String duedate;
	String cleardate;
	String notes;
	 
   public CompanyTable(String name,String customerno,String id,String amount,String duedate,String cleardate,String notes)
   {
	    this.name=name;
		this.customerno=customerno;
		this.id=id;
        this.amount=amount;
		this.duedate=duedate;
		this.cleardate=cleardate;
		this.notes=notes;	
   }

	public String getName() {
		return name;
	}


	public String getCustomer_number() {
		return customerno;
	}



	public String getInvoice_id() {
		return id;
	}



	public String getAmount() {
		return amount;
	}



	public String getDue_date() {
		return duedate;
	}


	public String getClear_date() {
		return cleardate;
	}



	public String getNotes() {
		return notes;
	}

}
