package mas.agents;

import mas.MC;
import mas.agents.Agent;
import mas.core.Core;
import mas.messages.Message;

/**
 * Agent task is to plane next "tick" of clock and ask PrintAgent to print time
 * 
 * @author Tomas
 *
 */
public class TickAgent extends Agent {

    public TickAgent() {
        super.setAgentId(MC.tickAgent);
    }

    @Override
    public void processMessage(Message message, Core core) {
        switch (message.getCode()) {
        case MC.tick:
            core.sendMessage(new Message(MC.tickAgent, MC.tick, core.getSimulationTime() + 1));
            core.sendMessage(new Message(MC.printAgent, MC.print, core.getSimulationTime()));
            break;
        }
    }

}
