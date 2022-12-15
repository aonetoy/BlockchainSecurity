package rule;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import context.FunctionCallContext;
import node.FunctionCall;
import util.ValidationRule;

public abstract class TransferEther implements ValidationRule{
	List<String> characterCounts = new ArrayList<String>();
	
	@Override
	public void analyze() {
		characterCounts.clear();
		
		/*
		...
		check the weakness
		...
		*/

	}

	public Criticity getRuleCriticity() {
	    return Criticity.MAJOR;
	}

	@Override
	public String getRuleName() {
	    return "Transfer-Ether";
	}

	@Override
	public String getComment() {
	    return "Incorrect function usage in Ether transmission, Use transfer() instead";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}
