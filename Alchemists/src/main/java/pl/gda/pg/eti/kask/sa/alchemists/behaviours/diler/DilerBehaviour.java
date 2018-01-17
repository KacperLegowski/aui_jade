package pl.gda.pg.eti.kask.sa.alchemists.behaviours.diler;

import jade.content.onto.basic.Action;
import jade.core.AID;
import pl.gda.pg.eti.kask.sa.alchemists.agents.Diler;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.WaitingBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.ontology.SellDrug;

public class DilerBehaviour extends WaitingBehaviour<Diler>{

    public DilerBehaviour(Diler agent) {
        super(agent);
    }

    @Override
    protected void action(Action action, String conversationId, AID participant) {
        if (action.getAction() instanceof SellDrug) {
            myAgent.addBehaviour(new SellDrugBehaviour(myAgent, (SellDrug) action.getAction(), conversationId, participant));
        }
    }

}
