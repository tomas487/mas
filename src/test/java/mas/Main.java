package mas;

import org.junit.Test;

import mas.agents.PrintAgent;
import mas.agents.TickAgent;
import mas.core.Core;
import mas.messages.Message;

public class Main {

    @Test
    public void simulationTest() {
        Core c = new Core();

        // end time of simulation
        c.setSimulationEndTime(10000);

        // add agents to simulation
        c.registerAgent(new TickAgent());
        c.registerAgent(new PrintAgent());

        // initial message
        c.sendMessage(new Message(MC.tickAgent, MC.tick, 0));

        // start simulation
        c.simulate();
    }

}
