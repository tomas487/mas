package mas.agents;

import mas.core.Core;
import mas.messages.Message;

/**
 * abstract ancestor for all agents registered in the system
 * 
 * @author Tomas
 *
 */
public abstract class Agent {

    /**
     * unique identifier for every agent
     */
    private int agentId;

    /**
     * this method is called when agent receive message
     * 
     * @param message
     *            received message
     * @param core
     *            instance on simulation core
     */
    public abstract void processMessage(Message message, Core core);

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

}
