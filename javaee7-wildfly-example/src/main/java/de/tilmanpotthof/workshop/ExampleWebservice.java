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

	workshopParticipants.add(new WorkshopParticipant("Dietmar Hermann", "Nasenb�r")
            .addAnsweredQuestion("Wenn Palm�l aus Palmen gemacht wird, woraus wird dann Baby�l gemacht?"));
	
    workshopParticipants.add(new WorkshopParticipant("Tilman Potthof", "Workshop-Leiter")
            .addAnsweredQuestion("Wo ist der Workshop?")
            .addOpenQuestion("Wo ist die Kaffee-Maschine?"));

	workshopParticipants.add(new WorkshopParticipant("Dietmar Hermann", "Nasenb�r")
            .addAnsweredQuestion("Warum lief das Huhn �ber die Stra�e?")
            .addOpenQuestion("Wer ist Chuck Norris?"));
			
	workshopParticipants.add(new WorkshopParticipant("Robert Rembold", "LE Embedded Systems")
            .addAnsweredQuestion("Wo liegen die Workshop-Unterlagen?")
            .addOpenQuestion("Was hat es mit der 42 auf sich?"));
			
    return Response.ok(workshopParticipants).build();
  }

}
