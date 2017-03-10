package junit.com.cBioportal.DaoImpl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cBioPortal.model.ProteinRelationModel;
import com.cBioPortal.service.CBioPortalService;
import com.cBioPortal.util.Contants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * @author Amit Test the DB operations
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class DaoImplTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CBioPortalService cBioPortalService;
	
	private String srcProteinCode = "TP53";
	
	private String srcProteinCodes = "TP53,ZNF83,PIK3CA,rs12947788";
	
	private static ObjectMapper mapper = new ObjectMapper();
	//@Test
	public void installSchemaTest() {
		try {

			Set<String> finalRelatedProteinCodes = new HashSet<String>();
			finalRelatedProteinCodes.addAll(processParticipantA(srcProteinCode));
			finalRelatedProteinCodes.addAll(processParticipantB(srcProteinCode));
			populateProteinRelationModel(srcProteinCode,finalRelatedProteinCodes );
		} catch (Exception exc) {
			fail(exc.getMessage());
		}
	}
	
	//@Test
	public void testRelation() {
		try {
			List<String> srcProteinCodeList =Arrays.asList(srcProteinCodes.split(","));
			Set<String> finalRelatedProteinCodes = new HashSet<String>();
			finalRelatedProteinCodes.addAll(srcProteinCodeList);
			cBioPortalService.populateProteinRelationModel(finalRelatedProteinCodes);
			
			
		} catch (Exception exc) {
			fail(exc.getMessage());
		}
	}
	
	@Test
	public void testIndexCards() {
		try {
		
			System.out.println(cBioPortalService.getIndexCards(srcProteinCode,"a"));
			
			
		} catch (Exception exc) {
			fail(exc.getMessage());
		}
	}
	
	//@Test
	public void populateData() {
		try {
			List<String> l = new ArrayList<String>();
			l.add("protein");
			l.add("ZNF83");
			l.add("KDM6A");
			l.add("TP53");
			l.add("PIK3CA");
			l.add("FMN2");
			l.add("ARID1A");
			l.add("FGFR3");
			l.add("CREBBP");
			l.add("HRAS");
			l.add("ERBB2");
			l.add("STAG2");
			l.add("RB1");
			l.add("AQP7");
			l.add("EP300");
			l.add("SYNE2");
			l.add("SYNE1");
			l.add("ZNF233");
			l.add("HMCN1");
			l.add("KRTAP5-10");
			l.add("XIRP2");
			l.add("ERCC2");
			l.add("PRG4");
			l.add("TTN");
			l.add("CSMD3");
			l.add("NOTCH2");
			l.add("ESRRA");
			l.add("ZFP36L1");
			l.add("ESPL1");
			l.add("ERBB3");
			l.add("PLXNB2");
			l.add("FGFRL1");
			l.add("KRAS");
			l.add("KMT2A");
			l.add("DCHS2");
			l.add("DNAH8");
			l.add("RELN");
			l.add("GOLGB1");
			l.add("ACTB");
			l.add("MACF1");
			l.add("AHNAK");
			l.add("DMXL1");
			l.add("UBR4");
			l.add("CABIN1");
			l.add("ANK3");
			l.add("NF1");
			l.add("NFE2L3");
			l.add("VPS13B");
			l.add("NHS");
			l.add("PKHD1");
			l.add("TG");
			l.add("TSC1");
			l.add("PTEN");
			l.add("CDKN2A");
			l.add("BRAF");
			l.add("AKT1");
			l.add("AKT3");
			l.add("SUCLG2");
			l.add("KMT2D");
			l.add("KMT2C");
			l.add("FAT1");
			l.add("SETD2");
			l.add("NOTCH1");
			l.add("CDKN1A");
			l.add("ATRX");
			l.add("ATM");
			l.add("RICTOR");
			l.add("SMARCA4");
			l.add("PBRM1");
			l.add("NOTCH3");
			l.add("NFKB1");
			l.add("BRCA1");
			l.add("TERT");
			l.add("CDK12");
			l.add("HSP90AA1");
			l.add("BAP1");
			l.add("ETV6");
			l.add("WAS");
			l.add("PIK3CG");
			l.add("NOTCH4");
			l.add("EPHA8");
			l.add("PTPRD");
			l.add("ALK");
			l.add("DICER1");
			l.add("PTPRT");
			l.add("ERBB4");
			l.add("APC");
			l.add("GLI3");
			l.add("WNK1");
			l.add("MTOR");
			l.add("ARID2");
			l.add("EPHA2");
			l.add("CDH1");
			l.add("PIK3R1");
			l.add("TET1");
			l.add("KEAP1");
			l.add("ATR");
			l.add("CDK8");
			l.add("EPHB1");
			l.add("MCL1");
			l.add("ASXL1");
			l.add("AR");
			l.add("KIT");
			l.add("YAP1");
			l.add("PALB2");
			l.add("MPL");
			l.add("NTRK2");
			l.add("IRS2");
			l.add("FAT4");
			l.add("IKBKE");
			l.add("NRAS");
			l.add("RAD50");
			l.add("PIK3C2G");
			l.add("MUC16");
			l.add("SPTAN1");
			l.add("FLG");
			l.add("PDE4DIP");
			l.add("BIRC6");
			l.add("DNAH3");
			l.add("RYR2");
			l.add("MUC17");
			l.add("DNAH10");
			l.add("GPR98");
			l.add("DNAH5");
			l.add("VPS13D");
			l.add("ZFHX4");
			l.add("PKHD1L1");
			l.add("PLEC");
			l.add("LYST");
			l.add("AHNAK2");
			l.add("LRP1B");
			l.add("DNAH11");
			l.add("SACS");
			l.add("KIAA0100");
			l.add("ABCA13");
			l.add("RYR3");
			l.add("DOT1L");
			l.add("ADAMTS12");
			l.add("TCHH");
			l.add("CELSR3");
			l.add("HERC1");
			l.add("OBSCN");
			l.add("NEB");
			l.add("NBPF10");
			l.add("SRRM2");
			l.add("MYH9");
			l.add("LAMA3");
			l.add("TNS3");
			l.add("ARHGAP5");
			l.add("USH2A");
			l.add("MYO3A");
			l.add("PCDHA10");
			l.add("PPFIBP2");
			l.add("UBR5");
			l.add("UBAP2L");
			l.add("HECW1");
			l.add("LRP2");
			l.add("ZNF142");
			l.add("GPR112");
			l.add("COL6A3");
			l.add("MDN1");
			l.add("PALLD");
			l.add("BRCA2");
			l.add("DOCK7");
			l.add("KIAA0556");
			l.add("SPHKAP");
			l.add("DLG5");
			l.add("FLT3");
			l.add("GH1");
			l.add("SMG5");
			l.add("TSHZ3");
			l.add("LAMA2");
			l.add("MYH2");
			l.add("TDO2");
			l.add("PKD1L1");
			l.add("CEP192");
			l.add("FAM208B");
			l.add("XRN1");
			l.add("HRNR");
			l.add("RALGAPA1");
			l.add("APOB");
			l.add("C11orf30");
			l.add("CELSR1");
			l.add("PRKCQ");
			l.add("Unknown");
			l.add("LAMA1");
			l.add("SCAMP3");
			l.add("ULK2");
			l.add("NRG1");
			l.add("COL9A1");
			l.add("WBSCR17");
			l.add("RBFOX1");
			l.add("KALRN");
			l.add("DST");
			l.add("CCSER1");
			l.add("FAM178B");
			l.add("UBA7");
			l.add("ABCD4");
			l.add("SHOC2");
			l.add("TTC7B");
			l.add("VCPIP1");
			l.add("SDK1");
			l.add("AFF2");
			l.add("FAM47C");
			l.add("ZNF415");
			l.add("TBC1D5");
			l.add("ALS2CR12");
			l.add("MACROD2");
			l.add("NEDD9");
			l.add("GDPD4");
			l.add("USP34");
			l.add("ARHGEF4");
			l.add("CCER1");
			l.add("LGALS9");
			l.add("ARAP2");
			l.add("RTEL1");
			l.add("NLRP5");
			l.add("KCNT2");
			l.add("COG2");
			l.add("HPS3");
			l.add("GPR179");
			l.add("CD36");
			l.add("GYS1");
			l.add("MAGEA1");
			l.add("C2orf78");
			l.add("ARMC12");
			l.add("ZBED4");
			l.add("BZRAP1");
			l.add("MUC2");
			l.add("PCGF2");
			l.add("DMD");
			l.add("NSD1");
			l.add("WEE1");
			l.add("PRDM16");
			l.add("SPEN");
			l.add("MAP3K1");
			l.add("TMEM132D");
			l.add("POMK");
			l.add("CACNA1E");
			l.add("SI");
			l.add("SCN3A");
			l.add("KIF26B");
			l.add("GATA3");
			l.add("COL11A2");
			l.add("TET3");
			l.add("ITPR3");
			l.add("CBFB");
			l.add("PRDM14");
			l.add("AGRN");
			l.add("HUWE1");
			l.add("TRPM3");
			l.add("DNAH2");
			l.add("ADAMTS7");
			l.add("COL7A1");
			l.add("HLA-A");
			l.add("HDLBP");
			l.add("EGFR");
			l.add("HERC2");
			l.add("NCOR2");
			l.add("AKAP9");
			l.add("UTRN");
			l.add("TBX3");
			l.add("STAB2");
			l.add("COL22A1");
			l.add("COL12A1");
			l.add("SHANK2");
			l.add("THADA");
			l.add("NCOR1");
			l.add("ARID1B");
			l.add("LAMB3");
			l.add("RUNX1");
			l.add("SETD1A");
			l.add("ROS1");
			l.add("THSD7A");
			l.add("HYDIN");
			l.add("MTMR4");
			l.add("FSIP2");
			l.add("VPS13C");
			l.add("LRRC7");
			l.add("EFCAB5");
			l.add("DIDO1");
			l.add("PCLO");
			l.add("HEATR1");
			l.add("FAM135B");
			l.add("MTHFR");
			l.add("USP32");
			l.add("CSMD1");
			l.add("SYCP2");
			l.add("DNAH6");
			l.add("SNAP91");
			l.add("MAP2K4");
			l.add("ANKRD30A");
			l.add("NBAS");
			l.add("TMEM132B");
			l.add("PRRC2B");
			l.add("MUC12");
			l.add("MUC4");
			l.add("FCGBP");
			l.add("MUC5B");
			l.add("CROCCP2");
			l.add("RYR1");
			l.add("SPTA1");
			l.add("FAT3");
			l.add("MXRA5");
			l.add("CMYA5");
			l.add("RNF213");
			l.add("NCOA3");
			l.add("TBP");
			l.add("FOXA1");
			l.add("ZNF384");
			l.add("LRP1");
			l.add("CSMD2");
			l.add("CHD4");
			l.add("SSPO");
			l.add("RP11-32B5.7");
			l.add("SPI1");
			l.add("TENM1");
			l.add("CTNNB1");
			l.add("ZNF208");
			l.add("FBN2");
			l.add("PRUNE2");
			l.add("VCAN");
			l.add("KIAA1109");
			l.add("DNAH7");
			l.add("PXDN");
			l.add("COL6A6");
			l.add("C17orf97");
			l.add("FLG2");
			l.add("DNAH9");
			l.add("CENPF");
			l.add("IFITM3");
			l.add("CIT");
			l.add("IGSF10");
			l.add("BAZ2B");
			l.add("WWP1");
			l.add("ZIC3");
			l.add("OTOP1");
			l.add("ERRFI1");
			l.add("ALB");
			l.add("USP25");
			l.add("GXYLT1");
			l.add("UBR3");
			l.add("ND5");
			l.add("ALMS1");
			l.add("NBEA");
			l.add("FRAS1");
			l.add("EYS");
			l.add("COL11A1");
			l.add("FASN");
			l.add("DYNC2H1");
			l.add("FREM2");
			l.add("SMAD4");
			l.add("PEG3");
			l.add("NALCN");
			l.add("SF3B1");
			l.add("MT-CO2");
			l.add("PCDH15");
			l.add("TGFBR2");
			l.add("TTI1");
			l.add("PCDHB6");
			l.add("MYO9A");
			l.add("OR2M5");
			l.add("MAP1B");
			l.add("ABCA12");
			l.add("ADAMTS20");
			l.add("EPC1");
			l.add("TOP2A");
			l.add("GRIA1");
			l.add("PRKDC");
			l.add("CDH4");
			l.add("SLIT2");
			l.add("ITIH6");
			l.add("TEX15");
			l.add("MAGEA6");
			l.add("SUV420H1");
			l.add("MT-ND5");
			l.add("MT-CYB");
			l.add("MT-ND4");
			l.add("MT-CO1");
			l.add("RNF43");
			l.add("TENM3");
			l.add("WDFY4");
			l.add("MT-ND1");
			l.add("MT-CO3");
			l.add("THSD7B");
			l.add("MT-ND2");
			l.add("CACNA1H");
			l.add("GNAS");
			l.add("BAI3");
			l.add("ZNF536");
			l.add("TENM4");
			l.add("FAT2");
			l.add("ASPM");
			l.add("PKD1");
			l.add("ANKRD11");
			l.add("MYO15A");
			l.add("SCN5A");
			l.add("CUBN");
			l.add("COL5A1");
			l.add("DNAH1");
			l.add("TRRAP");
			l.add("MKI67");
			l.add("ZFHX3");
			l.add("DSCAM");
			l.add("ZNF814");
			l.add("RP11-407N17.3");
			l.add("TUBBP5");
			l.add("PCMTD1");
			l.add("TMPRSS13");
			l.add("NBPF9");
			l.add("MST1L");
			l.add("C10orf113");
			l.add("RBMXL3");
			l.add("ZAN");
			l.add("ATXN1");
			l.add("COL18A1");
			l.add("MAGEC1");
			l.add("KRT4");
			l.add("PRB4");
			l.add("CDK2AP2P2");
			l.add("COL14A1");
			l.add("DGKB");
			l.add("SLC35G6");
			l.add("LOXHD1");
			l.add("FRG1B");
			l.add("NLRP1");
			l.add("FOLH1");
			l.add("PRAMEF4");
			l.add("DNAH14");
			l.add("RGPD3");
			l.add("KRTAP10-7");
			l.add("HDGFRP2");
			l.add("MGAM");
			l.add("TPTE");
			l.add("PREX2");
			l.add("BAGE2");
			l.add("DMBT1");
			l.add("MROH2B");
			l.add("SCN10A");
			l.add("DOCK3");
			l.add("CACNA2D3");
			l.add("PCSK5");
			l.add("DCC");
			l.add("UNC79");
			l.add("RP11-492D6.3");
			l.add("PAPPA2");
			l.add("MYH1");
			l.add("CNTNAP2");
			l.add("COL4A5");
			l.add("SCN11A");
			l.add("COL3A1");
			l.add("RP1");
			l.add("XDH");
			l.add("MYH4");
			l.add("TNR");
			l.add("CD163L1");
			l.add("CD163");
			l.add("GRIN2B");
			l.add("DSG4");
			l.add("VWF");
			l.add("C6");
			l.add("C1orf173");
			l.add("ABCA4");
			Set<String> finalRelatedProteinCodes = new HashSet<String>();
			finalRelatedProteinCodes.addAll(processParticipantA(srcProteinCode));
			finalRelatedProteinCodes.addAll(processParticipantB(srcProteinCode));
			populateProteinRelationModel(srcProteinCode,finalRelatedProteinCodes );
		} catch (Exception exc) {
			fail(exc.getMessage());
		}
	}
	
	
	private Set<String> processParticipantA(String srcProteinCode){
		Set<String> returnRelateProteinsB = new HashSet<String>();
		BasicDBObject  baseQuery = new BasicDBObject ();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("mitreCard.extracted_information.participant_a.entity_text", srcProteinCode));
		obj.add(new BasicDBObject("mitreCard.extracted_information.participant_b.entity_type", "protein"));
		baseQuery.put("$and", obj);
		DBCursor cursor = mongoTemplate.getDb().getCollection("IndexCard").find(baseQuery);
		returnRelateProteinsB = getRelatedProteinSet(cursor, Contants.PARTICIPANT_A);
		return returnRelateProteinsB;
	}
	
	private Set<String> processParticipantB(String srcProteinCode){
		Set<String> returnRelateProteinsB = new HashSet<String>();
		BasicDBObject  baseQuery = new BasicDBObject ();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("mitreCard.extracted_information.participant_b.entity_text", srcProteinCode));
		obj.add(new BasicDBObject("mitreCard.extracted_information.participant_a.entity_type", "protein"));
		baseQuery.put("$and", obj);
		DBCursor cursor = mongoTemplate.getDb().getCollection("IndexCard").find(baseQuery);
		returnRelateProteinsB = getRelatedProteinSet(cursor, Contants.PARTICIPANT_B);
		return returnRelateProteinsB;
	}
	private Set<String> getRelatedProteinSet(DBCursor cursor , String participantType){
		Set<String> relatedProteinSet = new HashSet<String>();
		DBObject basicObject;
		while (cursor.hasNext()) {
			basicObject = cursor.next();
			if(participantType.equalsIgnoreCase("a"))
				relatedProteinSet.add(((DBObject)((DBObject)((DBObject)basicObject.get("mitreCard")).get("extracted_information")).get("participant_b")).get("entity_text").toString());
			else
				relatedProteinSet.add(((DBObject)((DBObject)((DBObject)basicObject.get("mitreCard")).get("extracted_information")).get("participant_a")).get("entity_text").toString());
		}
		return relatedProteinSet;
	}
	
	private ProteinRelationModel populateProteinRelationModel(String srcProtein, Set<String> relatedProteins){
		ProteinRelationModel model = new ProteinRelationModel();
		model.setSrcProteinCode(srcProtein);
		model.setAssociatedProteinCodes(relatedProteins);
		return model;
	}
	
	public static void main(String[] args){
		
	}

}
