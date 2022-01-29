package effyis.partners.socle.content.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import effyis.partners.socle.content.enums.TypeAttachement;

/**
 *
 * @author MAHLA Ilyasse Badreddine
 *
 */
@Entity
@NamedEntityGraph(name = "Attachement.cloudinaryInformationList", attributeNodes = @NamedAttributeNode("cloudinaryInformationList"))
@Table(name = "attachement")
public class Attachement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TypeAttachement typeAttachement;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "attachement")
	private List<CloudinaryInformation> cloudinaryInformationList;

	private int activeAttachement;

	private int positionAttachement;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeAttachement getTypeAttachement() {
		return this.typeAttachement;
	}

	public void setTypeAttachement(TypeAttachement typeAttachement) {
		this.typeAttachement = typeAttachement;
	}

	public int getActiveAttachement() {
		return this.activeAttachement;
	}

	public void setActiveAttachement(int activeAttachement) {
		this.activeAttachement = activeAttachement;
	}

	public List<CloudinaryInformation> getCloudinaryInformationList() {
		return this.cloudinaryInformationList;
	}

	public void setCloudinaryInformationList(List<CloudinaryInformation> cloudinaryInformationList) {
		this.cloudinaryInformationList = cloudinaryInformationList;
	}

	public int getPositionAttachement() {
		return this.positionAttachement;
	}

	public void setPositionAttachement(int positionAttachement) {
		this.positionAttachement = positionAttachement;
	}

	@Override
	public String toString() {
		return "Attachement [id=" + this.id + ", typeAttachement=" + this.typeAttachement + ", cloudinaryInformation="
				+ this.cloudinaryInformationList + ", activeAttachement=" + this.activeAttachement + "]";
	}

}
