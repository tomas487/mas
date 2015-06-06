package mas.core;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import mas.agents.Agent;
import mas.exceptions.CausalityException;
import mas.messages.Message;

public class Core {

    /**
     * actual time of simulation
     */
    private long simulationTime;
    /**
     * maximum time of simulation
     */
    private long simulationEndTime;
    /**
     * list of actual messages
     */
    private List<Message> messages;
    /**
     * list of registered agents
     */
    private List<Agent> agents;

    public Core() {
        this.simulationTime = 0;
        this.messages = new LinkedList<Message>();
        this.agents = new LinkedList<Agent>();
    }

    public void sendMessage(Message message) {
        messages.add(message);
        Collections.sort(messages);
    }

    public long getSimulationTime() {
        return simulationTime;
    }

    public long getSimulationEndTime() {
        return simulationEndTime;
    }

    public void setSimulationEndTime(long simulationEndTime) {
        this.simulationEndTime = simulationEndTime;
    }

    public void registerAgent(Agent agent) {
        agents.add(agent);
    }

    /**
     * start simulation
     */
    public void simulate() {
        try {
            sim();
        } catch (CausalityException e) {
            e.printStackTrace();
        }
    }

    private void sim() throws CausalityException {
        start();
        while (!messages.isEmpty() && simulationTime < simulationEndTime) {
            Message message = messages.get(0);
            messages.remove(0);
            sendMessageToAgent(message);
        }
        end();
    }

    private void start() {
        System.out.println("Simulation started");
    }

    private void end() {
        System.out.println("Simulation ended");
    }

    /**
     * sends messages to agents
     * 
     * @param message
     * @throws CausalityException
     */
    private void sendMessageToAgent(Message message) throws CausalityException {
        for (Agent agent : agents) {
            if (agent.getAgentId() == message.getReceiver()) {
                if (message.getTime() >= simulationTime) {
                    simulationTime = message.getTime();
                    agent.processMessage(message, this);
                } else {
                    throw new CausalityException("You can not send message to the past!");
                }
                break;
            }
        }

    }
}
