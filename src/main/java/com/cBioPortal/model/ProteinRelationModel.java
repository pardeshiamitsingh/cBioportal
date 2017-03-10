package com.cBioPortal.model;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Amit 
 * Holds the protein info along with the other proteins
 */

@Document(collection = "IndexCard")
public class ProteinRelationModel {

	private String srcProteinCode;
	private Set<String> associatedProteinCodes;

	public String getSrcProteinCode() {
		return srcProteinCode;
	}

	public void setSrcProteinCode(String srcProteinCode) {
		this.srcProteinCode = srcProteinCode;
	}

	public Set<String> getAssociatedProteinCodes() {
		return associatedProteinCodes;
	}

	public void setAssociatedProteinCodes(Set<String> associatedProteinCodes) {
		this.associatedProteinCodes = associatedProteinCodes;
	}

}
