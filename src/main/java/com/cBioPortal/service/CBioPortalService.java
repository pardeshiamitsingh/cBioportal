package com.cBioPortal.service;

import java.util.Map;
import java.util.Set;

import com.cBioPortal.model.ProteinRelationModel;

/**
 * 
 * @author Amit
 * Service which will get cBioPortalData
 */

public interface CBioPortalService {
	
	String getCaseStudyDetails(String caseStudyId);
	
	String getRelatedProteins(String srcProteinCode);

	String getRelatedProteinsList(String srcProteinCodes);
	
	Map<String, ProteinRelationModel> populateProteinRelationModel(Set<String> relatedProteins);
	
	public String getIndexCards(String srcProteinCodes, String participantType);
}
