package xml;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name = "Treballado")
// @XmlType (propOrder = {"id", "nom", "carrec", "edat", "sexe"})

public class Empleat {
	private int id;
	private String nom; 
	private String sexe;
	private int edat;
	private String carrec;
	private String passwd;
	
	public Empleat(){}
	
	public Empleat(int id, String nom, String sexe, int edat, String carrec, String passwd) {
		super();
		this.id = id;
		this.nom = nom;
		this.sexe = sexe;
		this.edat = edat;
		this.carrec = carrec;
		this.passwd = passwd;
	}
	
	//@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//@XmlElement(name="genere")
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public String getCarrec() {
		return carrec;
	}
	public void setCarrec(String carrec) {
		this.carrec = carrec;
	}
	
	@XmlTransient
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public String toString() {
		return "Empleats [id=" + id + ", nom=" + nom + ", sexe=" + sexe + ", edat=" + edat + ", carrec=" + carrec
				+ ", passwd=" + passwd + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrec == null) ? 0 : carrec.hashCode());
		result = prime * result + edat;
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleat other = (Empleat) obj;
		if (carrec == null) {
			if (other.carrec != null)
				return false;
		} else if (!carrec.equals(other.carrec))
			return false;
		if (edat != other.edat)
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (sexe == null) {
			if (other.sexe != null)
				return false;
		} else if (!sexe.equals(other.sexe))
			return false;
		return true;
	}
	
}
