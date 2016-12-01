package com.binayaka.future.example;

import com.binayaka.future.AbstractRule;

public class RuleSubtract extends AbstractRule<Integer, Void> {

	@Override
	public Integer defineActualCallback() {
		Integer val = (Integer) getLastResultFromChain();
		val = val - 15;
		setLastRuleResult(val);
		System.out.println("Rule Subtraction res is " + val);
		return val;
	}

	@Override
	public Void defineErrorCallback() {
		return null;
	}

	@Override
	public boolean useLastResultFromChain() {
		return true;
	}
}
