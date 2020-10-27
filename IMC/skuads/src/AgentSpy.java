import skuad.agentu.AgentUDescriptor;
import skuad.agentu.AgentUObserver;
import skuad.agentu.ServerAU;
import skuad.agentu.util.AgentLogger;
import skuad.agentu.util.AgentUAdapter;
import skuad.ubiquity.space.Avatar;
import skuad.ubiquity.space.Participant;
import skuad.ubiquity.space.ParticipantListener;
import skuad.ubiquity.space.Space;
import skuad.util.time.Pulse;

public class AgentSpy extends AgentUAdapter{
    public final static String social_specif = " area : world;";
    public void start(AgentUDescriptor aud, int ctx){
        aud.getAvatar("Obs");
        Pulse pulse = aud.loopPulse("pulse", 3000, 1000, true);
    }
    public void behavior(AgentUDescriptor aud, Pulse pulse){
        Avatar agent_avatar = aud.getAvatar("area");
        if(agent_avatar != null){
            
        }
    }
    public void notifyPlugAvatar(AgentUDescriptor aud, String name, Avatar avatar, int contexte){
        Space space = avatar.getSpace();
        space.addParticipantListener((ParticipantListener) this);
    }

    public void participantAdded(Participant p){
        //on log l'arrivée d'un participant
    
    }

    public void participantRemoved(Participant p){
        //on log le départ d'un participant
    }
    public static void main(String[] args){
        ServerAU server = ServerAU.newServer(null);
        int agent_id = server.createAgent(AgentSpy.class, "agent");
        AgentUObserver obs = new AgentLogger(server, AgentLogger.LOG | AgentLogger.STATE);
        server.addAgentObserver(agent_id, obs);
        server.runAgent(agent_id);
        server.setSocialPlug(agent_id, "area", "world", "my_pass", "my_id");
    }
}
