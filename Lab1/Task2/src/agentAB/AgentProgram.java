package agentAB;

import static agentAB.Environment.LOCATION_A;
import static agentAB.Environment.LOCATION_B;
import static agentAB.Environment.LOCATION_C;
import static agentAB.Environment.LOCATION_D;
import static agentAB.Environment.LocationState.DIRTY;
import static agentAB.Environment.MOVE_DOWN;
import static agentAB.Environment.MOVE_LEFT;
import static agentAB.Environment.MOVE_RIGHT;
import static agentAB.Environment.MOVE_UP;

import java.util.Random;

public class AgentProgram {

  public Action execute(Percept p) {// location, status
    String location = p.getAgentLocation();
    Action action = randomAction();
    if (p.getLocationState() == DIRTY) {
      return Environment.SUCK_DIRT;
    } else if (location.equals(LOCATION_A)) {
      if (action.equals(MOVE_UP) || action.equals(MOVE_LEFT)) {
        return null;
      }
      return action;

    } else if (location.equals(LOCATION_B)) {
      if (action.equals(MOVE_UP) || action.equals(MOVE_RIGHT)) {
        return null;
      }
      return action;
    } else if (location.equals(LOCATION_C)) {
      if(action.equals(MOVE_DOWN) || action.equals(MOVE_LEFT)) {
        return null;
      }
      return action;
    } else if (location.equals(LOCATION_D)) {
      if(action.equals(MOVE_DOWN) || action.equals(MOVE_RIGHT)) {
        return null;
      }
      return action;
    }
    return NoOpAction.NO_OP;
  }

  public Action randomAction() {
    Random random = new Random();
    Action action = null;
    int randomIndex = random.nextInt(4);
    switch (randomIndex) {
      case 0:
        action = MOVE_UP;
        break;
      case 1:
        action = MOVE_DOWN;
        break;
      case 2:
        action = MOVE_LEFT;
        break;
      case 3:
        action = MOVE_RIGHT;
        break;
      default:
        action = null;
        break;
    }
    return action;
  }

}