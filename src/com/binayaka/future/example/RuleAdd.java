package com.binayaka.future.example;

import com.binayaka.future.AbstractRule;

/**
 * This will add two numbers
 * 
 * @author Binayaka
 *
 */
public class RuleAdd extends AbstractRule<Integer, Void> {

	@Override
	public Integer defineActualCallback() {
		int val = 2 + 3;
		setLastRuleResult(val);
		System.out.println("Rule Addition res is " + val);
		return val;
	}

	@Override
	public Void defineErrorCallback() {
		return null;
	}

}
