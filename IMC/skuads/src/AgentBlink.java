import skuad.agentu.AgentUDescriptor;
import skuad.agentu.AgentUObserver;
import skuad.agentu.ServerAU;
import skuad.agentu.util.AgentLogger;
import skuad.agentu.util.AgentUAdapter;
import skuad.util.time.Pulse;
import skuad.uda.Device;

public class AgentBlink extends AgentUAdapter{
    public final static String physical_specif = "lumiere : LIGHT;";
    public final static String rule = " { device : [ TYPE , LIGHT ] }";
    public boolean light_state = true;
    public void start(AgentUDescriptor aud, int ctx){
        Pulse pulse = aud.loopPulse("pulse", 3000, 1000, true);
    }
    public void behavior(AgentUDescriptor aud, Pulse pulse){
        Device devlight = aud.getDevice("lumiere");
        if(devlight != null){
            devlight.action(0, light_state ? 1 : 0);
            light_state = !light_state;
            aud.log("Device plugged");
        }else{
            aud.log("Device not plugged");
        }
    }
    public static void main(String[] args){
        ServerAU server = ServerAU.newServer(null);
        int agent_id = server.createAgent(AgentBlink.class, "agent");
        AgentUObserver obs = new AgentLogger(server, AgentLogger.LOG | AgentLogger.STATE);
        server.addAgentObserver(agent_id, obs);
        server.runAgent(agent_id);
        server.addPhysicalPlugRule(agent_id, "lumiere", rule);
    }
}
