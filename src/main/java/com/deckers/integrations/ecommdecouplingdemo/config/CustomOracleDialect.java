package com.deckers.integrations.ecommdecouplingdemo.config;
import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.tool.schema.extract.spi.SequenceInformationExtractor;

public class CustomOracleDialect extends Oracle10gDialect {

	@Override
	   public SequenceInformationExtractor getSequenceInformationExtractor() {
	      return AppSequenceInformationExtractor.INSTANCE;
	   }
	
	@Override
    public String getQuerySequencesString() {
        return "SELECT SEQUENCE_OWNER, SEQUENCE_NAME, greatest(MIN_VALUE,-9223372036854775807) MIN_VALUE,\n" +
                "Least(MAX_VALUE, 9223372036854775808) MAX_VALUE, INCREMENT_BY,CYCLE_FLAG, ORDER_FLAG, CACHE_SIZE,\n" +
                "Least(greatest(LAST_NUMBER, -9223372036854775807), 9223372036854775808) LAST_NUMBER from ALL_SEQUENCES";
    }
}