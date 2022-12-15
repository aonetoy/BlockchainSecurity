package rule;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import context.*;
import node.*;
import util.ValidationRule;

public class ShortAddress implements ValidationRule{
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
		
		FunctionCallContext functionCallContext = new FunctionCallContext();
    	List<FunctionCall> functionCalls = functionCallContext.getAllFunctionCalls();
    	
    	for(FunctionCall functionCall : functionCalls) {
			JSONArray arguments = functionCall.getArguments();
			for(int i=0;i<arguments.size();i++) {
				JSONObject argument = (JSONObject)arguments.get(i);
				JSONObject typeDes = (JSONObject)argument.get("typeDescriptions");
				String typeStr = (String)typeDes.get("typeString");
				if(typeStr.equalsIgnoreCase("address")) {
					String count = (String)functionCall.getSrc();
					count = count.split(":")[0];
					characterCounts.add(count);
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
	    return "ShortAddress";
	}

	@Override
	public String getComment() {
	    return "Function argument has address, check data length";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}
