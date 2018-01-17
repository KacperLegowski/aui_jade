package pl.gda.pg.eti.kask.sa.alchemists.behaviours.diler;
import jade.content.Predicate;
import jade.content.onto.basic.Result;
import jade.core.AID;
import pl.gda.pg.eti.kask.sa.alchemists.agents.Diler;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.ActionBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.ontology.SellDrug;

public class SellDrugBehaviour extends ActionBehaviour<SellDrug, Diler> {

    public SellDrugBehaviour(Diler agent, SellDrug action, String conversationId, AID participant) {
        super(agent, action, conversationId, participant);
    }

    @Override
    protected Predicate performAction() {
        if (myAgent.getDrugs().contains(action.getDrug())) {
            return new Result(action, action.getDrug());
        } else {
            return null;
        }
    }

}
