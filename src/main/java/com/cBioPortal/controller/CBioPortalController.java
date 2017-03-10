package com.cBioPortal.controller;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cBioPortal.service.CBioPortalService;

@Controller
public class CBioPortalController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(CBioPortalController.class);
	
	@Autowired
	private CBioPortalService cBioPortalService;

	@RequestMapping(value = "/getCaseStudy", method = RequestMethod.GET)
	public @ResponseBody String getCaseStudy(@RequestParam(value = "caseStudyId") String caseStudyId ) {

		logger.debug("Start => CBioPortalController => getCaseStudy  for study ID "+ caseStudyId);
		cBioPortalService.getCaseStudyDetails(caseStudyId);
		logger.debug("End => CBioPortalController => getCaseStudy  for study ID "+ caseStudyId);
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "Yeah Got Case Study "+caseStudyId;

	}

	@RequestMapping(value = "/getRelatedProteins", method = RequestMethod.GET)
	public @ResponseBody String getRelatedProteins(@RequestParam(value = "srcProteinCode") String srcProteinCode) {
		logger.debug("Start => CBioPortalController => getRelatedProteins  for source protein code "+ srcProteinCode);
		String returnString = cBioPortalService.getRelatedProteins(srcProteinCode);
		logger.debug("End => CBioPortalController => getRelatedProteins  for source protein code "+ srcProteinCode);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.createObjectNode();
		((ObjectNode) rootNode).put("test", "test1");
		//JSONPObject obj = new JSONPObject("Return", returnString);
		return  "logResults("+returnString+")";

	}
	
	@RequestMapping(value = "/getIndexCards", method = RequestMethod.GET)
	public @ResponseBody String getIndexCards(@RequestParam(value = "entityText") String entityText,
			@RequestParam(value = "participantType") String participantType) {

		logger.debug("Start => CBioPortalController => getIndexCards  for entity text "+ entityText);
		String returnString;
		returnString = cBioPortalService.getIndexCards(entityText, participantType);
		logger.debug("End => CBioPortalController => getIndexCards  for entity text "+ entityText);
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return returnString;

	}

}