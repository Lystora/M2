import skuad.agentu.AgentUDescriptor;
import skuad.agentu.AgentUObserver;
import skuad.agentu.ServerAU;
import skuad.agentu.util.AgentLogger;
import skuad.agentu.util.AgentUAdapter;
import skuad.util.time.Pulse;


public class AgentLogPulse extends AgentUAdapter{
    public void start(AgentUDescriptor aud, int ctx){
        Pulse pulse = aud.loopPulse("pulse", 1000, 3000, true);
    }
    public void behavior(AgentUDescriptor aud, Pulse pulse){
        aud.log("Je pulse !");
    }
    public static void main(String[] args){
        ServerAU server = ServerAU.newServer(null);
        int agent_id = server.createAgent(AgentLogPulse.class, "agent");
        
        AgentUObserver obs = new AgentLogger(server, AgentLogger.LOG | AgentLogger.STATE);
        server.addAgentObserver(agent_id, obs);
        server.runAgent(agent_id);
    }
}
