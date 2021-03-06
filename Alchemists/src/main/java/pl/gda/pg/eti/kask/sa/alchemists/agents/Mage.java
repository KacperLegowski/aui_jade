package pl.gda.pg.eti.kask.sa.alchemists.agents;

import jade.core.AID;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.FindServiceBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.mage.MageBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.mage.RequestDrugBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.mage.RequestHerbBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.mage.RequestPotionBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.ontology.*;

/**
 *
 * @author psysiu
 */
public class Mage extends BaseAgent {

    public Mage() {
    }

    @Override
    protected void setup() {
        super.setup();
        SequentialBehaviour behaviour = new SequentialBehaviour(this);

        behaviour.addSubBehaviour(new FindServiceBehaviour(this, "alchemist") {

            @Override
            protected void onResult(DFAgentDescription[] services) {
                if (services != null && services.length > 0) {
                    AID alchemist = services[0].getName();
                    SellPotion action = new SellPotion(new Potion("Potion"));
                    RequestPotionBehaviour request = new RequestPotionBehaviour(Mage.this, alchemist, action);
                    ((SequentialBehaviour) getParent()).addSubBehaviour(request);

                }
            }
        });

        behaviour.addSubBehaviour(new FindServiceBehaviour(this, "herbalist") {

            @Override
            protected void onResult(DFAgentDescription[] services) {
                if (services != null && services.length > 0) {
                    AID herbalist = services[0].getName();
                    SellHerb action = new SellHerb(new Herb("Herbata"));
                    RequestHerbBehaviour request = new RequestHerbBehaviour(Mage.this, herbalist, action);
                    ((SequentialBehaviour) getParent()).addSubBehaviour(request);

                }
            }
        });
        behaviour.addSubBehaviour(new FindServiceBehaviour(this, "diler") {

            @Override
            protected void onResult(DFAgentDescription[] services) {
                if (services != null && services.length > 0) {
                    AID armorist = services[0].getName();
                    SellDrug action = new SellDrug(new Drug("Narkotyki"));
                    RequestDrugBehaviour request = new RequestDrugBehaviour(Mage.this, armorist, action);
                    ((SequentialBehaviour) getParent()).addSubBehaviour(request);

                }
            }
        });

        addBehaviour(behaviour);
        addBehaviour(new MageBehaviour(behaviour, this));
    }

}
