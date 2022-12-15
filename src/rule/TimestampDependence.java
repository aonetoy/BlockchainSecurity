package rule;

import java.util.ArrayList;
import java.util.List;

import context.*;
import node.*;
import util.ValidationRule;

public class TimestampDependence implements ValidationRule{
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
		
		ExpressionContext expressionContext= new ExpressionContext();
		List<Expression> expressions = expressionContext.getAllExpressions();
		for(Expression expression : expressions) {
			if(expression.getMemberName() != null && expression.getMemberName().equals("timestamp")) {
				String count = (String) expression.getSrc();
				count = count.split(":")[0];
				characterCounts.add(count);
			}
		}
	}

	@Override
	public Criticity getRuleCriticity() {
	    return Criticity.MAJOR;
	}

	@Override
	public String getRuleName() {
	    return "TimestampDependence";
	}

	@Override
	public String getComment() {
	    return "block.timestamp derives timestamp dependence";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}
