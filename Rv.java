package gcm;

import java.util.Date;

public class Rv {
private int id;
private Date jour;
private int client_id;
private int creneau_id;
public Rv(int id, Date jour, int client_id, int creneau_id) {
	super();
	this.id = id;
	this.jour = jour;
	this.client_id = client_id;
	this.creneau_id = creneau_id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getJour() {
	return jour;
}
public void setJour(Date jour) {
	this.jour = jour;
}
public int getClient_id() {
	return client_id;
}
public void setClient_id(int client_id) {
	this.client_id = client_id;
}
public int getCreneau_id() {
	return creneau_id;
}
public void setCreneau_id(int creneau_id) {
	this.creneau_id = creneau_id;
}
}
