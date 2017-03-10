package com.cBioPortal.Dao;

import java.util.List;
import java.util.Set;

import com.mongodb.DBObject;

/**
 * 
 * @author Amit
 * Repository which will get cBioPortalData
 */

public interface CBioPortalDao {
	
	String getCaseStudyDetails(String caseStudyId);
	
	List<DBObject>  processParticipantA(String srcProteinCode);
	
	List<DBObject>  processParticipantB(String srcProteinCode);
	
	Boolean isRelated(String srcProteinCode, String destProteinCode);
}
