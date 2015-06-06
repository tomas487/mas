package mas.agents;

import mas.MC;
import mas.agents.Agent;
import mas.core.Core;
import mas.messages.Message;

/**
 * Agent task is print actual simulation time in clock format when he receive print message
 * 
 * @author Tomas
 *
 */
public class PrintAgent extends Agent {

    public PrintAgent() {
        super.setAgentId(MC.printAgent);
    }

    @Override
    public void processMessage(Message message, Core core) {
        switch (message.getCode()) {
        case MC.print:
            printTime(core.getSimulationTime());
            break;
        }
    }

    private void printTime(long time) {
        int seconds = (int) time % 60;
        int minutes = (int) ((time / 60) % 60);
        int hours = (int) ((time / (60 * 60)) % 24);

        System.out.println(hours + ":" + minutes + ":" + seconds);
    }

}
