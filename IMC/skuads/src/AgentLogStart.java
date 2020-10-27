import skuad.*;
import skuad.agentu.AgentU;
import skuad.agentu.AgentUDescriptor;
import skuad.agentu.ServerAU;
import skuad.agentu.util.AgentUAdapter;

public class AgentLogStart extends AgentUAdapter{
    
    public void start(AgentUDescriptor aud ,int ctx){
        System.out.println("Je suis en vie !");
    }
    public static void main(String[] args){
        ServerAU server = ServerAU.newServer(null);
        int agent_id = server.createAgent((Class<? extends AgentU>) AgentLogStart.class, "agent1");
        server.runAgent(agent_id);
    }
}