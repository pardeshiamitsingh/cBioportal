package com.cBioPortal.Dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.cBioPortal.Dao.CBioPortalDao;
import com.cBioPortal.model.ProteinRelationModel;
import com.cBioPortal.util.Contants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * @author Amit ServiceImpl which will get cBioPortalData
 */

@Repository
public class CBioPortalDaoImpl implements CBioPortalDao {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CBioPortalDaoImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String getCaseStudyDetails(String caseStudyId) {
		logger.debug("Start => cBioPortalDaoImpl => getCaseStudyDetails for caseStudy ID ", caseStudyId);
		logger.debug("End => cBioPortalService => getCaseStudyDetails for caseStudy ID ", caseStudyId);
		return null;
	}

	@Override
	public List<DBObject>  processParticipantA(String srcProteinCode) {
		logger.debug("Start => cBioPortalDaoImpl => processParticipantA for Source protein code ", srcProteinCode);
		List<DBObject> indexCardList =new  ArrayList<DBObject>();
		try {
			BasicDBObject baseQuery = new BasicDBObject();
			List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
			obj.add(new BasicDBObject("mitreCard.extracted_information.participant_a.entity_text", srcProteinCode));
			obj.add(new BasicDBObject("mitreCard.extracted_information.participant_b.entity_type", "protein"));
			baseQuery.put("$and", obj);
			DBCursor cursor = mongoTemplate.getDb().getCollection("IndexCard").find(baseQuery);
			//returnRelateProteinsB = getRelatedProteinSet(cursor, Contants.PARTICIPANT_A);
			
			DBObject basicObject;
			while (cursor.hasNext()) {
				basicObject = cursor.next();
				indexCardList.add(basicObject);
			}
		} catch (Exception e) {
			logger.error("ERROR => CBioPortalDaoImpl =>  processParticipantA for Source protein code ", srcProteinCode);
			e.printStackTrace();
		}
		logger.debug("End => cBioPortalDaoImpl => processParticipantA for Source protein code ", srcProteinCode);
		return indexCardList;
	}

	@Override
	public List<DBObject>  processParticipantB(String srcProteinCode) {
		
		List<DBObject> indexCardList =new  ArrayList<DBObject>();
		try {
			BasicDBObject baseQuery = new BasicDBObject();
			List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
			obj.add(new BasicDBObject("mitreCard.extracted_information.participant_b.entity_text", srcProteinCode));
			obj.add(new BasicDBObject("mitreCard.extracted_information.participant_a.entity_type", "protein"));
			baseQuery.put("$and", obj);
			DBCursor cursor = mongoTemplate.getDb().getCollection("IndexCard").find(baseQuery);
			//returnRelateProteinsB = getRelatedProteinSet(cursor, Contants.PARTICIPANT_B); commented as we dont need to extract protein codes
		
			//added to get the list of index cards
			
			DBObject basicObject;
			while (cursor.hasNext()) {
				basicObject = cursor.next();
				indexCardList.add(basicObject);
			}
		} catch (Exception e) {
			logger.error("ERROR => CBioPortalDaoImpl =>  processParticipantB for Source protein code ", srcProteinCode);
			e.printStackTrace();
		}
		logger.debug("Start => cBioPortalDaoImpl => processParticipantB for Source protein code ", srcProteinCode);
		return indexCardList;
	}

	private Set<String> getRelatedProteinSet(DBCursor cursor, String participantType) {
		Set<String> relatedProteinSet = new HashSet<String>();
		DBObject basicObject;
		while (cursor.hasNext()) {
			basicObject = cursor.next();
			if (participantType.equalsIgnoreCase("a"))
				relatedProteinSet.add(
						((DBObject) ((DBObject) ((DBObject) basicObject.get("mitreCard")).get("extracted_information"))
								.get("participant_b")).get("entity_text").toString());
			else
				relatedProteinSet.add(
						((DBObject) ((DBObject) ((DBObject) basicObject.get("mitreCard")).get("extracted_information"))
								.get("participant_a")).get("entity_text").toString());
		}
		return relatedProteinSet;
	}

	@Override
	public Boolean isRelated(String srcProteinCode, String destProteinCode) {
			logger.debug("Start => isRelated => for Source protein A ", srcProteinCode+" for protein B  "+destProteinCode);
			Boolean returnVal = false;
			try {
				BasicDBObject baseQuery = new BasicDBObject();
				List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
				obj.add(new BasicDBObject("mitreCard.extracted_information.participant_a.entity_text", srcProteinCode));
				obj.add(new BasicDBObject("mitreCard.extracted_information.participant_b.entity_text", destProteinCode));
				baseQuery.put("$and", obj);
				DBCursor cursor = mongoTemplate.getDb().getCollection("IndexCard").find(baseQuery);
				if(cursor.count() > 0 ){
					returnVal = true;
				}
			} catch (Exception e) {
				logger.debug("ERROR => isRelated => for Source protein A ", srcProteinCode+" for protein B  "+destProteinCode);
				e.printStackTrace();
			}
			
			logger.debug("End => isRelated => for Source protein A ", srcProteinCode+" for protein B  "+destProteinCode);
			return returnVal;
	}

}
