package rule;

import java.util.ArrayList;
import java.util.List;

import context.*;
import node.*;
import util.ValidationRule;

public class ErroneousConstructorName implements ValidationRule{
	List<String> characterCounts = new ArrayList<String>();
	
	@Override
	public boolean isImplement() {
		return true;
	}

	@Override
	public void analyze() {
		if(!characterCounts.isEmpty()) {
			characterCounts.clear();
		}
		
		ContractContext contractContext = new ContractContext();
		List<ContractDefinition> contractList = contractContext.getAllContract();
		
		FunctionDefinitionContext functionDefinitionContext = new FunctionDefinitionContext();
		List<FunctionDefinition> functionDefinitionList = functionDefinitionContext.getAllFunctionDefinitions();
		
		for(FunctionDefinition functionDefinition : functionDefinitionList) {
			for(ContractDefinition contract : contractList) {
				if(functionDefinition.getName().equalsIgnoreCase(contract.getName())) {
					String count1 = (String)functionDefinition.getSrc();
					count1 = count1.split(":")[0];
					characterCounts.add(count1);
					String count2 = (String)contract.getSrc();
					count2 = count2.split(":")[0];
					characterCounts.add(count2);
				}
			}
		}
	}

	@Override
	public Criticity getRuleCriticity() {
	    return Criticity.MAJOR;
	}

	@Override
	public String getRuleName() {
	    return "ErroneousConstructorName";
	}

	@Override
	public String getComment() {
	    return "Have same contract name and function name";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}
