package com.binayaka.future;

/**
 * This will allow us to chain rules. <br/>
 * The implementations should follow the rule that if any rule in the chain
 * fails, the chain should break<br/>
 * <br/>
 * <br/>
 * <b>This should only be used for complex cases, where the if conditions
 * reaches spaghetti levels</b><br/>
 * For normal cases, you are better off using simpler if-else cases
 * 
 * @author Binayaka
 * 
 */
public interface Chain {

	/**
	 * This will allow the implementation to chain required rules
	 * 
	 * @param rule
	 * @return the chain object itself. This allows for chaining such as
	 *         {@link #chainRule(Rule)}.{@link #chainRule(Rule)}
	 */
	public Chain chainRule(Rule<?, ?> rule);

	/**
	 * This will return the result of the last rule, if any.
	 * 
	 * @return
	 */
	public Object getLastRuleResult();

	/**
	 * This will execute all the chained rules, in a FIFO manner. The chain
	 * should break on the first error occurred. Ideally, the chain should also
	 * give information on the level that the chain broke<br/>
	 * If any {@link #chainRule(Rule)} is called after calling
	 * {@link #executeChain()}, it will throw an {@link IllegalStateException}
	 */
	public void executeChain();

}
