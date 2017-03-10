package com.cBioPortal.converters;

import org.springframework.core.convert.converter.Converter;

import com.cBioPortal.model.ProteinRelationModel;
import com.mongodb.DBObject;

/**
 * 
 * @author Amit
 * Converts DB collection to ProteinRelationModel in Java 
 */
public class ProteinModelConverter implements Converter<DBObject, ProteinRelationModel> {

	@Override
	public ProteinRelationModel convert(DBObject dbObj) {
		ProteinRelationModel model = new ProteinRelationModel();
		String nxmlId = (String) dbObj.get("nxmlId");
		System.out.println("nxmlId "+nxmlId);
		return null;
	}

}
