package pl.gda.pg.eti.kask.sa.alchemists.agents;

import lombok.Getter;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.RegisterServiceBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.behaviours.diler.DilerBehaviour;
import pl.gda.pg.eti.kask.sa.alchemists.ontology.Drug;

import java.util.ArrayList;
import java.util.List;

public class Diler extends BaseAgent {


    @Getter
    private final List<Drug> drugs = new ArrayList<>();


    public Diler(){

    }

    @Override
    protected void setup() {
        super.setup();
        filDrugs();
        addBehaviour(new RegisterServiceBehaviour(this,"diler"));
        addBehaviour(new DilerBehaviour(this));
    }

    private void filDrugs(){
        Object[] arguments = getArguments();
        if(arguments != null){
            for(Object arg : arguments) {
                 drugs.add(new Drug(arg.toString()));
            }
        }
    }
}
