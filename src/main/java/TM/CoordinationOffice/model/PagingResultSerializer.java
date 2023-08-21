package TM.CoordinationOffice.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

public class PagingResultSerializer extends JsonSerialize<PagingResult> {

    @Override
    public void serialize(PagingResult value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null)
            gen.writeStartObject();
        gen.writeNumberField("NumberOfItem", value.getNumberOfItem());
        gen.writeNumberField("PageSize", value.getPageSize());
        gen.writeNumberField("CurrentSize", value.getCurrentPage());
        gen.writeNumberField("NumberOfPage", value.getNumberOfPage());
        gen.writeEndObject();
    }
}
