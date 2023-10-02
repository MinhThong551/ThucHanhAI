package agentAB;

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		/*
				A B
				C D

				0: Up
				1: Down
				2: Left
				3: Right
		 */
		Environment env = new Environment(Environment.LocationState.CLEAN, Environment.LocationState.DIRTY, Environment.LocationState.DIRTY, Environment.LocationState.DIRTY);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION_A);

		env.step(5);
	}
}
