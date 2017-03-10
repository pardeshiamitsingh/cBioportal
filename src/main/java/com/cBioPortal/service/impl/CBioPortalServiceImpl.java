package com.cBioPortal.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cBioPortal.Dao.CBioPortalDao;
import com.cBioPortal.model.ProteinRelationModel;
import com.cBioPortal.service.CBioPortalService;

/**
 * 
 * @author Amit ServiceImpl which will get cBioPortalData
 */

@Service
public class CBioPortalServiceImpl implements CBioPortalService {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CBioPortalServiceImpl.class);

	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private CBioPortalDao cBioPortalDao;

	@Override
	public String getCaseStudyDetails(String caseStudyId) {
		logger.debug("Start => cBioPortalService => getCaseStudyDetails for caseStudy ID ", caseStudyId);
		cBioPortalDao.getCaseStudyDetails(caseStudyId);
		logger.debug("End => cBioPortalService => getCaseStudyDetails for caseStudy ID ", caseStudyId);
		return null;
	}

	@Override
	public String getRelatedProteins(String srcProteinCode) {
		logger.debug("Start => CBioPortalServiceImpl => getRelatedProteins for Source protein code ", srcProteinCode);
		String returnString = null;
	/*	try {
			Set<String> finalRelatedProteinCodes = new HashSet<String>();
			finalRelatedProteinCodes.addAll(cBioPortalDao.processParticipantA(srcProteinCode));
			finalRelatedProteinCodes.addAll(cBioPortalDao.processParticipantB(srcProteinCode));
			returnString = mapper
					.writeValueAsString(populateProteinRelationModel(srcProteinCode, finalRelatedProteinCodes,null));
		} catch (Exception e) {
			logger.error("ERROR => CBioPortalServiceImpl =>  getRelatedProteins for Source protein code ", srcProteinCode );
			e.printStackTrace();
		}
		logger.debug("End => CBioPortalServiceImpl => getRelatedProteins for Source protein code ", srcProteinCode);*/
		return returnString;
	}
	

	@Override
	public String getRelatedProteinsList(String srcProteinCodes) {
	//	logger.debug("Start => CBioPortalServiceImpl => getRelatedProteins for Source protein code ", srcProteinCode);
		String returnString = null;
		/*try {
			
			List<String> srcProteinCodeList =Arrays.asList(srcProteinCodes.split(","));
			Set<String> finalRelatedProteinCodes = new HashSet<String>();
			List<ProteinRelationModel> relatedProteinModelList = new ArrayList<ProteinRelationModel>();
			for(String srcProteinCode : srcProteinCodeList){
				finalRelatedProteinCodes.addAll(cBioPortalDao.processParticipantA(srcProteinCode));
				finalRelatedProteinCodes.addAll(cBioPortalDao.processParticipantB(srcProteinCode));
				relatedProteinModelList.add(populateProteinRelationModel(srcProteinCode, finalRelatedProteinCodes,srcProteinCodeList));
			}
			
			returnString  = mapper.writeValueAsString(relatedProteinModelList);
		} catch (Exception e) {
			logger.error("ERROR => CBioPortalServiceImpl =>  getRelatedProteins for Source protein code " );
			e.printStackTrace();
		}*/
		logger.debug("End => CBioPortalServiceImpl => getRelatedProteins for Source protein code ");
		return returnString;
	}

	private ProteinRelationModel populateProteinRelationModel(String srcProtein, Set<String> relatedProteins, List<String> reqProteinList) {
		ProteinRelationModel model = new ProteinRelationModel();
		model.setSrcProteinCode(srcProtein);
		Set<String> filterdRelatedProteins = new HashSet<String>();
		filterdRelatedProteins.addAll(relatedProteins);
		if(reqProteinList != null && reqProteinList.size() > 0 ){
			for(String foundProtein : relatedProteins){
				if(!reqProteinList.contains(foundProtein))
					filterdRelatedProteins.remove(foundProtein);
					
			}
			model.setAssociatedProteinCodes(filterdRelatedProteins);
		}else{
			model.setAssociatedProteinCodes(relatedProteins);
		}
				
		return model;
	}
	
	@Override
	public Map<String, ProteinRelationModel> populateProteinRelationModel(Set<String> relatedProteins) {
		
		Map<String, ProteinRelationModel> proteinMap = new HashMap<String, ProteinRelationModel>();
		Set<String> srcProteinCopy = new HashSet<String>();
		srcProteinCopy.addAll(relatedProteins);
		if(relatedProteins != null && relatedProteins.size() > 0 ){
			for(String srcProtein : relatedProteins){
				
				for(String destProtein : srcProteinCopy){
					if(!srcProtein.equalsIgnoreCase(destProtein)){
						if(cBioPortalDao.isRelated(srcProtein, destProtein)){
							
							ProteinRelationModel modelRcv = proteinMap.get(srcProtein);
							if(modelRcv == null){
								ProteinRelationModel model = new ProteinRelationModel();
								model.setSrcProteinCode(srcProtein);
								model.getAssociatedProteinCodes().add(destProtein);
								proteinMap.put(srcProtein, model);
							}else{
								modelRcv.getAssociatedProteinCodes().add(destProtein);
								proteinMap.put(srcProtein, modelRcv);
							}
						}
					}
				}
			}
		}
				
		return proteinMap;
	}
	
	
	@Override
	public String getIndexCards(String srcProteinCodes, String participantType) {
	//	logger.debug("Start => CBioPortalServiceImpl => getRelatedProteins for Source protein code ", srcProteinCode);
		String returnString = null;
		try {
			
			List<String> srcProteinCodeList =Arrays.asList(srcProteinCodes.split(","));
			Set<String> finalRelatedProteinCodes = new HashSet<String>();
			List<ProteinRelationModel> relatedProteinModelList = new ArrayList<ProteinRelationModel>();
			for(String srcProteinCode : srcProteinCodeList){
				if("a".equalsIgnoreCase(participantType))
					returnString =	mapper.writeValueAsString(cBioPortalDao.processParticipantA(srcProteinCode));
				else if("b".equalsIgnoreCase(participantType))
					returnString =	mapper.writeValueAsString(cBioPortalDao.processParticipantB(srcProteinCode));
				//cBioPortalDao.processParticipantB(srcProteinCode);
			}
			
		} catch (Exception e) {
			logger.error("ERROR => CBioPortalServiceImpl =>  getRelatedProteins for Source protein code " );
			e.printStackTrace();
		}
		logger.debug("End => CBioPortalServiceImpl => getRelatedProteins for Source protein code ");
		return returnString;
	}


}
