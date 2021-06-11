package kodlamaio.hrms.core.business;


import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;

public class BusinessControls {

	public static Result control(Result... rules) {
		for (Result rule:rules) {
			if(!rule.isSuccess()) {
				return rule;
			}
		}
		return null;
		
	}
	
}
