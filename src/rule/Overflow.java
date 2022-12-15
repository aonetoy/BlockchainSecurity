package rule;

import java.util.ArrayList;
import java.util.List;

import context.*;
import node.*;
import util.ValidationRule;

public class Overflow implements ValidationRule{
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
		ExpressionContext expressionContext = new ExpressionContext();
		List<Expression> expressions = expressionContext.getAllOperations();
		
		ContractContext contractContext = new ContractContext();
		List<ContractDefinition> ContractList = contractContext.getAllContract();
		
		for(ContractDefinition contract : ContractList) {
			if(!contract.getName().equals("SafeMath")) {
				for(Expression expression : expressions) {
					String operator = expression.getOperator();
					if(operator.equals("+") || operator.equals("+=")) {
						String count = (String) expression.getSrc();
						count = count.split(":")[0];
						characterCounts.add(count);
					}
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
	    return "Overflow";
	}

	@Override
	public String getComment() {
	    return "Note the operation of integer variables";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}