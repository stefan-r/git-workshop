package de.tilmanpotthof.workshop;


import com.fasterxml.jackson.databind.JsonMappingException;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/example")
public class ExampleWebservice {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response example() throws JsonMappingException {
    List<WorkshopParticipant> workshopParticipants = new ArrayList<>();

	workshopParticipants.add(new WorkshopParticipant("Dietmar Hermann", "Nasenbär")
            .addAnsweredQuestion("Wenn Palmöl aus Palmen gemacht wird, woraus wird dann Babyöl gemacht?"));
	
    workshopParticipants.add(new WorkshopParticipant("Tilman Potthof", "Workshop-Leiter")
            .addAnsweredQuestion("Wo ist der Workshop?")
            .addOpenQuestion("Wo ist die Kaffee-Maschine?"));

	workshopParticipants.add(new WorkshopParticipant("Dietmar Hermann", "Nasenbär")
            .addAnsweredQuestion("Warum lief das Huhn über die Straße?")
            .addOpenQuestion("Wer ist Chuck Norris?"));
			
    return Response.ok(workshopParticipants).build();
  }

}
