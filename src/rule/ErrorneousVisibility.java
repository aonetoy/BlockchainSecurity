package rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import context.*;
import node.*;
import util.ValidationRule;

public class ErrorneousVisibility implements ValidationRule{
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
		
		FunctionDefinitionContext functionDefinitionContext = new FunctionDefinitionContext();
		Map<String, String> FunctionDefinitionList = functionDefinitionContext.getAllFunctionDefinitionsWithPublicVisibility();
		
		for(Entry<String, String> entry : FunctionDefinitionList.entrySet()) {
			String count = (String)entry.getKey();
			count = count.split(":")[0];
			characterCounts.add(count);
		}
	}

	@Override
	public Criticity getRuleCriticity() {
	    return Criticity.MINOR;
	}

	@Override
	public String getRuleName() {
	    return "ErrorneousVisibility";
	}

	@Override
	public String getComment() {
	    return "Make sure specify visibility as public";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}
