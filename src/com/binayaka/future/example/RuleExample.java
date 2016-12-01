package com.binayaka.future.example;

import com.binayaka.future.Chainer;

/**
 * This is the running example
 * 
 * @author Binayaka
 *
 */
public class RuleExample {
	public static void main(String[] args) {
		RuleExample example = new RuleExample();
		example.runScenario1();
	}

	public void runScenario1() {
		Chainer chain = new Chainer();
		chain.chainRule(new RuleAdd()).chainRule(new RuleSubtract());
		chain.executeChain();
	}
}
