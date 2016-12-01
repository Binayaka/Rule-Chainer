package com.binayaka.future;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is our default implementation of the chain interface.
 * 
 * @author Binayaka
 * 
 */
public class Chainer implements Chain {
	private List<Rule<?, ?>> queue = new ArrayList<>();
	private Object lastResult = null;
	private boolean chainExecuted = false;

	@Override
	public Chain chainRule(Rule<?, ?> rule) {
		if (chainExecuted) {
			throw new IllegalStateException(
					"This chain already has had its executeChain called. Please use a different chain, or re-write your code to call executeChain at the end");
		}
		queue.add(rule);
		return this;
	}

	@Override
	public Object getLastRuleResult() {
		return lastResult;
	}

	@Override
	public void executeChain() {
		chainExecuted = true;
		int level = -1;
		for (Rule<?, ?> chainedRule : queue) {
			try {
				level++;
				if (chainedRule.useLastResultFromChain()) {
					chainedRule.setLastRuleResult(lastResult);
				}
				lastResult = chainedRule.run();
			} catch (Throwable t) {
				Logger.getGlobal().log(Level.SEVERE, "Failed in level " + level, t);
				chainedRule.callError();
				break;
			}
		}
	}

}
