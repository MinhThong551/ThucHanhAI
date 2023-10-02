package agentAB;

import static agentAB.Environment.LOCATION_A;
import static agentAB.Environment.LOCATION_B;
import static agentAB.Environment.LocationState.DIRTY;
import static agentAB.Environment.SUCK_DIRT;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		String location = p.getAgentLocation();

		if(p.getLocationState() == DIRTY) {
			return Environment.SUCK_DIRT;
		} else if(location.equals(LOCATION_A)) {
			return Environment.MOVE_RIGHT;
		} else if(location.equals(LOCATION_B)) {
			return Environment.MOVE_LEFT;
		}
		return NoOpAction.NO_OP;
		
	}
}